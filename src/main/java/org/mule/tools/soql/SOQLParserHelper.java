/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.lang.StringUtils;
import org.mule.tools.soql.exception.LexerException;
import org.mule.tools.soql.exception.ParserException;
import org.mule.tools.soql.exception.SOQLParsingException;
import org.mule.tools.soql.parser.SOQLCommonTree;
import org.mule.tools.soql.parser.SOQLLexer;
import org.mule.tools.soql.parser.SOQLParser;
import org.mule.tools.soql.query.SOQLQuery;

/**
 * Helper for the SOQL Parser that simplifies parsing and data structure creation.
 */
public class SOQLParserHelper {

	/**
	 * Parses a SOQL query and creates a friendly data structure with the query's information.
	 * Each part of this structure can be easily transformed back to text.
	 *
	 * @param text String containing the SOQL query to parse
	 * @return {@link SOQLQuery} Friendly SOQL data structure
	 * @throws {@link SOQLParsingException}
     */
	public static SOQLQuery createSOQLData(String text) throws SOQLParsingException {
		SOQLCommonTree tree =  createSOQLParserTree(text);
		return tree.createSOQLData();
	}

	/**
	 * Parses a SOQL query and creates an ANTLR AST tree. The imaginary and key nodes of the tree are of type {@link SOQLCommonTree}.
	 * The leaf and lower nodes are of type {@link CommonTree}.
	 *
	 * @param text String containing the SOQL query to parse
	 * @return {@link SOQLCommonTree} Root node of the ANTLR AST tree
	 * @throws {@link SOQLParsingException}
	 */
	public static SOQLCommonTree createSOQLParserTree(String text) throws SOQLParsingException {
		if(StringUtils.isBlank(text)) {
			throw createEmptyTextException();
		}

		try {
			ANTLRStringStream input = new ANTLRStringStream(text);
			TokenStream tokens = new CommonTokenStream(new SOQLLexer(input));

			SOQLParser parser = new SOQLParser(tokens);
			SOQLParser.soql_query_return ret = parser.soql_query();

			SOQLCommonTree tree = (SOQLCommonTree) ret.getTree();

			if(tree == null) {
				throw createUnexpectedException();
			}

			return tree;

		} catch (LexerException e) {
			throw createParsingException(e.getCause());
		} catch (ParserException e) {
			throw createParsingException(e.getCause());
		} catch (RecognitionException e) {
			throw createParsingException(e);
		}
	}

	private static SOQLParsingException createEmptyTextException() {
		return new SOQLParsingException("The text provided for SOQL parsing is either null or empty.");
	}

	private static SOQLParsingException createUnexpectedException() {
		return new SOQLParsingException("The SOQL tree could not be generated due to an unexpected error.");
	}

	private static SOQLParsingException createParsingException(Throwable t) {
		if(t == null) {
			return new SOQLParsingException();
		}
		if(!(t instanceof RecognitionException)) {
			return new SOQLParsingException(t);
		}
		return createParsingRecognitionException((RecognitionException) t);
	}

	private static SOQLParsingException createParsingRecognitionException(RecognitionException e) {
		String failingText = e.token != null ?  e.token.getText() : null;
		String lineNumber = e.line >= 0 ? new Integer(e.line).toString() : null;
		String charPositionInLine = e.charPositionInLine >= 0 ? new Integer(e.charPositionInLine).toString() : null;

		StringBuilder sb = new StringBuilder();
		sb.append("There was a SOQL parsing error");

		if(StringUtils.isNotBlank(failingText)) {
			sb.append(" close to '").append(failingText).append("'");
		}

		if(StringUtils.isNotBlank(lineNumber) && StringUtils.isNotBlank(charPositionInLine)) {
			sb.append(" (line:").append(lineNumber).append(",position:").append(charPositionInLine).append(")");
		}

		sb.append(".");

		if(e.getMessage() != null) {
			sb.append(" Message: ").append(e.getMessage());
		}

		return new SOQLParsingException(sb.toString(), e);
	}

}
