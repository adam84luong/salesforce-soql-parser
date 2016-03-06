package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SetConditionNode extends SOQLCommonTree {

    public SetConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "SET_CONDITION"));
    }

}
