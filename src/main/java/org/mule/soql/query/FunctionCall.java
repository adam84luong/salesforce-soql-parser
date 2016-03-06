package org.mule.soql.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FunctionCall extends SOQLData implements Parameter {
    private String functionName;
    private List<Parameter> parameters;

    public FunctionCall(String functionName, List<Parameter> parameters) {
        this.functionName = functionName;
        this.parameters = parameters != null ? parameters : new ArrayList<Parameter>();
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(functionName != null) {
            sb.append(functionName);
        }

        sb.append("(");

        if(parameters != null) {
            for(Parameter parameter : parameters) {
                if(!parameter.equals(parameters.get(0))) {
                    sb.append(",");
                }
                sb.append(parameter.toSOQLText());
            }
        }

        sb.append(")");

        return sb.toString();
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

}
