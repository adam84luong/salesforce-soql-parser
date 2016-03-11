package org.mule.soql.query.select;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.data.Field;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FieldSpec extends SOQLData implements SelectSpec {
    private Field field;
    private String alias;

    public FieldSpec() {
    }

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

    public void setField(Field field) {
        this.field = field;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
