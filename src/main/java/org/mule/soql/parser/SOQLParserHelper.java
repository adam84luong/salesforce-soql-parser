package org.mule.soql.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class SOQLParserHelper {
	
	public CommonTree parseTextToTree(String text) {
		CommonTree tree = null;
		
		try {
			ANTLRStringStream input = new ANTLRStringStream(text);
			TokenStream tokens = new CommonTokenStream(new SOQLLexer(input));
			
			SOQLParser parser = new SOQLParser(tokens);
			SOQLParser.select_expression_return ret = parser.select_expression();

			tree = (CommonTree) ret.getTree();
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
		
		return tree;
	}
	
}
