package org.mule.soql.query;

import org.mule.soql.query.condition.ConditionField;
import org.mule.soql.query.order.OrderByField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FunctionCall extends SOQLData implements FunctionParameter,ConditionField,OrderByField {
    private String functionName;
    private List<FunctionParameter> functionParameters = new ArrayList<FunctionParameter>();

    public FunctionCall() {
    }

    public FunctionCall(String functionName) {
        this.functionName = functionName;
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

    public void addFunctionParameter(FunctionParameter functionParameter) {
        if(functionParameter == null) { return; }

        if(functionParameters == null) {
            functionParameters = new ArrayList<FunctionParameter>();
        }

        functionParameters.add(functionParameter);
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

}
