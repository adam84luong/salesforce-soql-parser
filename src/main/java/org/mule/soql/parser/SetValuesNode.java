package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SetValuesNode extends SOQLCommonTree {

    public SetValuesNode(int tokenType) {
        super(new CommonToken(tokenType, "SET_VALUES"));
    }

}
