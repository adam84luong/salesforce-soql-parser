/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.clause;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.from.ObjectSpec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FromClause extends SOQLAbstractData {
    private List<ObjectSpec> relationObjectSpecs = new ArrayList<ObjectSpec>();
    private ObjectSpec mainObjectSpec;

    public FromClause() {
    }

    public FromClause(ObjectSpec mainObjectSpec) {
        this.mainObjectSpec = mainObjectSpec;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("FROM").append(" ");

        if(mainObjectSpec != null) {
            sb.append(mainObjectSpec.toSOQLText());
        }

        if(relationObjectSpecs != null) {
            for(ObjectSpec relationObjectSpec : relationObjectSpecs) {
                sb.append(",").append(relationObjectSpec.toSOQLText());
            }
        }

        return sb.toString();
    }

    public void addRelationObjectSpec(ObjectSpec relationObjectSpec) {
        if(relationObjectSpec == null) { return; }

        if(relationObjectSpecs == null) {
            relationObjectSpecs = new ArrayList<ObjectSpec>();
        }

        relationObjectSpecs.add(relationObjectSpec);
    }

    public ObjectSpec getMainObjectSpec() {
        return mainObjectSpec;
    }

    public void setMainObjectSpec(ObjectSpec mainObjectSpec) {
        this.mainObjectSpec = mainObjectSpec;
    }

    public List<ObjectSpec> getRelationObjectSpecs() {
        return relationObjectSpecs;
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitFromClause(this);
    }

}
