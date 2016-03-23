package org.mule.soql;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.exception.SOQLParsingException;
import org.mule.soql.parser.SOQLCommonTree;
import org.mule.soql.parser.SOQLLexer;
import org.mule.soql.parser.SOQLParser;
import org.mule.soql.query.SOQLQuery;

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
		try {
			ANTLRStringStream input = new ANTLRStringStream(text);
			TokenStream tokens = new CommonTokenStream(new SOQLLexer(input));

			SOQLParser parser = new SOQLParser(tokens);
			SOQLParser.soql_query_return ret = parser.soql_query();

			SOQLCommonTree tree = (SOQLCommonTree) ret.getTree();

			if(tree == null) {
				throw new SOQLParsingException("The SOQL tree could not be generated due to an unexpected error.");
			}

			return tree;

		} catch (NoViableAltException e) {
			throw new SOQLParsingException("Syntax error close to '" + e.token.getText() + "' (position: " + e.charPositionInLine + ").", e);
		} catch (RecognitionException e) {
			throw new SOQLParsingException("Recognition exception is never thrown, only declared.", e);
		}
	}

}
