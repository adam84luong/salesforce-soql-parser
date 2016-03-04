package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class TypeofWhenThenClauses extends CommonTree {

    public TypeofWhenThenClauses(int tokenType) {
        super(new CommonToken(tokenType, "TYPEOF_WHEN_THEN_CLAUSE_LIST"));
    }

}
