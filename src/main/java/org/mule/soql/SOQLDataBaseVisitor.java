package org.mule.soql;

import org.mule.soql.query.SOQLData;
import org.mule.soql.query.SOQLQuery;
import org.mule.soql.query.SOQLSubQuery;
import org.mule.soql.query.clause.*;
import org.mule.soql.query.condition.FieldBasedCondition;
import org.mule.soql.query.condition.LikeBasedCondition;
import org.mule.soql.query.condition.SetBasedCondition;
import org.mule.soql.query.condition.SetValues;
import org.mule.soql.query.condition.operator.AndOperator;
import org.mule.soql.query.condition.operator.NotOperator;
import org.mule.soql.query.condition.operator.OrOperator;
import org.mule.soql.query.condition.operator.Parenthesis;
import org.mule.soql.query.data.Field;
import org.mule.soql.query.data.FunctionCall;
import org.mule.soql.query.data.Literal;
import org.mule.soql.query.from.ObjectSpec;
import org.mule.soql.query.order.OrderBySpec;
import org.mule.soql.query.select.FieldSpec;
import org.mule.soql.query.select.FunctionCallSpec;
import org.mule.soql.query.select.TypeOf;
import org.mule.soql.query.with.DataCategorySpec;

/**
 * Base implementation for the SOQLDataVisitor.
 * You can extend this class and create a new Visitor only overriding the visit methods that are relevant to it.
 */
public class SOQLDataBaseVisitor<T> implements SOQLDataVisitor<T> {

    public T visit(SOQLData soqlData) {
        return soqlData.accept(this);
    }

    public T visitSOQLQuery(SOQLQuery soqlQuery) {
        return null;
    }

    public T visitSOQLSubQuery(SOQLSubQuery soqlSubQuery) {
        return null;
    }

    public T visitSelectClause(SelectClause selectClause) {
        return null;
    }

    public T visitFromClause(FromClause fromClause) {
        return null;
    }

    public T visitWithPlainClause(WithPlainClause withPlainClause) {
        return null;
    }

    public T visitWithDataCategoryClause(WithDataCategoryClause withDataCategoryClause) {
        return null;
    }

    public T visitWhereClause(WhereClause whereClause) {
        return null;
    }

    public T visitGroupByPlainClause(GroupByPlainClause groupByPlainClause) {
        return null;
    }

    public T visitGroupByCubeClause(GroupByCubeClause groupByCubeClause) {
        return null;
    }

    public T visitGroupByRollupClause(GroupByRollupClause groupByRollupClause) {
        return null;
    }

    public T visitHavingClause(HavingClause havingClause) {
        return null;
    }

    public T visitOrderByClause(OrderByClause orderByClause) {
        return null;
    }

    public T visitForClause(ForClause forClause) {
        return null;
    }

    public T visitUpdateClause(UpdateClause updateClause) {
        return null;
    }

    public T visitFieldSpec(FieldSpec fieldSpec) {
        return null;
    }

    public T visitFunctionCallSpec(FunctionCallSpec functionCallSpec) {
        return null;
    }

    public T visitTypeOf(TypeOf typeOf) {
        return null;
    }

    public T visitDataCategorySpec(DataCategorySpec dataCategorySpec) {
        return null;
    }

    public T visitOrderBySpec(OrderBySpec orderBySpec) {
        return null;
    }

    public T visitObjectSpec(ObjectSpec objectSpec) {
        return null;
    }

    public T visitField(Field field) {
        return null;
    }

    public T visitFunctionCall(FunctionCall functionCall) {
        return null;
    }

    public T visitLiteral(Literal literal) {
        return null;
    }

    public T visitSetBasedCondition(SetBasedCondition setBasedCondition) {
        return null;
    }

    public T visitLikeBasedCondition(LikeBasedCondition likeBasedCondition) {
        return null;
    }

    public T visitFieldBasedCondition(FieldBasedCondition fieldBasedCondition) {
        return null;
    }

    public T visitSetValues(SetValues setValues) {
        return null;
    }

    public T visitParenthesis(Parenthesis parenthesis) {
        return null;
    }

    public T visitOrOperator(OrOperator orOperator) {
        return null;
    }

    public T visitNorOperator(NotOperator notOperator) {
        return null;
    }

    public T visitAndOperator(AndOperator andOperator) {
        return null;
    }
}
