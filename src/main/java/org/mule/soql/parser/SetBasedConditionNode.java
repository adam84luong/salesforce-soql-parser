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
import org.mule.soql.query.condition.ConditionSet;
import org.mule.soql.query.condition.SetBasedCondition;
import org.mule.soql.query.condition.operator.SetOperator;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SetBasedConditionNode extends SOQLCommonTree {

    public SetBasedConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "SET_BASED_CONDITION"));
    }

    @Override
    public SetBasedCondition createSOQLData() {
        SetBasedCondition setBasedCondition = new SetBasedCondition();

        this.processFirstNode(setBasedCondition);
        this.processSecondNode(setBasedCondition);
        this.processThirdNode(setBasedCondition);

        return setBasedCondition;
    }

    private void processFirstNode(SetBasedCondition setBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.fillConditionField(child, setBasedCondition);
    }

    private void processSecondNode(SetBasedCondition setBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(1);

        this.fillSetOperator(child, setBasedCondition);
    }

    private void processThirdNode(SetBasedCondition setBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(2);

        this.fillConditionSet(child, setBasedCondition);
    }

    private void fillConditionField(CommonTree node, SetBasedCondition setBasedCondition) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        setBasedCondition.setConditionField((ConditionField) soqlNode.createSOQLData());
    }

    private void fillSetOperator(CommonTree node, SetBasedCondition setBasedCondition) {
        String operatorName = SOQLCommonTreeUtils.getOperatorName(node);

        setBasedCondition.setOperator(SetOperator.get(operatorName));
    }

    private void fillConditionSet(CommonTree node, SetBasedCondition setBasedCondition) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.SOQL_SUBQUERY, SOQLParser.SET_VALUES)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        setBasedCondition.setSet((ConditionSet) soqlNode.createSOQLData());
    }

}
