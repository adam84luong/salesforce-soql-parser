/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.data.Field;
import org.mule.soql.query.select.TypeOf;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class TypeOfNode extends SOQLCommonTree {

    public TypeOfNode(Token t) {
        super(t);
    }

    @Override
    public TypeOf createSOQLData() {
        TypeOf typeOf = new TypeOf();

        this.processFirstNode(typeOf);
        this.processSecondNode(typeOf);
        this.processThirdNode(typeOf);

        return typeOf;
    }

    private void processFirstNode(TypeOf typeOf) {
        CommonTree child = (CommonTree) this.getChild(0);

        if (child == null) { return; }

        this.fillTypeOfField(child, typeOf);
    }

    private void processSecondNode(TypeOf typeOf) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child == null) { return; }

        this.fillWhenThenClauses(child, typeOf);
    }

    private void processThirdNode(TypeOf typeOf) {
        CommonTree child = (CommonTree) this.getChild(2);

        if (child == null) { return; }

        this.fillElseClause(child, typeOf);
    }

    private void fillTypeOfField(CommonTree node, TypeOf typeOf) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        typeOf.setField((Field) soqlNode.createSOQLData());
    }

    private void fillWhenThenClauses(CommonTree node, TypeOf typeOf) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.TYPEOF_WHEN_THEN_CLAUSES)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillWhenThenClause(child, typeOf);
        }
    }

    private void fillWhenThenClause(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.WHEN)) { return; }

        String objectName = this.fillWhenThenClauseObjectName(node);
        this.fillWhenThenClauseFields(objectName, node, typeOf);
    }

    private String fillWhenThenClauseObjectName(CommonTree node) {
        CommonTree child = (CommonTree) node.getChild(0);

        if(child == null) { return ""; }

        return child.getText();
    }

    private void fillWhenThenClauseFields(String objectName, CommonTree node, TypeOf typeOf) {
        CommonTree child = (CommonTree) node.getChild(1);

        if(!SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.THEN)) { return; }

        List<CommonTree> subChildren = (List<CommonTree>) child.getChildren();

        if(subChildren == null) { return; }

        for(CommonTree subChild : subChildren) {
            this.fillWhenThenClauseField(objectName, subChild, typeOf);
        }
    }

    private void fillWhenThenClauseField(String objectName, CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        typeOf.addWhenThenField(objectName, (Field) soqlNode.createSOQLData());
    }

    private void fillElseClause(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.ELSE)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillElseClauseField(child, typeOf);
        }
    }

    private void fillElseClauseField(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        typeOf.addElseField((Field) soqlNode.createSOQLData());
    }

}
