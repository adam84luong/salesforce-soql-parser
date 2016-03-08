package org.mule.soql.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FromClause extends SOQLData {
    private List<String> objectNames = new ArrayList<String>();
    private String objectName;
    private String alias;

    public FromClause() {
    }

    public FromClause(String objectName, String alias) {
        this.objectName = objectName;
        this.alias = alias;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("FROM").append(" ");

        if(objectNames != null) {
            for(String objectName : objectNames) {
                sb.append(objectName).append(".");
            }
        }

        if(objectName != null) {
            sb.append(objectName);
        }

        if(alias != null) {
            sb.append(" ").append(alias);
        }

        return sb.toString();
    }

    public void addObjectName(String objectName) {
        if(objectName == null) { return; }

        if(objectNames == null) {
            objectNames = new ArrayList<String>();
        }

        objectNames.add(objectName);
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<String> getObjectNames() {
        return objectNames;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
