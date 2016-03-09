package org.mule.soql.query.condition.operator;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/7/16.
 */
public enum FieldOperator {
    EQUALS("="), NOT_EQUALS("!="), DISTINCT("<>"), LESS_EQUALS("<="), GREATER_EQUALS(">="), LESS("<"), GREATER(">");

    private String value;

    FieldOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FieldOperator get(String value){
        for(FieldOperator e : FieldOperator.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(),value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
