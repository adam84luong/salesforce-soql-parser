/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.data;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.condition.ConditionField;
import org.mule.soql.query.group.GroupBySpec;
import org.mule.soql.query.order.OrderByField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FunctionCall extends SOQLAbstractData implements FunctionParameter, ConditionField, OrderByField, GroupBySpec {
    private String functionName;
    private List<FunctionParameter> functionParameters = new ArrayList<FunctionParameter>();

    public FunctionCall() {
    }

    public FunctionCall(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(functionName != null) {
            sb.append(functionName);
        }

        sb.append("(");

        sb.append(this.createSOQLListText(functionParameters, ","));

        sb.append(")");

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitFunctionCall(this);
    }

    public void addFunctionParameter(FunctionParameter functionParameter) {
        if(functionParameter == null) { return; }

        if(functionParameters == null) {
            functionParameters = new ArrayList<FunctionParameter>();
        }

        functionParameters.add(functionParameter);
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<FunctionParameter> getFunctionParameters() {
        return functionParameters;
    }

}
