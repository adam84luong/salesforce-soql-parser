package org.mule.soql.query.condition;

import org.mule.soql.query.SOQLData;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class AndOperator extends LogicalOperator {

    public AndOperator() {
        super();
    }

    public AndOperator(Condition leftCondition, Condition rightCondition) {
        super(leftCondition, rightCondition);
    }

    @Override
    protected String getLogicalOperatorName() {
        return "AND";
    }

}
