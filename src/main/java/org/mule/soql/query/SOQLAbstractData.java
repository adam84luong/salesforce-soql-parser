/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/6/16.
 */
public abstract class SOQLAbstractData implements SOQLData {

    public String toSOQLText() {
        return "";
    }

    @Override
    public String toString() {
        return this.toSOQLText();
    }

    protected String createSOQLListText(Iterable<? extends Object> list, String separator) {
        StringBuilder sb = new StringBuilder();

        Boolean first = true;
        if(list != null) {
            for(Object item : list) {
                if(first) {
                    first = false;
                } else {
                    sb.append(StringUtils.defaultIfEmpty(separator, ","));
                }
                sb.append(item.toString());
            }
        }

        return sb.toString();
    }

}
