package org.mule.soql.parser.utils;

import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.SOQLParser;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by damianpelaez on 3/7/16.
 */
public class SOQLCommonTreeUtils {

    private static Set<Integer> fieldOperators = createFieldOperators();
    private static Set<Integer> setOperators = createSetOperators();

    private static Set<Integer> createFieldOperators() {
        Set<Integer> fieldOperators = new HashSet<Integer>();
        fieldOperators.add(SOQLParser.EQ_SYM);
        fieldOperators.add(SOQLParser.NOT_EQ);
        fieldOperators.add(SOQLParser.LET);
        fieldOperators.add(SOQLParser.GET);
        fieldOperators.add(SOQLParser.LTH);
        fieldOperators.add(SOQLParser.GTH);
        return fieldOperators;
    }

    private static Set<Integer> createSetOperators() {
        Set<Integer> setOperators = new HashSet<Integer>();
        setOperators.add(SOQLParser.NOT);
        setOperators.add(SOQLParser.IN);
        setOperators.add(SOQLParser.INCLUDES);
        setOperators.add(SOQLParser.EXCLUDES);
        return setOperators;
    }

    public static Boolean matchesType(CommonTree node, Integer type) {
        return node != null && type != null && type.equals(node.getType());
    }

    public static Boolean isFieldOperator(CommonTree node) {
        return node != null && fieldOperators.contains(node.getType());
    }

    public static Boolean isSetOperator(CommonTree node) {
        return node != null && setOperators.contains(node.getType());
    }

}
