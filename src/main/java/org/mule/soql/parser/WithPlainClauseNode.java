package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class WithPlainClauseNode extends SOQLCommonTree {

    public WithPlainClauseNode(int tokenType) {
        super(new CommonToken(tokenType, "WITH_PLAIN_CLAUSE"));
    }

}
