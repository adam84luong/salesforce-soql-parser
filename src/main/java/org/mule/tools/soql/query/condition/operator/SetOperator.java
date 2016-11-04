/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.condition.operator;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/7/16.
 */
public enum SetOperator {
    IN("IN"), NOT_IN("NOT IN"), INCLUDES("INCLUDES"), EXCLUDES("EXCLUDES");

    private String value;

    SetOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SetOperator get(String value){
        for(SetOperator e : SetOperator.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(),value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
