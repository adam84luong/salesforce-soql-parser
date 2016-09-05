/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.soql.SOQLParserHelper;
import org.mule.soql.query.SOQLQuery;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;


public abstract class SOQLParserTest {
	private String line;

	public SOQLParserTest(String line) {
		this.line = this.cleanLine(line);
	}

	protected String cleanLine(String line) {
		String tmp = line;
		tmp = StringUtils.removeStart(tmp, "\"");
		tmp = StringUtils.removeEnd(tmp, "\"");
		return tmp;
	}

	@Before
	public void setUp() {
	}

	@Test
	public void testSOQLLine() throws IOException {
		SOQLQuery query = SOQLParserHelper.createSOQLData(line);

		assertNotNull(query);

		String soqlText = query.toSOQLText();

		assertEquals(line.replaceAll("\\s","").toLowerCase(), soqlText.replaceAll("\\s","").toLowerCase());
	}

	@After
	public void tearDown() throws IOException {
	}

}
