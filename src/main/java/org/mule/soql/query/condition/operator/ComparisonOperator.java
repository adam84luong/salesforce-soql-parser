/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
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
