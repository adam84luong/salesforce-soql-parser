/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.data;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class Literal extends SOQLAbstractData implements FunctionParameter {
    private String value;
    private Integer parameter;

    public Literal() {
    }

    public Literal(String value) {
        this.value = value;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(value != null) {
            sb.append(value);
        }

        if(parameter != null) {
            sb.append(":").append(parameter);
        }

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitLiteral(this);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getParameter() {
        return parameter;
    }

    public void setParameter(Integer parameter) {
        this.parameter = parameter;
    }

}
