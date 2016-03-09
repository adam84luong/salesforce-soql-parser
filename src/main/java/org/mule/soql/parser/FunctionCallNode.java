package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.FunctionCall;
import org.mule.soql.query.FunctionParameter;

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

        this.createFunctionParameters(child, functionCall);
    }

    private void createFunctionParameters(CommonTree node, FunctionCall functionCall) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FUNCTION_PARAMETERS)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if (children == null) { return; }

        for (CommonTree child : children) {
            this.createFunctionParameter(child, functionCall);
        }
    }

    private void createFunctionParameter(CommonTree node, FunctionCall functionCall) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL, SOQLParser.LITERAL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        functionCall.addFunctionParameter((FunctionParameter) soqlNode.createSOQLData());
    }

}
