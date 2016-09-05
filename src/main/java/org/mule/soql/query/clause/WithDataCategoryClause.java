/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.clause;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.with.DataCategorySpec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class WithDataCategoryClause extends WithClause {
    private List<DataCategorySpec> dataCategorySpecs;

    public WithDataCategoryClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("WITH DATA CATEGORY").append(" ");

        sb.append(this.createSOQLListText(dataCategorySpecs, " AND "));

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitWithDataCategoryClause(this);
    }

    public void addDataCategorySpec(DataCategorySpec dataCategorySpec) {
        if(dataCategorySpec == null) { return; }

        if(dataCategorySpecs == null) {
            dataCategorySpecs = new ArrayList<DataCategorySpec>();
        }

        dataCategorySpecs.add(dataCategorySpec);
    }

    public List<DataCategorySpec> getDataCategorySpecs() {
        return dataCategorySpecs;
    }

}
