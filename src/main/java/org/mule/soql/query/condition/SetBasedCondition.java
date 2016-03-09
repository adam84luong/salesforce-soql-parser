package org.mule.soql.query.condition;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.condition.operator.SetOperator;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SetBasedCondition extends SOQLData implements Condition {
    private ConditionField conditionField;
    private SetOperator operator;
    private ConditionSet set;

    public SetBasedCondition() {
    }

    public SetBasedCondition(ConditionField conditionField, SetOperator operator, ConditionSet set) {
        this.conditionField = conditionField;
        this.operator = operator;
        this.set = set;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(conditionField != null) {
            sb.append(conditionField.toSOQLText());
        }

        sb.append(" ").append(operator).append(" ");

        if(set != null) {
            sb.append(set.toSOQLText());
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

    public ConditionSet getSet() {
        return set;
    }

    public void setSet(ConditionSet set) {
        this.set = set;
    }

}
