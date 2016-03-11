package org.mule.soql.parser.utils;

import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.SOQLParser;

import java.util.List;

/**
 * Created by damianpelaez on 3/7/16.
 */
public class SOQLCommonTreeUtils {

    public static Boolean matchesAnyType(CommonTree node, Integer... types) {
        if(node == null || types == null) { return false; }

        for(Integer type : types) {
            if(type != null && type.equals(node.getType())){
                return true;
            }
        }

        return false;
    }

    public static Boolean isCondition(CommonTree node) {
        return matchesAnyType(node, SOQLParser.LIKE_BASED_CONDITION,
                                    SOQLParser.FIELD_BASED_CONDITION,
                                    SOQLParser.SET_BASED_CONDITION,
                                    SOQLParser.PARENTHESIS,
                                    SOQLParser.AND,
                                    SOQLParser.OR,
                                    SOQLParser.NOT);
    }

    public static String getOperatorName(CommonTree node) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.OPERATOR)) { return ""; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        StringBuilder sb = new StringBuilder();

        for(CommonTree child : children) {
            if(!children.get(0).equals(child)) {
                sb.append(" ");
            }
            sb.append(child.getText());
        }

        return sb.toString();
    }

}