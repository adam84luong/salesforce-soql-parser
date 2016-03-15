package org.mule.soql.query;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.condition.ConditionSet;
import org.mule.soql.query.select.SelectSpec;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SOQLSubQuery extends SOQLGenericQuery implements SelectSpec, ConditionSet {

    public SOQLSubQuery() {
    }

    @Override
    public String toSOQLText() {
        return "(" + super.toSOQLText() + ")";
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitSOQLSubQuery(this);
    }

}
