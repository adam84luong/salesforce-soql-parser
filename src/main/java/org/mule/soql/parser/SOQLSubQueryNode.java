package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SOQLSubQueryNode extends SOQLCommonTree {

    public SOQLSubQueryNode(int tokenType) {
        super(new CommonToken(tokenType, "SOQL_SUBQUERY"));
    }

}
