package org.mule.soql.query;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FunctionCallSpec extends SOQLData {
    private FunctionCall functionCall;
    private String alias;

    public FunctionCallSpec() {
    }

    public FunctionCallSpec(FunctionCall functionCall, String alias) {
        this.functionCall = functionCall;
        this.alias = alias;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(functionCall != null) {
            sb.append(functionCall.toSOQLText());
        }

        if(alias != null) {
            sb.append(" ").append(alias);
        }

        return sb.toString();
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
