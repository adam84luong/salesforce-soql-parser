/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.clause.OrderByClause;
import org.mule.soql.query.order.OrderBySpec;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class OrderByClauseNode extends SOQLCommonTree {

    public OrderByClauseNode(Token t) {
        super(t);
    }

    @Override
    public OrderByClause createSOQLData() {
        OrderByClause orderByClause = new OrderByClause();

        this.processChildren(orderByClause);

        return orderByClause;
    }

    private void processChildren(OrderByClause orderByClause) {
        List<CommonTree> children = (List<CommonTree>) this.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillOrderBySpec(child, orderByClause);
        }
    }

    private void fillOrderBySpec(CommonTree node, OrderByClause orderByClause) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.ORDER_BY_SPEC)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        orderByClause.addOrderBySpec((OrderBySpec) soqlNode.createSOQLData());
    }

}
