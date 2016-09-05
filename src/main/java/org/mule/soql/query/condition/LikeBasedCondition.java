/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.query.condition;

import org.mule.soql.SOQLDataVisitor;
import org.mule.soql.query.SOQLAbstractData;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class LikeBasedCondition extends SOQLAbstractData implements Condition {
    private ConditionField conditionField;
    private String likeString;

    public LikeBasedCondition() {
    }

    public LikeBasedCondition(ConditionField conditionField, String likeString) {
        this.conditionField = conditionField;
        this.likeString = likeString;
    }

    @Override
    public String toSOQLText() {
        StringBuilder sb = new StringBuilder();

        if(conditionField != null) {
            sb.append(conditionField.toSOQLText());
        }

        sb.append(" ").append("LIKE").append(" ");

        if(likeString != null) {
            sb.append(likeString);
        }

        return sb.toString();
    }

    public <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor) {
        return soqlDataVisitor.visitLikeBasedCondition(this);
    }

    public ConditionField getConditionField() {
        return conditionField;
    }

    public void setConditionField(ConditionField conditionField) {
        this.conditionField = conditionField;
    }

    public String getLikeString() {
        return likeString;
    }

    public void setLikeString(String likeString) {
        this.likeString = likeString;
    }

}
