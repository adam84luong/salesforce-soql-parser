package org.mule.soql.query.condition;

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
    protected String getLogicalOperatorName() {
        return "OR";
    }

}
