package org.mule.soql.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.soql.SOQLDataBaseVisitor;
import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.SOQLParserHelper;
import org.mule.soql.query.SOQLQuery;
import org.mule.soql.query.SOQLSubQuery;
import org.mule.soql.query.select.FieldSpec;
import org.mule.soql.query.select.FunctionCallSpec;
import org.mule.soql.query.select.SelectSpec;
import org.mule.soql.query.select.TypeOf;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class SOQLDataVisitorTest {
	private SOQLDataVisitor selectSpecPrefixVisitor;

	@Before
	public void setUp() {
		selectSpecPrefixVisitor = new SOQLDataBaseVisitor<String>(){
			String prefix = "SelectSpec";

			public String visitSOQLSubQuery(SOQLSubQuery soqlSubQuery) {
				return prefix + ": " + soqlSubQuery.toSOQLText();
			}

			public String visitFieldSpec(FieldSpec fieldSpec) {
				return prefix + ": " + fieldSpec.toSOQLText();
			}

			public String visitFunctionCallSpec(FunctionCallSpec functionCallSpec) {
				return prefix + ": " + functionCallSpec.toSOQLText();
			}

			public String visitTypeOf(TypeOf typeOf) {
				return prefix + ": " + typeOf.toSOQLText();
			}

		};
	}

	@Test
	public void testSOQLLine() throws IOException {
		String line = "select id, format(id) formatedId, (select id, createddate from campaignmembers order by createddate limit 1) from campaign bla where recordtype.name like 'FDB %'";

		SOQLQuery query = SOQLParserHelper.createSOQLData(line);

		List<SelectSpec> selectSpecs = query.getSelectSpecs();

		StringBuilder sb = new StringBuilder();

		sb.append(" | ");

		for(SelectSpec selectSpec : selectSpecs) {
			sb.append(selectSpecPrefixVisitor.visit(selectSpec)).append(" | ");
		}

		assertEquals(" | SelectSpec: id | SelectSpec: format(id) formatedId | SelectSpec: (SELECT id,createddate FROM campaignmembers ORDER BY createddate LIMIT 1) | ", sb.toString());
	}

	@After
	public void tearDown() throws IOException {
	}

}
