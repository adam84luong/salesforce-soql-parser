package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.ConditionClause;
import org.mule.soql.query.HavingClause;
import org.mule.soql.query.WhereClause;
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
        if(SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.WHERE)) {
            return this.createConditionClause(new WhereClause());
        } else if (SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.HAVING)) {
            return this.createConditionClause(new HavingClause());
        }
        return null;
    }

    private ConditionClause createConditionClause(ConditionClause conditionClause) {

        this.processFirstNode(conditionClause);

        return conditionClause;
    }

    private void processFirstNode(ConditionClause conditionClause) {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return; }

        this.createCondition(child, conditionClause);
    }

    private void createCondition(CommonTree node, ConditionClause conditionClause) {
        if (!SOQLCommonTreeUtils.isCondition(node)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        conditionClause.setCondition((Condition) soqlNode.createSOQLData());
    }

}
