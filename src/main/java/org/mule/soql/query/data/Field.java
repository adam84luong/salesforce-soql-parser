package org.mule.soql.query.data;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.condition.ConditionField;
import org.mule.soql.query.group.GroupBySpec;
import org.mule.soql.query.order.OrderByField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class Field extends SOQLData implements FunctionParameter, ConditionField, OrderByField, GroupBySpec {
    private List<String> objectPrefixNames = new ArrayList<String>();
    private String fieldName;

    public Field() {
    }

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(objectPrefixNames != null) {
            for(String objectPrefixName : objectPrefixNames) {
                sb.append(objectPrefixName).append(".");
            }
        }

        if(fieldName != null) {
            sb.append(fieldName);
        }

        return sb.toString();
    }

    public void addObjectPrefixName(String objectPrefixName) {
        if(objectPrefixName == null) { return; }

        if(objectPrefixNames == null) {
            objectPrefixNames = new ArrayList<String>();
        }

        objectPrefixNames.add(objectPrefixName);
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public List<String> getObjectPrefixNames() {
        return objectPrefixNames;
    }

}
