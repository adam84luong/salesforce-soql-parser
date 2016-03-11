package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.Literal;
import org.mule.soql.query.condition.ConditionField;
import org.mule.soql.query.condition.FieldBasedCondition;
import org.mule.soql.query.condition.operator.ComparisonOperator;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class FieldBasedConditionNode extends SOQLCommonTree {

    public FieldBasedConditionNode(int tokenType) {
        super(new CommonToken(tokenType, "FIELD_BASED_CONDITION"));
    }

    @Override
    public FieldBasedCondition createSOQLData() {
        FieldBasedCondition fieldBasedCondition = new FieldBasedCondition();

        this.processFirstNode(fieldBasedCondition);
        this.processSecondNode(fieldBasedCondition);
        this.processThirdNode(fieldBasedCondition);

        return fieldBasedCondition;
    }

    private void processFirstNode(FieldBasedCondition fieldBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.fillConditionField(child, fieldBasedCondition);
    }

    private void processSecondNode(FieldBasedCondition fieldBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(1);

        this.fillComparisonOperator(child, fieldBasedCondition);
    }

    private void processThirdNode(FieldBasedCondition fieldBasedCondition) {
        CommonTree child = (CommonTree) this.getChild(2);

        this.fillLiteral(child, fieldBasedCondition);
    }

    private void fillConditionField(CommonTree node, FieldBasedCondition fieldBasedCondition) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        fieldBasedCondition.setConditionField((ConditionField) soqlNode.createSOQLData());
    }

    private void fillComparisonOperator(CommonTree node, FieldBasedCondition fieldBasedCondition) {
        String operatorName = SOQLCommonTreeUtils.getOperatorName(node);

        fieldBasedCondition.setOperator(ComparisonOperator.get(operatorName));
    }

    private void fillLiteral(CommonTree node, FieldBasedCondition fieldBasedCondition) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.LITERAL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        fieldBasedCondition.setLiteral((Literal) soqlNode.createSOQLData());
    }

}
