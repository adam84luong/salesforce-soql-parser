package org.mule.soql.query.option;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/7/16.
 */
public enum UpdateOption implements Option {
    VIEWSTAT("VIEWSTAT"), TRACKING("TRACKING");

    private String value;

    UpdateOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UpdateOption get(String value){
        for(UpdateOption e : UpdateOption.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(),value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
