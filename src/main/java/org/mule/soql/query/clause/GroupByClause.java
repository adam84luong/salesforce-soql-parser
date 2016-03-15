package org.mule.soql.query.clause;

import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.group.GroupBySpec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/8/16.
 */
public abstract class GroupByClause extends SOQLAbstractData {
    protected List<GroupBySpec> groupBySpecs = new ArrayList<GroupBySpec>();

    public GroupByClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("GROUP BY").append(" ");

        sb.append(this.groupBySpecsToSOQLText());

        return sb.toString();
    }

    protected String groupBySpecsToSOQLText() {
        return this.createSOQLListText(groupBySpecs, ",");
    }

    public void addGroupBySpec(GroupBySpec groupBySpec) {
        if(groupBySpec == null) { return; }

        if(groupBySpecs == null) {
            groupBySpecs = new ArrayList<GroupBySpec>();
        }

        groupBySpecs.add(groupBySpec);
    }

    public List<GroupBySpec> getGroupBySpecs() {
        return groupBySpecs;
    }

}
