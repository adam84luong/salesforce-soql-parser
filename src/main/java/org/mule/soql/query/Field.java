package org.mule.soql.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class Field extends SOQLData implements Parameter {
    private List<String> objectNames;
    private String fieldName;

    public Field(List<String> objectNames, String fieldName) {
        this.objectNames = objectNames != null ? objectNames : new ArrayList<String>();
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

    public String getFieldName() {
        return fieldName;
    }

}
