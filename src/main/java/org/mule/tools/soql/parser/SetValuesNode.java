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
import org.mule.tools.soql.query.condition.SetValues;
import org.mule.tools.soql.query.data.Literal;

import java.util.List;

/**
 * Created by damianpelaez on 2/26/16.
 */
public class SetValuesNode extends SOQLCommonTree {

    public SetValuesNode(int tokenType) {
        super(new CommonToken(tokenType, "SET_VALUES"));
    }

    @Override
    public SetValues createSOQLData() {
        SetValues setValues = new SetValues();

        this.processChildren(setValues);

        return setValues;
    }

    private void processChildren(SetValues setValues) {
        List<CommonTree> children = (List<CommonTree>) this.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillLiteral(child, setValues);
        }
    }

    private void fillLiteral(CommonTree node, SetValues setValues) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, null, SOQLParser.LITERAL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        setValues.addValue((Literal) soqlNode.createSOQLData());
    }

}
