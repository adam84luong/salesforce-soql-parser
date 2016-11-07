/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.clause;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class HavingClause extends ConditionClause {

    public HavingClause() {
    }

    public HavingClause(Condition condition) {
        super(condition);
    }

    protected String getConditionName() {
        return "HAVING";
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitHavingClause(this);
    }

}
