package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FunctionCallSpec extends CommonTree {

    public FunctionCallSpec(int tokenType) {
        super(new CommonToken(tokenType, "FUNCTION_CALL_SPEC"));
    }

}
