package org.mule.soql.parser;

import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.soql.exception.SOQLParsingException;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public abstract class SOQLParserTest {
	private SOQLParserHelper parserHelper;
	private String line;

	public SOQLParserTest(String line) {
		this.line = this.cleanLine(line);
	}

	private String cleanLine(String line) {
		String tmp = line;
		tmp = StringUtils.removeStart(tmp, "\"");
		tmp = StringUtils.removeEnd(tmp, "\"");
		return tmp;
	}

	@Before
	public void setUp() {
		parserHelper = new SOQLParserHelper();
	}

	@Test
	public void testSOQLLine() throws IOException {
		try {
			CommonTree tree = parserHelper.parseTextToTree(line);
			assertNotNull(tree);
		} catch (SOQLParsingException e) {
			fail(e.getMessage());
		}
	}

	@After
	public void tearDown() throws IOException {
	}

}
