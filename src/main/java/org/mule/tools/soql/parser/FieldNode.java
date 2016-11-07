/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.tools.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.tools.soql.query.data.Field;

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
            field.addObjectPrefixName(child.getText());
        }
    }

}

