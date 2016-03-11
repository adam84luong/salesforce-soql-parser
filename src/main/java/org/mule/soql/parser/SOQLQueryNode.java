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
