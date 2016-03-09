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

        this.createCondition(child, notOperator);
    }

    private void createCondition(CommonTree node, NotOperator notOperator) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        notOperator.setCondition((Condition) soqlNode.createSOQLData());
    }

}
