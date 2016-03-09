package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.Field;
import org.mule.soql.query.TypeOf;

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

        this.createTypeOfField(child, typeOf);
    }

    private void processSecondNode(TypeOf typeOf) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child == null) { return; }

        this.createWhenThenClauses(child, typeOf);
    }

    private void processThirdNode(TypeOf typeOf) {
        CommonTree child = (CommonTree) this.getChild(2);

        if (child == null) { return; }

        this.createElseClause(child, typeOf);
    }

    private void createTypeOfField(CommonTree node, TypeOf typeOf) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        typeOf.setField((Field) soqlNode.createSOQLData());
    }

    private void createWhenThenClauses(CommonTree node, TypeOf typeOf) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.TYPEOF_WHEN_THEN_CLAUSES)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.createWhenThenClause(child, typeOf);
        }
    }

    private void createWhenThenClause(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.WHEN)) { return; }

        String objectName = this.createWhenThenClauseObjectName(node);
        this.createWhenThenClauseFields(objectName, node, typeOf);
    }

    private String createWhenThenClauseObjectName(CommonTree node) {
        CommonTree child = (CommonTree) node.getChild(0);

        if(child == null) { return ""; }

        return child.getText();
    }

    private void createWhenThenClauseFields(String objectName, CommonTree node, TypeOf typeOf) {
        CommonTree child = (CommonTree) node.getChild(1);

        if(!SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.THEN)) { return; }

        List<CommonTree> subChildren = (List<CommonTree>) child.getChildren();

        if(subChildren == null) { return; }

        for(CommonTree subChild : subChildren) {
            this.createWhenThenClauseField(objectName, subChild, typeOf);
        }
    }

    private void createWhenThenClauseField(String objectName, CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        typeOf.addWhenThenField(objectName, (Field) soqlNode.createSOQLData());
    }

    private void createElseClause(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.ELSE)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.createElseClauseField(child, typeOf);
        }
    }

    private void createElseClauseField(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        typeOf.addElseField((Field) soqlNode.createSOQLData());
    }

}
