package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class FieldConditionNode extends SOQLCommonTree {

    public FieldConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "FIELD_CONDITION"));
    }

}
