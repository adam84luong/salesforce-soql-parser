package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FunctionCallNode extends SOQLCommonTree {

    public FunctionCallNode(int tokenType) {
        super(new CommonToken(tokenType, "FUNCTION_CALL"));
    }

}
