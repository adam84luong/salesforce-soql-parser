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
 * Visitor defined for the SOQL Data structure returned by the SOQL Parser Helper.
 * It contains a visit method for each node type of the structure.
 */
public interface SOQLDataVisitor<T> {

    T visit(SOQLData soqlData);

    T visitSOQLQuery(SOQLQuery soqlQuery);

    T visitSOQLSubQuery(SOQLSubQuery soqlSubQuery);

    //Clause

    T visitSelectClause(SelectClause selectClause);

    T visitFromClause(FromClause fromClause);

    T visitWithPlainClause(WithPlainClause withPlainClause);

    T visitWithDataCategoryClause(WithDataCategoryClause withDataCategoryClause);

    T visitWhereClause(WhereClause whereClause);

    T visitGroupByPlainClause(GroupByPlainClause groupByPlainClause);

    T visitGroupByCubeClause(GroupByCubeClause groupByCubeClause);

    T visitGroupByRollupClause(GroupByRollupClause groupByRollupClause);

    T visitHavingClause(HavingClause havingClause);

    T visitOrderByClause(OrderByClause orderByClause);

    T visitForClause(ForClause forClause);

    T visitUpdateClause(UpdateClause updateClause);

    //Select

    T visitFieldSpec(FieldSpec fieldSpec);

    T visitFunctionCallSpec(FunctionCallSpec functionCallSpec);

    T visitTypeOf(TypeOf typeOf);

    //With

    T visitDataCategorySpec(DataCategorySpec dataCategorySpec);

    //OrderBy

    T visitOrderBySpec(OrderBySpec orderBySpec);

    //From

    T visitObjectSpec(ObjectSpec objectSpec);

    //Data

    T visitField(Field field);

    T visitFunctionCall(FunctionCall functionCall);

    T visitLiteral(Literal literal);

    //Condition

    T visitSetBasedCondition(SetBasedCondition setBasedCondition);

    T visitLikeBasedCondition(LikeBasedCondition likeBasedCondition);

    T visitFieldBasedCondition(FieldBasedCondition fieldBasedCondition);

    T visitSetValues(SetValues setValues);

    T visitParenthesis(Parenthesis parenthesis);

    T visitOrOperator(OrOperator orOperator);

    T visitNorOperator(NotOperator notOperator);

    T visitAndOperator(AndOperator andOperator);

}
