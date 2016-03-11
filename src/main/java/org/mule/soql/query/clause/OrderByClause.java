package org.mule.soql.query.clause;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.order.OrderBySpec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 3/8/16.
 */
public class OrderByClause extends SOQLData {
    protected List<OrderBySpec> orderBySpecs = new ArrayList<OrderBySpec>();

    public OrderByClause() {
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.createSOQLListText(orderBySpecs, ","));

        return sb.toString();
    }

    public void addOrderBySpec(OrderBySpec orderBySpec) {
        if(orderBySpec == null) { return; }

        if(orderBySpec == null) {
            orderBySpecs = new ArrayList<OrderBySpec>();
        }

        orderBySpecs.add(orderBySpec);
    }

    public List<OrderBySpec> getOrderBySpecs() {
        return orderBySpecs;
    }

}
