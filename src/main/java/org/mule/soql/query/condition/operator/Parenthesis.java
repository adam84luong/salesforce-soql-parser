package org.mule.soql.query.condition.operator;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class Parenthesis extends LogicalUnaryOperator {

    public Parenthesis() {
    }

    public Parenthesis(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");

        if(condition != null) {
            sb.append(condition.toSOQLText());
        }

        sb.append(")");

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitParenthesis(this);
    }

    @Override
    protected String getOperatorName() {
        return "()";
    }

}
