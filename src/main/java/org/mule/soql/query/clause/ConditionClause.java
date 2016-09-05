/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.clause;

import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public abstract class ConditionClause extends SOQLAbstractData {
    protected Condition condition;

    public ConditionClause() {
    }

    public ConditionClause(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getConditionName()).append(" ");

        if(condition != null) {
            sb.append(condition.toSOQLText());
        }

        return sb.toString();
    }

    protected abstract String getConditionName();

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
