package org.mule.soql.parser;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.InputMismatchException;
import org.junit.Test;
import org.mule.soql.SOQLParserHelper;
import org.mule.soql.exception.SOQLParsingException;

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
