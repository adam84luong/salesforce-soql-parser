package org.mule.soql.query.clause;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class GroupByRollupClause extends GroupByClause {

    public GroupByRollupClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("ROLLUP");

        sb.append(" ").append("(");

        sb.append(super.toSOQLText());

        sb.append(")");

        return sb.toString();
    }

}