/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.parser;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.InputMismatchException;
import org.junit.Test;
import org.mule.tools.soql.SOQLParserHelper;
import org.mule.tools.soql.exception.SOQLParsingException;

import java.io.IOException;

import static org.junit.Assert.*;

public class SOQLParsingExceptionTest {

	@Test
	public void testNoAltLexerException() throws IOException {
		String line = "select &, id, body from attachment description like 'cp%' order by id";
		try {
			SOQLParserHelper.createSOQLParserTree(line);
			fail("The testcase is supposed to throw an exception");
		} catch (SOQLParsingException e) {
			assertEquals("There was a SOQL parsing error close to ',' (line:1,position:8).", e.getMessage());

			assertTrue(e.getCause() instanceof NoViableAltException);
			NoViableAltException nve = (NoViableAltException) e.getCause();
			assertNotNull(nve.getOffendingToken());
			assertNull(nve.getMessage());
			assertEquals(nve.getOffendingToken().getText(), ",");
			assertEquals(1,nve.getOffendingToken().getLine());
			assertEquals(8,nve.getOffendingToken().getCharPositionInLine());
		}
	}

	@Test
	public void testNoAltParserException() throws IOException {
		String line = "select , id, body from attachment description like 'cp%' order by id";
		try {
			SOQLParserHelper.createSOQLParserTree(line);
			fail("The testcase is supposed to throw an exception");
		} catch (SOQLParsingException e) {
			assertEquals("There was a SOQL parsing error close to ',' (line:1,position:7).", e.getMessage());

			assertTrue(e.getCause() instanceof NoViableAltException);
			NoViableAltException nve = (NoViableAltException) e.getCause();
			assertNotNull(nve.getOffendingToken());
			assertNull(nve.getMessage());
			assertEquals(nve.getOffendingToken().getText(), ",");
			assertEquals(1,nve.getOffendingToken().getLine());
			assertEquals(7,nve.getOffendingToken().getCharPositionInLine());
		}
	}

	@Test
	public void testMismatchParserException() throws IOException {
		String line = "selectin id, body from attachment description like 'cp%' order by id";
		try {
			SOQLParserHelper.createSOQLParserTree(line);
			fail("The testcase is supposed to throw an exception");
		} catch (SOQLParsingException e) {
			assertEquals("There was a SOQL parsing error close to 'selectin' (line:1,position:0).", e.getMessage());

			assertTrue(e.getCause() instanceof InputMismatchException);
			InputMismatchException nve = (InputMismatchException) e.getCause();
			assertNotNull(nve.getOffendingToken());
			assertNull(nve.getMessage());
			assertEquals(nve.getOffendingToken().getText(), "selectin");
			assertEquals(1,nve.getOffendingToken().getLine());
			assertEquals(0,nve.getOffendingToken().getCharPositionInLine());
		}
	}

	@Test
	public void testEmptyTextException() throws IOException {
		String line = "";
		try {
			SOQLParserHelper.createSOQLParserTree(line);
			fail("The testcase is supposed to throw an exception");
		} catch (SOQLParsingException e) {
			assertEquals("The text provided for SOQL parsing is either null or empty.", e.getMessage());
			assertNull(e.getCause());
		}
	}

}
