package org.mule.soql.parser.utils;

import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.SOQLParser;

import java.util.ArrayList;
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
            if(child.getChildIndex() != 0) {
                sb.append(" ");
            }
            sb.append(child.getText());
        }

        return sb.toString();
    }

    public static List<String> getChildrenTexts(CommonTree node) {
        if(node == null) { return null; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return null; }

        List<String> childrenTexts = new ArrayList<String>();

        for(CommonTree child : children) {
            childrenTexts.add(child.getText());
        }

        return childrenTexts;
    }

    public static Integer getTextAsInteger(CommonTree node) {
        if(node == null || node.getText() == null) { return null; }

        Integer value = null;

        try{
            value = new Integer(node.getText());
        } catch(NumberFormatException e) {
            //I omit the exception and return null
        }

        return value;
    }

}