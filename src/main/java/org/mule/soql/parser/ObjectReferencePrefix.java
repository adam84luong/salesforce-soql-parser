package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class ObjectReferencePrefix extends CommonTree {

    public ObjectReferencePrefix(int tokenType) {
        super(new CommonToken(tokenType, "OBJECT_REFERENCE_PREFIX"));
    }

}
