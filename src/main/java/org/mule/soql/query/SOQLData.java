package org.mule.soql.query;

import org.apache.commons.lang.StringUtils;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SOQLData implements ISOQLData {

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
