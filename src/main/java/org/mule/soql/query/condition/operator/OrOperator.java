package org.mule.soql.query.condition.operator;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class OrOperator extends LogicalBinaryOperator {

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

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitOrOperator(this);
    }

}
