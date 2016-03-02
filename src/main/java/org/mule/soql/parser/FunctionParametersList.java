package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FunctionParametersList extends CommonTree {

    public FunctionParametersList(int tokenType) {
        super(new CommonToken(tokenType, "FUNCTION_PARAMETERS_LIST"));
    }

}
