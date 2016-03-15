package org.mule.soql.query.condition;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.condition.operator.SetOperator;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SetBasedCondition extends SOQLAbstractData implements Condition {
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

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitSetBasedCondition(this);
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
