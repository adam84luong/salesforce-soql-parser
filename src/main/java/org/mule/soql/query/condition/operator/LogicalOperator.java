package org.mule.soql.query.condition.operator;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public abstract class LogicalOperator extends SOQLData implements Condition {
    protected Condition leftCondition;
    protected Condition rightCondition;

    public LogicalOperator() {
    }

    public LogicalOperator(Condition leftCondition, Condition rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();
        
        if(leftCondition != null) {
            sb.append(leftCondition.toSOQLText());
        }
        
        sb.append(" ").append(this.getOperatorName()).append(" ");

        if(rightCondition != null) {
            sb.append(rightCondition.toSOQLText());
        }
        
        return sb.toString();
    }

    protected abstract String getOperatorName();

    public Condition getRightCondition() {
        return rightCondition;
    }

    public void setRightCondition(Condition rightCondition) {
        this.rightCondition = rightCondition;
    }

    public Condition getLeftCondition() {
        return leftCondition;
    }

    public void setLeftCondition(Condition leftCondition) {
        this.leftCondition = leftCondition;
    }

}
