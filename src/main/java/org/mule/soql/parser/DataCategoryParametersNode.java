package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class DataCategoryParametersNode extends SOQLCommonTree {

    public DataCategoryParametersNode(int tokenType) {
        super(new CommonToken(tokenType, "DATA_CATEGORY_PARAMETERS"));
    }

}
