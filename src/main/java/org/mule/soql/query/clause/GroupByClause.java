package org.mule.soql.query.clause;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.group.GroupByField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/8/16.
 */
public abstract class GroupByClause extends SOQLData {
    protected List<GroupByField> groupByFields = new ArrayList<GroupByField>();

    public GroupByClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(groupByFields != null) {
            for(GroupByField groupByField : groupByFields) {
                if(!groupByField.equals(groupByFields.get(0))) {
                    sb.append(",");
                }
                sb.append(groupByField.toSOQLText());
            }
        }

        return sb.toString();
    }

    public void addGroupField(GroupByField groupByField) {
        if(groupByField == null) { return; }

        if(groupByFields == null) {
            groupByFields = new ArrayList<GroupByField>();
        }

        groupByFields.add(groupByField);
    }

    public List<GroupByField> getGroupByFields() {
        return groupByFields;
    }

}
