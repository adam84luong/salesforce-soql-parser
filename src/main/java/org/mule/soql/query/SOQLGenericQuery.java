package org.mule.soql.query;

import org.mule.soql.query.clause.*;

/**
 * Created by damianpelaez on 3/6/16.
 */
public abstract class SOQLGenericQuery extends SOQLData {
    private SelectClause selectClause;
    private FromClause fromClause;
    private String usingFilterScope;
    private WhereClause whereClause;
    private WithClause withClause;
    private GroupByClause groupByClause;
    private HavingClause havingClause;
    private OrderByClause orderByClause;
    private Integer limit;
    private Integer offset;

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(selectClause != null) {
            sb.append(selectClause.toSOQLText());
        }

        if(fromClause != null) {
            sb.append(" ").append(fromClause.toSOQLText());
        }

        if(usingFilterScope != null) {
            sb.append(" ").append("USING SCOPE").append(" ").append(usingFilterScope);
        }

        if(whereClause != null) {
            sb.append(" ").append(whereClause.toSOQLText());
        }

        if(withClause != null) {
            sb.append(" ").append(withClause.toSOQLText());
        }

        if(groupByClause != null) {
            sb.append(" ").append(groupByClause.toSOQLText());
        }

        if(havingClause != null) {
            sb.append(" ").append(havingClause.toSOQLText());
        }

        if(orderByClause != null) {
            sb.append(" ").append(orderByClause.toSOQLText());
        }

        if(limit != null) {
            sb.append(" ").append("LIMIT").append(" ").append(limit);
        }

        if(offset != null) {
            sb.append(" ").append("OFFSET").append(" ").append(offset);
        }

        return sb.toString();
    }

    public SOQLGenericQuery() {
    }

    public SelectClause getSelectClause() {
        return selectClause;
    }

    public void setSelectClause(SelectClause selectClause) {
        this.selectClause = selectClause;
    }

    public FromClause getFromClause() {
        return fromClause;
    }

    public void setFromClause(FromClause fromClause) {
        this.fromClause = fromClause;
    }

    public String getUsingFilterScope() {
        return usingFilterScope;
    }

    public void setUsingFilterScope(String usingFilterScope) {
        this.usingFilterScope = usingFilterScope;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(WhereClause whereClause) {
        this.whereClause = whereClause;
    }

    public WithClause getWithClause() {
        return withClause;
    }

    public void setWithClause(WithClause withClause) {
        this.withClause = withClause;
    }

    public GroupByClause getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(GroupByClause groupByClause) {
        this.groupByClause = groupByClause;
    }

    public HavingClause getHavingClause() {
        return havingClause;
    }

    public void setHavingClause(HavingClause havingClause) {
        this.havingClause = havingClause;
    }

    public OrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(OrderByClause orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}
