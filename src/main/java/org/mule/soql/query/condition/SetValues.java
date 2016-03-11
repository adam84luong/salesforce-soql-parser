package org.mule.soql.query.condition;

import org.mule.soql.query.Literal;
import org.mule.soql.query.SOQLData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/7/16.
 */
public class SetValues extends SOQLData implements ConditionSet {
    private List<Literal> values = new ArrayList<Literal>();

    public SetValues() {
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");

        sb.append(this.createSOQLListText(values, ","));

        sb.append(")");

        return sb.toString();
    }

    public void addValue(Literal literal) {
        if(literal == null) { return; }

        if(values == null) {
            values = new ArrayList<Literal>();
        }

        values.add(literal);
    }

    public List<Literal> getValues() {
        return values;
    }

}
