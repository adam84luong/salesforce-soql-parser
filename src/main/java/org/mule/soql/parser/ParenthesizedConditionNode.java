package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class ParenthesizedConditionNode extends SOQLCommonTree {

    public ParenthesizedConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "PARENTHESIZED_CONDITION"));
    }

}
