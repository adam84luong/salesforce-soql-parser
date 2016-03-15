package org.mule.soql.query;

import org.mule.soql.SOQLDataVisitor;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SOQLQuery extends SOQLGenericQuery {

    public SOQLQuery() {
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitSOQLQuery(this);
    }

}
