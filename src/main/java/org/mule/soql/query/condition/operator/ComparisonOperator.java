package org.mule.soql.query.condition.operator;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/7/16.
 */
public enum ComparisonOperator {
    EQUALS("="), NOT_EQUALS("!="), DISTINCT("<>"), LESS_EQUALS("<="), GREATER_EQUALS(">="), LESS("<"), GREATER(">");

    private String value;

    ComparisonOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ComparisonOperator get(String value){
        String cleanValue = StringUtils.replace(value, " ", "") ;

        for(ComparisonOperator e : ComparisonOperator.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(), cleanValue)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
