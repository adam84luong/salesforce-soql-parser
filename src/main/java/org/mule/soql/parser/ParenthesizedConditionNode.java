package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.condition.Condition;
import org.mule.soql.query.condition.ParenthesizedCondition;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class ParenthesizedConditionNode extends SOQLCommonTree {

    public ParenthesizedConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "PARENTHESIZED_CONDITION"));
    }

    @Override
    public ParenthesizedCondition createSOQLData() {
        ParenthesizedCondition parenthesizedCondition = new ParenthesizedCondition();

        this.processFirstNode(parenthesizedCondition);

        return parenthesizedCondition;
    }

    private void processFirstNode(ParenthesizedCondition parenthesizedCondition) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.createCondition(child, parenthesizedCondition);
    }

    private void createCondition(CommonTree node, ParenthesizedCondition parenthesizedCondition) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        parenthesizedCondition.setCondition((Condition) soqlNode.createSOQLData());
    }

}
