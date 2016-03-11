package org.mule.soql.query.clause;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public abstract class ConditionClause extends SOQLData {
    protected Condition condition;

    public ConditionClause() {
    }

    public ConditionClause(Condition condition) {
        this.condition = condition;
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getConditionName()).append(" ");

        if(condition != null) {
            sb.append(condition.toSOQLText());
        }

        return sb.toString();
    }

    protected abstract String getConditionName();

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
