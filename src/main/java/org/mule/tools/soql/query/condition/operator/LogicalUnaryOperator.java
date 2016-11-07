/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.condition.operator;

import org.mule.tools.soql.query.SOQLAbstractData;
import org.mule.tools.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public abstract class LogicalUnaryOperator extends SOQLAbstractData implements Condition {
    protected Condition condition;

    public LogicalUnaryOperator() {
    }

    public LogicalUnaryOperator(Condition condition) {
        this.condition = condition;
    }

    protected abstract String getOperatorName();

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
