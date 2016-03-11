package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.mule.soql.query.SOQLSubQuery;

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
