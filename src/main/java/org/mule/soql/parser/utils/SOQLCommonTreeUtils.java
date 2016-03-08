package org.mule.soql.parser.utils;

import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.SOQLParser;

import java.util.HashSet;
import java.util.Set;

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

    public static Boolean isFieldOperator(CommonTree node) {
        return matchesAnyType(node, SOQLParser.EQ_SYM,
                                    SOQLParser.NOT_EQ,
                                    SOQLParser.LET,
                                    SOQLParser.GET,
                                    SOQLParser.LTH,
                                    SOQLParser.GTH);
    }

    public static boolean isSetOperator(CommonTree node) {
        return matchesAnyType(node, SOQLParser.NOT,
                                    SOQLParser.IN,
                                    SOQLParser.INCLUDES,
                                    SOQLParser.EXCLUDES);
    }

    public static Boolean isCondition(CommonTree node) {
        return matchesAnyType(node, SOQLParser.LIKE_BASED_CONDITION,
                                    SOQLParser.FIELD_BASED_CONDITION,
                                    SOQLParser.SET_BASED_CONDITION,
                                    SOQLParser.PARENTHESIZED_CONDITION,
                                    SOQLParser.AND,
                                    SOQLParser.OR,
                                    SOQLParser.NOT);
    }

}