package org.mule.soql.query.clause;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.option.UpdateOption;

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
