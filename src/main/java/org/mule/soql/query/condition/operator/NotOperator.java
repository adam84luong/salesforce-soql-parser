package org.mule.soql.query.condition.operator;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class NotOperator extends LogicalUnaryOperator {

    public NotOperator() {
    }

    public NotOperator(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getOperatorName());

        if(condition != null) {
            sb.append(" ").append(condition.toSOQLText());
        }

        return sb.toString();
    }

    @Override
    protected String getOperatorName() {
        return "NOT";
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitNorOperator(this);
    }

}
