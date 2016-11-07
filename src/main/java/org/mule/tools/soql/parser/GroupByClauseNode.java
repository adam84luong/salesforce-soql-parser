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
import org.mule.tools.soql.query.clause.GroupByClause;
import org.mule.tools.soql.query.clause.GroupByCubeClause;
import org.mule.tools.soql.query.clause.GroupByPlainClause;
import org.mule.tools.soql.query.clause.GroupByRollupClause;
import org.mule.tools.soql.query.group.GroupBySpec;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class GroupByClauseNode extends SOQLCommonTree {

    public GroupByClauseNode(Token t) {
        super(t);
    }

    @Override
    public GroupByClause createSOQLData() {
        return processFirstNode();
    }

    private GroupByClause processFirstNode() {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return null; }

        GroupByClause groupByClause = null;

        if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.GROUP_BY_PLAIN_CLAUSE)) {
            groupByClause = new GroupByPlainClause();
        } else if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.ROLLUP)) {
            groupByClause = new GroupByRollupClause();
        } else if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.CUBE)) {
            groupByClause = new GroupByCubeClause();
        }

        this.fillGroupBySpecs(child, groupByClause);

        return groupByClause;
    }

    private void fillGroupBySpecs(CommonTree node, GroupByClause groupByPlainClause) {
        if(groupByPlainClause == null) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillGroupBySpec(child, groupByPlainClause);
        }
    }

    private void fillGroupBySpec(CommonTree node, GroupByClause groupByPlainClause) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        groupByPlainClause.addGroupBySpec((GroupBySpec) soqlNode.createSOQLData());
    }

}
