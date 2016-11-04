/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.query.order;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/9/16.
 */
public enum OrderByDirection {
    ASC("ASC"), DESC("DESC");

    private String value;

    OrderByDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrderByDirection get(String value){
        for(OrderByDirection e : OrderByDirection.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(),value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
