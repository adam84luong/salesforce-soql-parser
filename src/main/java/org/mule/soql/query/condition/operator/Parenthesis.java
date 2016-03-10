package org.mule.soql.query.condition.operator;

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

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");

        if(condition != null) {
            sb.append(condition.toSOQLText());
        }

        sb.append(")");

        return sb.toString();
    }

    @Override
    protected String getOperatorName() {
        return "()";
    }

}
