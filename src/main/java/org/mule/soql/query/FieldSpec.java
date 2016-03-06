package org.mule.soql.query;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FieldSpec extends SOQLData {
    private Field field;
    private String alias;

    public FieldSpec(Field field, String alias) {
        this.field = field;
        this.alias = alias;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(field != null) {
            sb.append(field.toSOQLText());
        }

        if(alias != null) {
            sb.append(" ").append(alias);
        }

        return sb.toString();
    }

    public Field getField() {
        return field;
    }

    public String getAlias() {
        return alias;
    }

}
