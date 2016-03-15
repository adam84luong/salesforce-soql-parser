package org.mule.soql.query.clause;

import org.mule.soql.SOQLDataVisitor;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class GroupByCubeClause extends GroupByClause {

    public GroupByCubeClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("GROUP BY").append(" ").append("CUBE");

        sb.append(" ").append("(");

        sb.append(this.groupBySpecsToSOQLText());

        sb.append(")");

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitGroupByCubeClause(this);
    }

}