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
