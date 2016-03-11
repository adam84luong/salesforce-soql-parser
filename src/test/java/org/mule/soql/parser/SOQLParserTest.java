package org.mule.soql.parser;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.soql.SOQLParserHelper;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;


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
		SOQLCommonTree tree = parserHelper.parseTextToTree(line);

		assertNotNull(tree);

		String soqlText = tree.createSOQLData().toSOQLText();

		assertEquals(line.replaceAll("\\s","").toLowerCase(), soqlText.replaceAll("\\s","").toLowerCase());
	}

	@After
	public void tearDown() throws IOException {
	}

}
