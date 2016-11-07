/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.parser;

import org.antlr.runtime.CommonToken;
import org.mule.tools.soql.query.SOQLSubQuery;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SOQLSubQueryNode extends SOQLGenericQueryNode {

    public SOQLSubQueryNode(int tokenType) {
        super(new CommonToken(tokenType, "SOQL_SUBQUERY"));
    }

    @Override
    public SOQLSubQuery createSOQLData() {
        SOQLSubQuery soqlSubQuery = new SOQLSubQuery();

        this.fillSoqlQuery(soqlSubQuery);

        return soqlSubQuery;
    }

}
