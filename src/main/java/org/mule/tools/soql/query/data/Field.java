/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.data;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.SOQLAbstractData;
import org.mule.tools.soql.query.condition.ConditionField;
import org.mule.tools.soql.query.group.GroupBySpec;
import org.mule.tools.soql.query.order.OrderByField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class Field extends SOQLAbstractData implements FunctionParameter, ConditionField, OrderByField, GroupBySpec {
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

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitField(this);
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
