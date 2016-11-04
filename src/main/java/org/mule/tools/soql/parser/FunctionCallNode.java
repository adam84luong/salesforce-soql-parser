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
import org.mule.tools.soql.query.data.FunctionParameter;

import java.util.List;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FunctionCallNode extends SOQLCommonTree {

    public FunctionCallNode(int tokenType) {
        super(new CommonToken(tokenType, "FUNCTION_CALL"));
    }

    @Override
    public FunctionCall createSOQLData() {
        FunctionCall functionCall = new FunctionCall();

        this.processFirstNode(functionCall);
        this.processSecondNode(functionCall);

        return functionCall;
    }

    private void processFirstNode(FunctionCall functionCall) {
        CommonTree child = (CommonTree) this.getChild(0);

        if (child == null) { return; }

        functionCall.setFunctionName(child.getText());
    }

    private void processSecondNode(FunctionCall functionCall) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child == null) { return; }

        this.fillFunctionParameters(child, functionCall);
    }

    private void fillFunctionParameters(CommonTree node, FunctionCall functionCall) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FUNCTION_PARAMETERS)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if (children == null) { return; }

        for (CommonTree child : children) {
            this.fillFunctionParameter(child, functionCall);
        }
    }

    private void fillFunctionParameter(CommonTree node, FunctionCall functionCall) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL, SOQLParser.LITERAL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        functionCall.addFunctionParameter((FunctionParameter) soqlNode.createSOQLData());
    }

}
