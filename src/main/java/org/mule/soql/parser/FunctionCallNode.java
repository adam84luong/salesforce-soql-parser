package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.FunctionCall;
import org.mule.soql.query.FunctionParameter;
import org.mule.soql.query.SOQLData;

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

        if (child != null) {
            functionCall.setFunctionName(child.getText());
        }
    }

    private void processSecondNode(FunctionCall functionCall) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (SOQLCommonTreeUtils.matchesType(child,SOQLParser.FUNCTION_PARAMETERS)) {
            this.createFunctionParameters(child,functionCall);
        }
    }

    private void createFunctionParameters(CommonTree node,FunctionCall functionCall) {
        List<SOQLCommonTree> children = (List<SOQLCommonTree>) node.getChildren();

        if(children != null) {
            for(SOQLCommonTree child : children) {
                SOQLData soqlData = child.createSOQLData();
                if(soqlData!= null && soqlData instanceof FunctionParameter) {
                    functionCall.addFunctionParameter((FunctionParameter) soqlData);
                }
            }
        }
    }

}
