package org.mule.soql.query.condition;

import org.mule.soql.query.SOQLData;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SetBasedCondition extends SOQLData implements Condition {
    private ConditionField conditionField;
    private SetOperator operator;
    private ConditionSet conditionSet;

    public SetBasedCondition() {
    }

    public SetBasedCondition(ConditionField conditionField, SetOperator operator, ConditionSet conditionSet) {
        this.conditionField = conditionField;
        this.operator = operator;
        this.conditionSet = conditionSet;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(conditionField != null) {
            sb.append(conditionField.toSOQLText());
        }

        sb.append(" ").append(operator).append(" ");

        if(conditionSet != null) {
            sb.append(conditionSet.toSOQLText());
        }

        return sb.toString();
    }

    public ConditionField getConditionField() {
        return conditionField;
    }

    public void setConditionField(ConditionField conditionField) {
        this.conditionField = conditionField;
    }

    public SetOperator getOperator() {
        return operator;
    }

    public void setOperator(SetOperator operator) {
        this.operator = operator;
    }

    public ConditionSet getConditionSet() {
        return conditionSet;
    }

    public void setConditionSet(ConditionSet conditionSet) {
        this.conditionSet = conditionSet;
    }

}
