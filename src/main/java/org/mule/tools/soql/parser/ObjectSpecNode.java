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
import org.mule.tools.soql.query.from.ObjectSpec;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class ObjectSpecNode extends SOQLCommonTree {

    public ObjectSpecNode(int tokenType) {
        super(new CommonToken(tokenType, "OBJECT_SPEC"));
    }

    @Override
    public ObjectSpec createSOQLData() {
        ObjectSpec objectSpec = new ObjectSpec();

        this.processFirstNode(objectSpec);
        this.processSecondNode(objectSpec);
        this.processThirdNode(objectSpec);

        return objectSpec;
    }

    private void processFirstNode(ObjectSpec objectSpec) {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return; }

        if (SOQLCommonTreeUtils.matchesAnyType(child,SOQLParser.OBJECT_PREFIX)) {
            this.fillObjectPrefixNames(child,objectSpec);
        } else {
            objectSpec.setObjectName(child.getText());
        }
    }

    private void processSecondNode(ObjectSpec objectSpec) {
        CommonTree child = (CommonTree) this.getChild(1);

        if(child == null) { return; }

        if(objectSpec.getObjectName() == null) {
            objectSpec.setObjectName(child.getText());
        } else {
            objectSpec.setAlias(child.getText());
        }
    }

    private void processThirdNode(ObjectSpec objectSpec) {
        CommonTree child = (CommonTree) this.getChild(2);

        if(child == null) { return; }

        objectSpec.setAlias(child.getText());
    }

    private void fillObjectPrefixNames(CommonTree node, ObjectSpec objectSpec) {
        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            objectSpec.addObjectPrefixName(child.getText());
        }
    }

}
