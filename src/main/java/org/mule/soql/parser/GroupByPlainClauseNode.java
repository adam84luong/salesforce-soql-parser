package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class GroupByPlainClauseNode extends SOQLCommonTree {

    public GroupByPlainClauseNode(int tokenType) {
        super(new CommonToken(tokenType, "GROUP_BY_PLAIN_CLAUSE"));
    }

}
