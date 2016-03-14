package org.mule.soql.query.clause;

import org.mule.soql.query.option.ForOption;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class ForClause extends OptionClause<ForOption> {

    public ForClause() {
    }

    @Override
    protected String getOptionClauseName() {
        return "FOR";
    }

}
