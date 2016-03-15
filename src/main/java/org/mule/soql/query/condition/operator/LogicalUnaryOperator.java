package org.mule.soql.query.condition.operator;

import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public abstract class LogicalUnaryOperator extends SOQLAbstractData implements Condition {
    protected Condition condition;

    public LogicalUnaryOperator() {
    }

    public LogicalUnaryOperator(Condition condition) {
        this.condition = condition;
    }

    protected abstract String getOperatorName();

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
