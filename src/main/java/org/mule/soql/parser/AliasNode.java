package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class AliasNode extends SOQLCommonTree {

    public AliasNode(int tokenType) {
        super(new CommonToken(tokenType, "ALIAS"));
    }

}
