/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.clause;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.condition.FieldBasedCondition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class WithPlainClause extends WithClause {
    private FieldBasedCondition fieldBasedCondition;

    public WithPlainClause() {
    }

    public WithPlainClause(FieldBasedCondition fieldBasedCondition) {
        this.fieldBasedCondition = fieldBasedCondition;
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("WITH").append(" ");

        if(fieldBasedCondition != null) {
            sb.append(fieldBasedCondition.toSOQLText());
        }

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitWithPlainClause(this);
    }

    public FieldBasedCondition getFieldBasedCondition() {
        return fieldBasedCondition;
    }

    public void setFieldBasedCondition(FieldBasedCondition fieldBasedCondition) {
        this.fieldBasedCondition = fieldBasedCondition;
    }

}
