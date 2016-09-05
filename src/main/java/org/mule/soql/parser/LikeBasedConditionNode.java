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

        this.fillConditionField(child, likeBasedCondition);
    }

    private void processSecondNode(LikeBasedCondition likeBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(1);

        this.fillLikeString(child, likeBasedCondition);
    }

    private void fillConditionField(CommonTree node, LikeBasedCondition likeBasedCondition) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        likeBasedCondition.setConditionField((ConditionField) soqlNode.createSOQLData());
    }

    private void fillLikeString(CommonTree node, LikeBasedCondition likeBasedCondition) {
        if (node == null) { return; }

        likeBasedCondition.setLikeString(node.getText());
    }

}
