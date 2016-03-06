package org.mule.soql.query;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class Literal extends SOQLData implements Parameter {
    private String value;

    public Literal(String value) {
        this.value = value;
    }

    @Override
    public String toSOQLText() {
        return value;
    }

    public String getValue() {
        return value;
    }

}
