package org.mule.soql.query.condition.operator;

import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class OrOperator extends LogicalOperator {

    public OrOperator() {
        super();
    }

    public OrOperator(Condition leftCondition, Condition rightCondition) {
        super(leftCondition, rightCondition);
    }

    @Override
    protected String getOperatorName() {
        return "OR";
    }

}
