package org.mule.soql.query.clause;

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

}