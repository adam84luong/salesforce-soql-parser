package org.mule.soql.query.condition;

import org.mule.soql.query.SOQLData;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class NotOperator extends SOQLData implements Condition {
    private Condition condition;

    public NotOperator() {
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("NOT");

        if(condition != null) {
            sb.append(" ").append(condition.toSOQLText());
        }

        return sb.toString();
    }

    public NotOperator(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
