/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.condition;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.SOQLAbstractData;
import org.mule.tools.soql.query.data.Literal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/7/16.
 */
public class SetValues extends SOQLAbstractData implements ConditionSet {
    private List<Literal> values = new ArrayList<Literal>();

    public SetValues() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");

        sb.append(this.createSOQLListText(values, ","));

        sb.append(")");

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitSetValues(this);
    }

    public void addValue(Literal literal) {
        if(literal == null) { return; }

        if(values == null) {
            values = new ArrayList<Literal>();
        }

        values.add(literal);
    }

    public List<Literal> getValues() {
        return values;
    }

}
