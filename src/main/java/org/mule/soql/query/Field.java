package org.mule.soql.query;

import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class Field extends SOQLData implements FunctionParameter {
    private List<String> objectNames;
    private String fieldName;

    public Field() {
    }

    public Field(List<String> objectNames, String fieldName) {
        this.objectNames = objectNames;
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

    public List<String> getObjectNames() {
        return objectNames;
    }

    public void setObjectNames(List<String> objectNames) {
        this.objectNames = objectNames;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

}
