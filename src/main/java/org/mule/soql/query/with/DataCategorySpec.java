/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.with;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/9/16.
 */
public class DataCategorySpec extends SOQLAbstractData {
    private String dataCategoryGroupName;
    private DataCategorySelector dataCategorySelector;
    private List<String> dataCategoryNames = new ArrayList<String>();

    public DataCategorySpec() {

    }

    public DataCategorySpec(String dataCategoryGroupName, DataCategorySelector dataCategorySelector) {
        this.dataCategoryGroupName = dataCategoryGroupName;
        this.dataCategorySelector = dataCategorySelector;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(dataCategoryGroupName != null) {
            sb.append(dataCategoryGroupName);
        }

        if(dataCategorySelector != null) {
            sb.append(" ").append(dataCategorySelector);
        }

        if(dataCategoryNames != null) {
            sb.append(" ");

            if(dataCategoryNames.size() == 1) {
                sb.append(this.createSOQLListText(dataCategoryNames, ","));
            } else {
                sb.append("(");
                sb.append(this.createSOQLListText(dataCategoryNames, ","));
                sb.append(")");
            }
        }

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitDataCategorySpec(this);
    }

    public void addDataCategoryName(String dataCategoryName) {
        if(dataCategoryName == null) { return; }

        if(dataCategoryNames == null) {
            dataCategoryNames = new ArrayList<String>();
        }

        dataCategoryNames.add(dataCategoryName);
    }

    public String getDataCategoryGroupName() {
        return dataCategoryGroupName;
    }

    public void setDataCategoryGroupName(String dataCategoryGroupName) {
        this.dataCategoryGroupName = dataCategoryGroupName;
    }

    public DataCategorySelector getDataCategorySelector() {
        return dataCategorySelector;
    }

    public void setDataCategorySelector(DataCategorySelector dataCategorySelector) {
        this.dataCategorySelector = dataCategorySelector;
    }

    public List<String> getDataCategoryNames() {
        return dataCategoryNames;
    }

}
