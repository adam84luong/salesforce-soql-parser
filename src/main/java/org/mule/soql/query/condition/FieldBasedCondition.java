package org.mule.soql.query.condition;

import org.mule.soql.query.Literal;
import org.mule.soql.query.SOQLData;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FieldBasedCondition extends SOQLData implements Condition {
    private ConditionField conditionField;
    private FieldOperator operator;
    private Literal literal;

    public FieldBasedCondition() {
    }

    public FieldBasedCondition(ConditionField conditionField, FieldOperator operator, Literal literal) {
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

    public FieldOperator getOperator() {
        return operator;
    }

    public void setOperator(FieldOperator operator) {
        this.operator = operator;
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(Literal literal) {
        this.literal = literal;
    }

}
