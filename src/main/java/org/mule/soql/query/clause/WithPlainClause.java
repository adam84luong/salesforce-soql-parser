package org.mule.soql.query.clause;

import org.mule.soql.query.condition.FieldBasedCondition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class WithPlainClause extends WithClause {
    private FieldBasedCondition fieldBasedCondition;

    public WithPlainClause() {
    }

    public WithPlainClause(FieldBasedCondition fieldBasedCondition) {
        this.fieldBasedCondition = fieldBasedCondition;
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("WITH").append(" ");

        if(fieldBasedCondition != null) {
            sb.append(fieldBasedCondition.toSOQLText());
        }

        return sb.toString();
    }

    public FieldBasedCondition getFieldBasedCondition() {
        return fieldBasedCondition;
    }

    public void setFieldBasedCondition(FieldBasedCondition fieldBasedCondition) {
        this.fieldBasedCondition = fieldBasedCondition;
    }

}
