package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.with.DataCategorySelector;
import org.mule.soql.query.with.DataCategorySpec;

import java.util.List;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class DataCategorySpecNode extends SOQLCommonTree {

    public DataCategorySpecNode(int tokenType) {
        super(new CommonToken(tokenType, "DATA_CATEGORY_SPEC"));
    }

    @Override
    public DataCategorySpec createSOQLData() {
        DataCategorySpec dataCategorySpec = new DataCategorySpec();

        this.processFirstNode(dataCategorySpec);
        this.processSecondNode(dataCategorySpec);
        this.processThirdNode(dataCategorySpec);

        return dataCategorySpec;
    }

    private void processFirstNode(DataCategorySpec dataCategorySpec) {
        CommonTree node = (CommonTree) this.getChild(0);

        if(node == null) { return; }

        dataCategorySpec.setDataCategoryGroupName(node.getText());
    }

    private void processSecondNode(DataCategorySpec dataCategorySpec) {
        CommonTree node = (CommonTree) this.getChild(1);

        if(node == null) { return; }

        this.fillDataCategorySelector(node, dataCategorySpec);
    }

    private void processThirdNode(DataCategorySpec dataCategorySpec) {
        CommonTree node = (CommonTree) this.getChild(2);

        if(node == null) { return; }

        this.fillDataCategoryNames(node, dataCategorySpec);
    }

    private void fillDataCategorySelector(CommonTree node, DataCategorySpec dataCategorySpec) {
        DataCategorySelector dataCategorySelector = DataCategorySelector.get(node.getText());

        if(dataCategorySelector == null) { return; }

        dataCategorySpec.setDataCategorySelector(dataCategorySelector);
    }

    private void fillDataCategoryNames(CommonTree node, DataCategorySpec dataCategorySpec) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.DATA_CATEGORY_PARAMETERS)) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        for(CommonTree child : children) {
            dataCategorySpec.addDataCategoryName(child.getText());
        }
    }

}
