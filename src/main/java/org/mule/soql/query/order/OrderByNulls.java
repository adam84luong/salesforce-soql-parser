package org.mule.soql.query.order;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/9/16.
 */
public enum OrderByNulls {
    FIRST("FIRST"), LAST("LAST");

    private String value;

    OrderByNulls(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrderByNulls get(String value){
        for(OrderByNulls e : OrderByNulls.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(),value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
