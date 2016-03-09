package org.mule.soql.query;

import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class WhereClause extends ConditionClause {

    public WhereClause() {
    }

    public WhereClause(Condition condition) {
        super(condition);
    }

    protected String getConditionName() {
        return "WHERE";
    }

}
