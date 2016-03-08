package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
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

        if (child != null) {
            typeOf.setObjectName(child.getText());
        }
    }

    private void processSecondNode(TypeOf typeOf) {
        CommonTree child = (CommonTree) this.getChild(1);
        this.createWhenThenClauses(child, typeOf);
    }

    private void processThirdNode(TypeOf typeOf) {
        CommonTree child = (CommonTree) this.getChild(2);
        this.createElseClause(child, typeOf);
    }

    private void createWhenThenClauses(CommonTree node, TypeOf typeOf) {
        if (!SOQLCommonTreeUtils.matchesType(node,SOQLParser.TYPEOF_WHEN_THEN_CLAUSES)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        for(CommonTree child : children) {
            this.createWhenThenClause(child,typeOf);
        }
    }

    private void createWhenThenClause(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesType(node,SOQLParser.WHEN)) { return; }

        String objectName = this.processWhenThenClauseObjectName(node);
        this.processWhenThenClauseFields(objectName,node,typeOf);
    }

    private String processWhenThenClauseObjectName(CommonTree node) {
        CommonTree child = (CommonTree) node.getChild(0);

        if(child == null) { return null;}

        return child.getText();
    }

    private void processWhenThenClauseFields(String objectName, CommonTree node, TypeOf typeOf) {
        CommonTree child = (CommonTree) node.getChild(1);

        if(!SOQLCommonTreeUtils.matchesType(child,SOQLParser.THEN)) { return; }

        List<CommonTree> subChildren = (List<CommonTree>) child.getChildren();

        for(CommonTree subChild : subChildren) {
            if(SOQLCommonTreeUtils.matchesType(subChild,SOQLParser.FIELD)) {
                FieldNode fieldNode = (FieldNode) subChild;
                typeOf.addWhenThenField(objectName, fieldNode.createSOQLData());
            }
        }
    }

    private void createElseClause(CommonTree node, TypeOf typeOf) {
        if(!SOQLCommonTreeUtils.matchesType(node,SOQLParser.ELSE)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        for(CommonTree child : children) {
            if(SOQLCommonTreeUtils.matchesType(child,SOQLParser.FIELD)) {
                FieldNode fieldNode = (FieldNode) child;
                typeOf.addElseField(fieldNode.createSOQLData());
            }
        }
    }

}
