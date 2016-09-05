/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;


import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.condition.Condition;
import org.mule.soql.query.condition.operator.NotOperator;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class NotOperatorNode extends SOQLCommonTree {

    public NotOperatorNode(Token t) {
        super(t);
    }

    @Override
    public NotOperator createSOQLData() {
        NotOperator notOperator = new NotOperator();

        this.processFirstNode(notOperator);

        return notOperator;
    }

    private void processFirstNode(NotOperator notOperator) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.fillCondition(child, notOperator);
    }

    private void fillCondition(CommonTree node, NotOperator notOperator) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        notOperator.setCondition((Condition) soqlNode.createSOQLData());
    }

}
