package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class LikeConditionNode extends SOQLCommonTree {

    public LikeConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "LIKE_CONDITION"));
    }

}
