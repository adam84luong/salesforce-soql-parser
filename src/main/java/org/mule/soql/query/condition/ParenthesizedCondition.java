package org.mule.soql.query.condition;

import org.mule.soql.query.SOQLData;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class ParenthesizedCondition extends SOQLData implements Condition {
    private Condition condition;

    public ParenthesizedCondition() {
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

    public ParenthesizedCondition(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
