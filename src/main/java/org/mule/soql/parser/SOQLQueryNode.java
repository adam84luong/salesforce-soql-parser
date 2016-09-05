/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.mule.soql.query.SOQLQuery;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SOQLQueryNode extends SOQLGenericQueryNode {

    public SOQLQueryNode(int tokenType) {
        super(new CommonToken(tokenType, "SOQL_QUERY"));
    }

    @Override
    public SOQLQuery createSOQLData() {
        SOQLQuery soqlQuery = new SOQLQuery();

        this.fillSoqlQuery(soqlQuery);

        return soqlQuery;
    }

}
