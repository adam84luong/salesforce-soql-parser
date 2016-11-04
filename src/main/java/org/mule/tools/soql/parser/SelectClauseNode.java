/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.tools.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.tools.soql.query.clause.SelectClause;
import org.mule.tools.soql.query.select.SelectSpec;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class SelectClauseNode extends SOQLCommonTree {

    public SelectClauseNode(Token t) {
        super(t);
    }

    @Override
    public SelectClause createSOQLData() {
        SelectClause selectClause = new SelectClause();

        this.processChildren(selectClause);

        return selectClause;
    }

    private void processChildren(SelectClause selectClause) {
        List<CommonTree> children = (List<CommonTree>) this.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillSelectSpec(child, selectClause);
        }
    }

    private void fillSelectSpec(CommonTree node, SelectClause selectClause) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD_SPEC, SOQLParser.FUNCTION_CALL_SPEC, SOQLParser.SOQL_SUBQUERY, SOQLParser.TYPEOF)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        selectClause.addSelectSpec((SelectSpec) soqlNode.createSOQLData());
    }

}
