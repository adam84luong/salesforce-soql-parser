package org.mule.soql.query.with;

import org.mule.soql.query.SOQLData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/9/16.
 */
public class DataCategorySpec extends SOQLData {
    private String dataCategoryGroupName;
    private DataCategorySelector dataCategorySelector;
    private List<String> dataCategoryNames = new ArrayList<String>();

    public DataCategorySpec() {

    }

    public DataCategorySpec(String dataCategoryGroupName, DataCategorySelector dataCategorySelector) {
        this.dataCategoryGroupName = dataCategoryGroupName;
        this.dataCategorySelector = dataCategorySelector;
    }

    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(dataCategoryGroupName != null) {
            sb.append(dataCategoryGroupName);
        }

        if(dataCategorySelector != null) {
            sb.append(" ").append(dataCategorySelector);
        }

        if(dataCategoryNames != null) {
            sb.append(" ");

            if(dataCategoryNames.size() == 1) {
                sb.append(this.createSOQLListText(dataCategoryNames, ","));
            } else {
                sb.append("(");
                sb.append(this.createSOQLListText(dataCategoryNames, ","));
                sb.append(")");
            }
        }

        return sb.toString();
    }

    public void addDataCategoryName(String dataCategoryName) {
        if(dataCategoryName == null) { return; }

        if(dataCategoryNames == null) {
            dataCategoryNames = new ArrayList<String>();
        }

        dataCategoryNames.add(dataCategoryName);
    }

    public String getDataCategoryGroupName() {
        return dataCategoryGroupName;
    }

    public void setDataCategoryGroupName(String dataCategoryGroupName) {
        this.dataCategoryGroupName = dataCategoryGroupName;
    }

    public DataCategorySelector getDataCategorySelector() {
        return dataCategorySelector;
    }

    public void setDataCategorySelector(DataCategorySelector dataCategorySelector) {
        this.dataCategorySelector = dataCategorySelector;
    }

    public List<String> getDataCategoryNames() {
        return dataCategoryNames;
    }

}
