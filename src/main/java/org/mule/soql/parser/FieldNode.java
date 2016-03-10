package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.Field;

import java.util.List;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FieldNode extends SOQLCommonTree {

    public FieldNode(int tokenType) {
        super(new CommonToken(tokenType, "FIELD"));
    }

    @Override
    public Field createSOQLData() {
        Field field = new Field();

        this.processFirstNode(field);
        this.processSecondNode(field);

        return field;
    }

    private void processFirstNode(Field field) {
        CommonTree child = (CommonTree) this.getChild(0);

        if (child == null) { return; }

        if (SOQLCommonTreeUtils.matchesAnyType(child,SOQLParser.OBJECT_PREFIX)) {
            this.fillObjectNames(child,field);
        } else {
            field.setFieldName(child.getText());
        }
    }

    private void processSecondNode(Field field) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child == null) { return; }

        if (field.getFieldName() == null) {
            field.setFieldName(child.getText());
        }
    }

    private void fillObjectNames(CommonTree node, Field field) {
        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if (children == null) { return; }

        for(CommonTree child : children) {
            field.addObjectName(child.getText());
        }
    }

}

