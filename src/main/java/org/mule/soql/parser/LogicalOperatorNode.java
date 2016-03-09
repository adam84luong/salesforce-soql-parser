package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.condition.operator.AndOperator;
import org.mule.soql.query.condition.Condition;
import org.mule.soql.query.condition.operator.LogicalOperator;
import org.mule.soql.query.condition.operator.OrOperator;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class LogicalOperatorNode extends SOQLCommonTree {

    public LogicalOperatorNode(Token t) {
        super(t);
    }

    @Override
    public LogicalOperator createSOQLData() {
        if(SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.AND)) {
            return this.createLogicalOperator(new AndOperator());
        } else if(SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.OR)) {
            return this.createLogicalOperator(new OrOperator());
        }
        return null;
    }

    private LogicalOperator createLogicalOperator(LogicalOperator logicalOperator) {

        this.processFirstNode(logicalOperator);
        this.processSecondNode(logicalOperator);

        return logicalOperator;
    }

    private void processFirstNode(LogicalOperator logicalOperator) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.createLeftCondition(child, logicalOperator);
    }

    private void createLeftCondition(CommonTree node, LogicalOperator logicalOperator) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        logicalOperator.setLeftCondition((Condition) soqlNode.createSOQLData());
    }

    private void processSecondNode(LogicalOperator logicalOperator) {
        CommonTree child = (CommonTree) this.getChild(1);

        this.createRightCondition(child, logicalOperator);
    }

    private void createRightCondition(CommonTree node, LogicalOperator logicalOperator) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        logicalOperator.setRightCondition((Condition) soqlNode.createSOQLData());
    }

}
