package org.mule.soql.query.condition;

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

    public static SetOperator getSetOperator(String value){
        for(SetOperator e : SetOperator.values()){
            if(e.getValue().equals(value)) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }

}
