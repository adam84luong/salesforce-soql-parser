/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.clause;

import org.mule.tools.soql.SOQLDataVisitor;
import org.mule.tools.soql.query.option.UpdateOption;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class UpdateClause extends OptionClause<UpdateOption> {

    public UpdateClause() {
    }

    @Override
    protected String getOptionClauseName() {
        return "UPDATE";
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitUpdateClause(this);
    }

}
