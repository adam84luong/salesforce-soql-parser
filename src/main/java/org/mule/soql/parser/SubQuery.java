package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SubQuery extends CommonTree {

    public SubQuery(int tokenType) {
        super(new CommonToken(tokenType, "SUBQUERY"));
    }

}
