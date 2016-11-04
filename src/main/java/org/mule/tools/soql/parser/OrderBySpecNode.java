/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.tools.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.tools.soql.query.order.OrderByDirection;
import org.mule.tools.soql.query.order.OrderByField;
import org.mule.tools.soql.query.order.OrderByNulls;
import org.mule.tools.soql.query.order.OrderBySpec;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class OrderBySpecNode extends SOQLCommonTree {

    public OrderBySpecNode(int tokenType) {
        super(new CommonToken(tokenType, "ORDER_BY_SPEC"));
    }

    @Override
    public OrderBySpec createSOQLData() {
        OrderBySpec orderBySpec = new OrderBySpec();

        this.processFirstNode(orderBySpec);
        this.processSecondNode(orderBySpec);
        this.processThirdNode(orderBySpec);

        return orderBySpec;
    }

    private void processFirstNode(OrderBySpec orderBySpec) {
        CommonTree child = (CommonTree) this.getChild(0);

        if (child == null) { return; }

        this.fillOrderByField(child, orderBySpec);
    }

    private void processSecondNode(OrderBySpec orderBySpec) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child == null) { return; }

        if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.ASC, SOQLParser.DESC)) {
            this.fillOrderByDirection(child, orderBySpec);
        } else if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.NULLS)) {
            this.fillOrderByNulls(child, orderBySpec);
        }
    }

    private void processThirdNode(OrderBySpec orderBySpec) {
        CommonTree child = (CommonTree) this.getChild(2);

        if (child == null) { return; }

        this.fillOrderByNulls(child, orderBySpec);
    }

    private void fillOrderByField(CommonTree node, OrderBySpec orderBySpec) {
        if (!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        orderBySpec.setOrderByField((OrderByField) soqlNode.createSOQLData());
    }

    private void fillOrderByDirection(CommonTree node, OrderBySpec orderBySpec) {
        OrderByDirection orderByDirection = OrderByDirection.get(node.getText());

        if (orderByDirection == null) { return; }

        orderBySpec.setDirection(orderByDirection);
    }

    private void fillOrderByNulls(CommonTree node, OrderBySpec orderBySpec) {
        CommonTree child = (CommonTree) node.getChild(0);

        OrderByNulls orderByNulls = OrderByNulls.get(child.getText());

        if (orderByNulls == null) { return; }

        orderBySpec.setNulls(orderByNulls);
    }

}
