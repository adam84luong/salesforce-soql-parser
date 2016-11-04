/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.select;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.SOQLAbstractData;
import org.mule.tools.soql.query.data.Field;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class TypeOf extends SOQLAbstractData implements SelectSpec {
    private Field field;
    private LinkedHashMap<String,List<Field>> whenThenFields = new LinkedHashMap<String,List<Field>>();
    private List<Field> elseFields = new ArrayList<Field>();

    public TypeOf() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("TYPEOF").append(" ");

        if(field != null) {
            sb.append(field.toSOQLText()).append(" ");
        }

        if(whenThenFields != null) {
            for(Map.Entry<String, List<Field>> whenThenClause : whenThenFields.entrySet()) {
                sb.append("WHEN").append(" ").append(whenThenClause.getKey()).append(" ").append("THEN").append(" ");
                sb.append(this.createSOQLListText(whenThenClause.getValue(), ","));
                sb.append(" ");
            }
        }

        if(elseFields != null && !elseFields.isEmpty()) {
            sb.append("ELSE").append(" ");
            sb.append(this.createSOQLListText(elseFields, ","));
            sb.append(" ");
        }

        sb.append("END");

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitTypeOf(this);
    }

    public void addWhenThenField(String objectName, Field field) {
        if(objectName == null || field == null) { return; }

        if(whenThenFields == null) {
            whenThenFields = new LinkedHashMap<String,List<Field>>();
        }

        List<Field> fields = whenThenFields.get(objectName);

        if(fields == null) {
            fields = new ArrayList<Field>();
            whenThenFields.put(objectName,fields);
        }

        fields.add(field);
    }

    public void addElseField(Field field) {
        if(field == null) { return; }

        if(elseFields == null) {
            elseFields = new ArrayList<Field>();
        }

        elseFields.add(field);
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public LinkedHashMap<String, List<Field>> getWhenThenFields() {
        return whenThenFields;
    }

    public List<Field> getElseFields() {
        return elseFields;
    }

}
