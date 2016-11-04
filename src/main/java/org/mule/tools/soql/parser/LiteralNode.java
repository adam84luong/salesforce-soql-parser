/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.tools.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.tools.soql.query.data.Literal;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class LiteralNode extends SOQLCommonTree {

    public LiteralNode(int tokenType) {
        super(new CommonToken(tokenType, "LITERAL"));
    }

    @Override
    public Literal createSOQLData() {
        Literal literal = new Literal();

        this.processFirstNode(literal);
        this.processSecondNode(literal);

        return literal;
    }

    private void processFirstNode(Literal literal) {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return; }

        literal.setValue(child.getText());
    }

    private void processSecondNode(Literal literal) {
        CommonTree child = (CommonTree) this.getChild(1);

        if(child == null) { return; }

        literal.setParameter(SOQLCommonTreeUtils.getTextAsInteger(child));
    }

}
