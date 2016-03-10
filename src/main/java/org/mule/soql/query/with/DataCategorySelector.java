package org.mule.soql.query.with;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/9/16.
 */
public enum DataCategorySelector {
    AT("AT"), ABOVE("ABOVE"), ABOVE_OR_BELOW("ABOVE_OR_BELOW"), BELOW("BELOW");

    private String value;

    DataCategorySelector(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DataCategorySelector get(String value){
        for(DataCategorySelector e : DataCategorySelector.values()){
            if(StringUtils.equalsIgnoreCase(e.getValue(),value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
