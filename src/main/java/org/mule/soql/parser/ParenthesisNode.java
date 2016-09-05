/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.condition.Condition;
import org.mule.soql.query.condition.operator.Parenthesis;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class ParenthesisNode extends SOQLCommonTree {

    public ParenthesisNode(int tokenType) {
        super(new CommonToken(tokenType, "PARENTHESIS"));
    }

    @Override
    public Parenthesis createSOQLData() {
        Parenthesis parenthesis = new Parenthesis();

        this.processFirstNode(parenthesis);

        return parenthesis;
    }

    private void processFirstNode(Parenthesis parenthesis) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.fillCondition(child, parenthesis);
    }

    private void fillCondition(CommonTree node, Parenthesis parenthesis) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        parenthesis.setCondition((Condition) soqlNode.createSOQLData());
    }

}
