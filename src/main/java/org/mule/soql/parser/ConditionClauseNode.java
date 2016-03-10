package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.clause.ConditionClause;
import org.mule.soql.query.clause.HavingClause;
import org.mule.soql.query.clause.WhereClause;
import org.mule.soql.query.condition.Condition;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class ConditionClauseNode extends SOQLCommonTree {

    public ConditionClauseNode(Token t) {
        super(t);
    }

    @Override
    public ConditionClause createSOQLData() {
        ConditionClause conditionClause = null;

        if(SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.WHERE)) {
            conditionClause = new WhereClause();
        } else if (SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.HAVING)) {
            conditionClause = new HavingClause();
        }

        this.fillConditionClause(conditionClause);

        return conditionClause;
    }

    private void fillConditionClause(ConditionClause conditionClause) {
        if(conditionClause == null) { return; }

        this.processFirstNode(conditionClause);
    }

    private void processFirstNode(ConditionClause conditionClause) {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return; }

        this.fillCondition(child, conditionClause);
    }

    private void fillCondition(CommonTree node, ConditionClause conditionClause) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        conditionClause.setCondition((Condition) soqlNode.createSOQLData());
    }

}
