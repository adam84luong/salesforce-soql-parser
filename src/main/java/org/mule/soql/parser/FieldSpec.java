package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FieldSpec extends SOQLCommonTree {

    public FieldSpec(int tokenType) {
        super(new CommonToken(tokenType, "FIELD_SPEC"));
    }

}
