package org.mule.soql.query.condition;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.data.Literal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/7/16.
 */
public class SetValues extends SOQLAbstractData implements ConditionSet {
    private List<Literal> values = new ArrayList<Literal>();

    public SetValues() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");

        sb.append(this.createSOQLListText(values, ","));

        sb.append(")");

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitSetValues(this);
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
