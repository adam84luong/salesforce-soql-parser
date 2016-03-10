package org.mule.soql.query;

import org.mule.soql.query.condition.ConditionField;
import org.mule.soql.query.group.GroupByField;
import org.mule.soql.query.order.OrderByField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class Field extends SOQLData implements FunctionParameter, ConditionField, OrderByField, GroupByField {
    private List<String> objectNames = new ArrayList<String>();
    private String fieldName;

    public Field() {
    }

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(objectNames != null) {
            for(String objectName : objectNames) {
                sb.append(objectName).append(".");
            }
        }

        sb.append(fieldName);

        return sb.toString();
    }

    public void addObjectName(String objectName) {
        if(objectName == null) { return; }

        if(objectNames == null) {
            objectNames = new ArrayList<String>();
        }

        objectNames.add(objectName);
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public List<String> getObjectNames() {
        return objectNames;
    }

}
