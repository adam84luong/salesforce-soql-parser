/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.select;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.SOQLAbstractData;
import org.mule.tools.soql.query.data.FunctionCall;
import org.mule.tools.soql.query.data.FunctionParameter;

import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FunctionCallSpec extends SOQLAbstractData implements SelectSpec {
    private FunctionCall functionCall;
    private String alias;

    public FunctionCallSpec() {
    }

    public FunctionCallSpec(FunctionCall functionCall, String alias) {
        this.functionCall = functionCall;
        this.alias = alias;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(functionCall != null) {
            sb.append(functionCall.toSOQLText());
        }

        if(alias != null) {
            sb.append(" ").append(alias);
        }

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitFunctionCallSpec(this);
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFunctionName() {
        if(functionCall == null) {
            return null;
        }
        return functionCall.getFunctionName();
    }

    public List<FunctionParameter> getFunctionParameters() {
        if(functionCall == null) {
            return null;
        }
        return functionCall.getFunctionParameters();
    }

}
