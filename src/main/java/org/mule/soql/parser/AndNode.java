package org.mule.soql.parser;

import org.antlr.runtime.Token;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class AndNode extends SOQLCommonTree {

    public AndNode(Token t) {
        super(t);
    }

}
