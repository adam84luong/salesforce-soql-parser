/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.clause;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.SOQLAbstractData;
import org.mule.tools.soql.query.select.SelectSpec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SelectClause extends SOQLAbstractData {
    private List<SelectSpec> selectSpecs = new ArrayList<SelectSpec>();

    public SelectClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT").append(" ");

        sb.append(this.createSOQLListText(selectSpecs, ","));

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitSelectClause(this);
    }

    public void addSelectSpec(SelectSpec selectSpec) {
        if(selectSpec == null) { return; }

        if(selectSpec == null) {
            selectSpecs = new ArrayList<SelectSpec>();
        }

        selectSpecs.add(selectSpec);
    }

    public List<SelectSpec> getSelectSpecs() {
        return selectSpecs;
    }

}
