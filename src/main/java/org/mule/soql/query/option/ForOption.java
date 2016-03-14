package org.mule.soql.query.option;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/7/16.
 */
public enum ForOption implements Option {
    REFERENCE("REFERENCE"), VIEW("VIEW"), UPDATE("UPDATE");

    private String value;

    ForOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ForOption get(String value){
        for(ForOption e : ForOption.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(),value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
