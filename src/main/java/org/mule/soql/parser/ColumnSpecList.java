package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class ColumnSpecList extends CommonTree {

    public ColumnSpecList(int tokenType) {
        super(new CommonToken(tokenType, "COLUMN_SPEC_LIST"));
    }

}
