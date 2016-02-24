package org.mule.soql.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.runtime.tree.CommonTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.soql.exception.SOQLParsingException;

public class SOQLParserTest {
	private SOQLParserHelper parserHelper;
	
	@Before
	public void setUp() {
		parserHelper = new SOQLParserHelper();
	}

	@Test
	public void testLargeFile() throws IOException {
		this.testSOQLinFile("SOQLLarge.txt");
	}

	@Test
	public void testRecentFile() throws IOException {
		this.testSOQLinFile("SOQLRecent.txt");
	}

	private void testSOQLinFile(String fileName) throws IOException {
		Integer i = 1;
		Integer errors = 0;

		BufferedReader reader = this.getFile("/" + fileName);

		try {
			while (reader.ready()) {
				String s = reader.readLine();
				String line = s.substring(1, s.length()-1);

				try {
					CommonTree tree = parserHelper.parseTextToTree(line);
					assertNotNull(tree);

				} catch (SOQLParsingException e) {
					System.out.println("Test " + i + ": " + e.getMessage());
					errors++;
				}

				i++;
			}
		} finally {
			reader.close();
		}

		assertTrue(errors == 0);
	}
	
	@After
	public void tearDown() throws IOException {
	}

	private BufferedReader getFile(String fileName) {
		InputStream inputStream = getClass().getResourceAsStream(fileName);
		return new BufferedReader(new InputStreamReader(inputStream));
	}
		
}
