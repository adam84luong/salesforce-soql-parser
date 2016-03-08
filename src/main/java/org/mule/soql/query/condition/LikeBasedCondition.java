package org.mule.soql.query.condition;

import org.mule.soql.query.SOQLData;

/**
 * Created by damianpelaez on 3/6/16.
 */
public class LikeBasedCondition extends SOQLData implements Condition {
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
