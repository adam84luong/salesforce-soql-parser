/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.clause;

import org.mule.tools.soql.SOQLDataVisitor;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class GroupByRollupClause extends GroupByClause {

    public GroupByRollupClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("GROUP BY").append(" ").append("ROLLUP");

        sb.append(" ").append("(");

        sb.append(this.groupBySpecsToSOQLText());

        sb.append(")");

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitGroupByRollupClause(this);
    }

}