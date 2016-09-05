/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.order;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class OrderBySpec extends SOQLAbstractData {
    private OrderByField orderByField;
    private OrderByDirection direction;
    private OrderByNulls nulls;

    public OrderBySpec() {
    }

    public OrderBySpec(OrderByField orderByField, OrderByDirection direction, OrderByNulls nulls) {
        this.orderByField = orderByField;
        this.direction = direction;
        this.nulls = nulls;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(orderByField != null) {
            sb.append(orderByField.toSOQLText());
        }

        if(direction != null) {
            sb.append(" ").append(direction);
        }

        if(nulls != null) {
            sb.append(" ").append("NULLS").append(" ").append(nulls);
        }

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitOrderBySpec(this);
    }

    public OrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(OrderByField orderByField) {
        this.orderByField = orderByField;
    }

    public OrderByDirection getDirection() {
        return direction;
    }

    public void setDirection(OrderByDirection direction) {
        this.direction = direction;
    }

    public OrderByNulls getNulls() {
        return nulls;
    }

    public void setNulls(OrderByNulls nulls) {
        this.nulls = nulls;
    }

}
