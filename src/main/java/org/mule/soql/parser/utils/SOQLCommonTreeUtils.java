package org.mule.soql.parser.utils;

import org.antlr.runtime.tree.CommonTree;

/**
 * Created by damianpelaez on 3/7/16.
 */
public class SOQLCommonTreeUtils {

    public static Boolean matchesType(CommonTree node, Integer type) {
        return node != null && type != null && type.equals(node.getType());
    }

}
