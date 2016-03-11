package org.mule.soql.query.clause;

import org.mule.soql.query.with.DataCategorySpec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class WithDataCategoryClause extends WithClause {
    private List<DataCategorySpec> dataCategorySpecs;

    public WithDataCategoryClause() {
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append("WITH DATA CATEGORY").append(" ");

        sb.append(this.createSOQLListText(dataCategorySpecs, " AND "));

        return sb.toString();
    }

    public void addDataCategorySpec(DataCategorySpec dataCategorySpec) {
        if(dataCategorySpec == null) { return; }

        if(dataCategorySpecs == null) {
            dataCategorySpecs = new ArrayList<DataCategorySpec>();
        }

        dataCategorySpecs.add(dataCategorySpec);
    }

    public List<DataCategorySpec> getDataCategorySpecs() {
        return dataCategorySpecs;
    }

}
