package org.mule.soql.query.clause;

import org.mule.soql.SOQLDataVisitor;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class GroupByPlainClause extends GroupByClause {

    public GroupByPlainClause() {
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitGroupByPlainClause(this);
    }

}
