package org.mule.soql.query.condition;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.condition.operator.ComparisonOperator;
import org.mule.soql.query.data.Literal;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FieldBasedCondition extends SOQLData implements Condition {
    private ConditionField conditionField;
    private ComparisonOperator operator;
    private Literal literal;

    public FieldBasedCondition() {
    }

    public FieldBasedCondition(ConditionField conditionField, ComparisonOperator operator, Literal literal) {
        this.conditionField = conditionField;
        this.operator = operator;
        this.literal = literal;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(conditionField != null) {
            sb.append(conditionField.toSOQLText());
        }

        sb.append(" ").append(operator).append(" ");

        if(literal != null) {
            sb.append(literal.toSOQLText());
        }

        return sb.toString();
    }

    public ConditionField getConditionField() {
        return conditionField;
    }

    public void setConditionField(ConditionField conditionField) {
        this.conditionField = conditionField;
    }

    public ComparisonOperator getOperator() {
        return operator;
    }

    public void setOperator(ComparisonOperator operator) {
        this.operator = operator;
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(Literal literal) {
        this.literal = literal;
    }

}
