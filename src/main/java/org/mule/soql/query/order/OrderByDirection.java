package org.mule.soql.query.order;

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
