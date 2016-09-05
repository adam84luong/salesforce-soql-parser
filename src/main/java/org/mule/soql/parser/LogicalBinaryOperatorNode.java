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
import org.mule.soql.query.condition.operator.AndOperator;
import org.mule.soql.query.condition.operator.LogicalBinaryOperator;
import org.mule.soql.query.condition.operator.OrOperator;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class LogicalBinaryOperatorNode extends SOQLCommonTree {

    public LogicalBinaryOperatorNode(Token t) {
        super(t);
    }

    @Override
    public LogicalBinaryOperator createSOQLData() {
        LogicalBinaryOperator logicalBinaryOperator = null;

        if(SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.AND)) {
            logicalBinaryOperator = new AndOperator();
        } else if(SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.OR)) {
            logicalBinaryOperator = new OrOperator();
        }

        this.fillLogicalOperator(logicalBinaryOperator);

        return logicalBinaryOperator;
    }

    private void fillLogicalOperator(LogicalBinaryOperator logicalBinaryOperator) {
        if(logicalBinaryOperator == null) { return; }

        this.processFirstNode(logicalBinaryOperator);
        this.processSecondNode(logicalBinaryOperator);
    }

    private void processFirstNode(LogicalBinaryOperator logicalBinaryOperator) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.fillLeftCondition(child, logicalBinaryOperator);
    }

    private void processSecondNode(LogicalBinaryOperator logicalBinaryOperator) {
        CommonTree child = (CommonTree) this.getChild(1);

        this.fillRightCondition(child, logicalBinaryOperator);
    }

    private void fillLeftCondition(CommonTree node, LogicalBinaryOperator logicalBinaryOperator) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        logicalBinaryOperator.setLeftCondition((Condition) soqlNode.createSOQLData());
    }

    private void fillRightCondition(CommonTree node, LogicalBinaryOperator logicalBinaryOperator) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        logicalBinaryOperator.setRightCondition((Condition) soqlNode.createSOQLData());
    }

}
