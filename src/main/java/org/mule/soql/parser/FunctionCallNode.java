package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.query.FunctionCall;
import org.mule.soql.query.Parameter;
import org.mule.soql.query.SOQLData;

import java.util.ArrayList;
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
        CommonTree firstChild = (CommonTree) this.getChild(0);
        CommonTree secondChild = (CommonTree) this.getChild(1);

        String functionName = null;
        List<Parameter> parameters = null;

        if (firstChild != null) {
            functionName = firstChild.getText();
        }

        if (this.matchesLabel(secondChild,"FUNCTION_PARAMETERS")) {
            parameters = this.createParameters(secondChild);
        }

        return new FunctionCall(functionName,parameters);
    }

    private List<Parameter> createParameters(CommonTree node) {
        List<Parameter> parameters = new ArrayList<Parameter>();

        List<SOQLCommonTree> children = (List<SOQLCommonTree>) node.getChildren();

        if(children != null) {
            for(SOQLCommonTree child : children) {
                SOQLData soqlData = child.createSOQLData();
                if(soqlData instanceof Parameter) {
                    parameters.add((Parameter) soqlData);
                }
            }
        }

        return parameters;

    }

}
