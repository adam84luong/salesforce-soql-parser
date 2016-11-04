package org.mule.tools.soql;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang.StringUtils;
import org.mule.tools.soql.exception.SOQLParsingException;

import org.mule.soql.parser.SOQLLexer;
import org.mule.soql.parser.SOQLParser;

/**
 * Helper for the SOQL Parser that simplifies parsing.
 */
public class SOQLParserHelper {

	/**
	 * Parses a SOQL query and creates an ANTLR Parse tree.
	 *
	 * @param text String containing the SOQL query to parse
	 * @return {@link ParseTree} Root node of the ANTLR Parse tree
	 * @throws {@link SOQLParsingException}
	 */
	public static ParseTree createSOQLParserTree(String text) throws SOQLParsingException {
		if(StringUtils.isBlank(text)) {
			throw createEmptyTextException();
		}

		try {
			SOQLLexer lexer = new SOQLLexer(new ANTLRInputStream(text));
			lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			SOQLParser parser = new SOQLParser(tokens);
			parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
			parser.setErrorHandler(new BailErrorStrategy());

			ParseTree tree = parser.soql_query();

			if (tree == null) {
				throw createUnexpectedException();
			}

			return tree;
		} catch (ParseCancellationException e) {
			throw createParsingException(e.getCause());
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
		Token token = e.getOffendingToken();

		String failingText = "", lineNumber = "", charPositionInLine = "";

		if(token != null) {
			failingText = token.getText();
			lineNumber = token.getLine() >= 0 ? new Integer(token.getLine()).toString() : null;
			charPositionInLine = token.getCharPositionInLine() >= 0 ? new Integer(token.getCharPositionInLine()).toString() : null;
		}

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
