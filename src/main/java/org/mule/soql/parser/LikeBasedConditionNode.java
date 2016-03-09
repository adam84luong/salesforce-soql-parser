package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.condition.ConditionField;
import org.mule.soql.query.condition.LikeBasedCondition;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class LikeBasedConditionNode extends SOQLCommonTree {

    public LikeBasedConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "LIKE_BASED_CONDITION"));
    }

    @Override
    public LikeBasedCondition createSOQLData() {
        LikeBasedCondition likeBasedCondition = new LikeBasedCondition();

        this.processFirstNode(likeBasedCondition);
        this.processSecondNode(likeBasedCondition);

        return likeBasedCondition;
    }

    private void processFirstNode(LikeBasedCondition likeBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.createConditionField(child, likeBasedCondition);
    }

    private void processSecondNode(LikeBasedCondition likeBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(1);

        this.createLikeString(child, likeBasedCondition);
    }

    private void createConditionField(CommonTree node, LikeBasedCondition likeBasedCondition) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        likeBasedCondition.setConditionField((ConditionField) soqlNode.createSOQLData());
    }

    private void createLikeString(CommonTree node, LikeBasedCondition likeBasedCondition) {
        if (node == null) { return; }

        likeBasedCondition.setLikeString(node.getText());
    }

}
