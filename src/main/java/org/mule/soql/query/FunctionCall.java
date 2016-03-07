package org.mule.soql.query;

import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FunctionCall extends SOQLData implements FunctionParameter {
    private String functionName;
    private List<FunctionParameter> functionParameters;

    public FunctionCall() {
    }

    public FunctionCall(String functionName, List<FunctionParameter> functionParameters) {
        this.functionName = functionName;
        this.functionParameters = functionParameters;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(functionName != null) {
            sb.append(functionName);
        }

        sb.append("(");

        if(functionParameters != null) {
            for(FunctionParameter functionParameter : functionParameters) {
                if(!functionParameter.equals(functionParameters.get(0))) {
                    sb.append(",");
                }
                sb.append(functionParameter.toSOQLText());
            }
        }

        sb.append(")");

        return sb.toString();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<FunctionParameter> getFunctionParameters() {
        return functionParameters;
    }

    public void setFunctionParameters(List<FunctionParameter> functionParameters) {
        this.functionParameters = functionParameters;
    }

}
