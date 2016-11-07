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
import org.mule.tools.soql.query.clause.WithClause;
import org.mule.tools.soql.query.clause.WithDataCategoryClause;
import org.mule.tools.soql.query.clause.WithPlainClause;
import org.mule.tools.soql.query.condition.FieldBasedCondition;
import org.mule.tools.soql.query.with.DataCategorySpec;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class WithClauseNode extends SOQLCommonTree {

    public WithClauseNode(Token t) {
        super(t);
    }

    @Override
    public WithClause createSOQLData() {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return null; }

        WithClause withClause = null;

        if(SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.WITH_PLAIN_CLAUSE)) {
            withClause = this.createWithPlainClause(child);
        } else if(SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.DATA)) {
            withClause = this.createWithDataCategoryClause(child);
        }

        return withClause;
    }

    private WithPlainClause createWithPlainClause(CommonTree node) {
        WithPlainClause withPlainClause = new WithPlainClause();

        this.processWithPlainClauseFirstNode(node, withPlainClause);

        return withPlainClause;
    }

    private void processWithPlainClauseFirstNode(CommonTree node, WithPlainClause withPlainClause) {
        CommonTree child = (CommonTree) node.getChild(0);

        if(!SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.FIELD_BASED_CONDITION)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) child;

        withPlainClause.setFieldBasedCondition((FieldBasedCondition) soqlNode.createSOQLData());
    }

    private WithDataCategoryClause createWithDataCategoryClause(CommonTree node) {
        WithDataCategoryClause withDataCategoryClause = new WithDataCategoryClause();

        this.processWithDataCategoryClauseChildren(node, withDataCategoryClause);

        return withDataCategoryClause;
    }

    private void processWithDataCategoryClauseChildren(CommonTree node, WithDataCategoryClause withDataCategoryClause) {
        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillDataCategorySpec(child, withDataCategoryClause);
        }
    }

    private void fillDataCategorySpec(CommonTree node, WithDataCategoryClause withDataCategoryClause) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.DATA_CATEGORY_SPEC)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        withDataCategoryClause.addDataCategorySpec((DataCategorySpec) soqlNode.createSOQLData());
    }

}
