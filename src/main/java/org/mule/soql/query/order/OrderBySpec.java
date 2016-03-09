package org.mule.soql.query.order;

import org.mule.soql.query.SOQLData;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class OrderBySpec extends SOQLData {
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
