package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FunctionParameters extends SOQLCommonTree {

    public FunctionParameters(int tokenType) {
        super(new CommonToken(tokenType, "FUNCTION_PARAMETERS"));
    }

}
