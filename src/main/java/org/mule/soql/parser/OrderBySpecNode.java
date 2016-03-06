package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class OrderBySpecNode extends SOQLCommonTree {

    public OrderBySpecNode(int tokenType) {
        super(new CommonToken(tokenType, "ORDER_BY_SPEC"));
    }

}
