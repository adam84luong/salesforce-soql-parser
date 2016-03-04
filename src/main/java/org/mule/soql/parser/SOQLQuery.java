package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

import java.util.List;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SOQLQuery extends SOQLCommonTree {

    public SOQLQuery(int tokenType) {
        super(new CommonToken(tokenType, "SOQL_QUERY"));
    }

}
