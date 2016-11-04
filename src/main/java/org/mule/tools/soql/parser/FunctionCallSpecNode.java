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
import org.mule.tools.soql.query.data.FunctionCall;
import org.mule.tools.soql.query.select.FunctionCallSpec;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FunctionCallSpecNode extends SOQLCommonTree {

    public FunctionCallSpecNode(int tokenType) {
        super(new CommonToken(tokenType, "FUNCTION_CALL_SPEC"));
    }

    @Override
    public FunctionCallSpec createSOQLData() {
        FunctionCallSpec functionCallSpec = new FunctionCallSpec();

        this.processFirstNode(functionCallSpec);
        this.processSecondNode(functionCallSpec);

        return functionCallSpec;
    }

    private void processFirstNode(FunctionCallSpec functionCallSpec) {
        CommonTree child = (CommonTree) this.getChild(0);

        this.fillFunctionCall(child,functionCallSpec);
    }

    private void processSecondNode(FunctionCallSpec functionCallSpec) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child != null) {
            functionCallSpec.setAlias(child.getText());
        }
    }

    private void fillFunctionCall(CommonTree node, FunctionCallSpec functionCallSpec) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        functionCallSpec.setFunctionCall((FunctionCall) soqlNode.createSOQLData());
    }

}
