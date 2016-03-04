package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class TypeofWhenThenClauses extends SOQLCommonTree {

    public TypeofWhenThenClauses(int tokenType) {
        super(new CommonToken(tokenType, "TYPEOF_WHEN_THEN_CLAUSES"));
    }

}
