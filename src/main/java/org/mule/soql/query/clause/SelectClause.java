package org.mule.soql.query.clause;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.select.SelectSpec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class SelectClause extends SOQLData {
    private List<SelectSpec> selectSpecs = new ArrayList<SelectSpec>();

    public SelectClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT").append(" ");

        if(selectSpecs != null) {
            for(SelectSpec selectSpec : selectSpecs) {
                if(!selectSpecs.get(0).equals(selectSpec)) {
                    sb.append(",");
                }
                sb.append(selectSpec.toSOQLText());
            }
        }

        return sb.toString();
    }

    public void addSelectSpec(SelectSpec selectSpec) {
        if(selectSpec == null) { return; }

        if(selectSpec == null) {
            selectSpecs = new ArrayList<SelectSpec>();
        }

        selectSpecs.add(selectSpec);
    }

    public List<SelectSpec> getSelectSpecs() {
        return selectSpecs;
    }

}
