package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FieldSpec extends CommonTree {

    public FieldSpec(int tokenType) {
        super(new CommonToken(tokenType, "FIELD_SPEC"));
    }

}
