package org.mule.soql.query.clause;

import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.option.Option;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by damianpelaez on 3/6/16.
 */
public abstract class OptionClause<T extends Option> extends SOQLAbstractData {
    protected Set<T> options = new LinkedHashSet<T>();

    public OptionClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getOptionClauseName()).append(" ");

        sb.append(this.createSOQLListText(options, ","));

        return sb.toString();
    }

    protected abstract String getOptionClauseName();

    public void addOption(T option) {
        if(option == null) { return; }

        if(options == null) {
            options = new LinkedHashSet<T>();
        }

        options.add(option);
    }

    public Set<T> getOptions() {
        return options;
    }

}
