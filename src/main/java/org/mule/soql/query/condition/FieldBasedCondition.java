/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.condition;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;
import org.mule.soql.query.condition.operator.ComparisonOperator;
import org.mule.soql.query.data.Literal;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class FieldBasedCondition extends SOQLAbstractData implements Condition {
    private ConditionField conditionField;
    private ComparisonOperator operator;
    private Literal literal;

    public FieldBasedCondition() {
    }

    public FieldBasedCondition(ConditionField conditionField, ComparisonOperator operator, Literal literal) {
        this.conditionField = conditionField;
        this.operator = operator;
        this.literal = literal;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(conditionField != null) {
            sb.append(conditionField.toSOQLText());
        }

        sb.append(" ").append(operator).append(" ");

        if(literal != null) {
            sb.append(literal.toSOQLText());
        }

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitFieldBasedCondition(this);
    }

    public ConditionField getConditionField() {
        return conditionField;
    }

    public void setConditionField(ConditionField conditionField) {
        this.conditionField = conditionField;
    }

    public ComparisonOperator getOperator() {
        return operator;
    }

    public void setOperator(ComparisonOperator operator) {
        this.operator = operator;
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(Literal literal) {
        this.literal = literal;
    }

}
