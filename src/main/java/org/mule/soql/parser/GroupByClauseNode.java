package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.clause.GroupByClause;
import org.mule.soql.query.clause.GroupByCubeClause;
import org.mule.soql.query.clause.GroupByPlainClause;
import org.mule.soql.query.clause.GroupByRollupClause;
import org.mule.soql.query.group.GroupByField;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class GroupByClauseNode extends SOQLCommonTree {

    public GroupByClauseNode(Token t) {
        super(t);
    }

    @Override
    public GroupByClause createSOQLData() {
        return processFirstNode();
    }

    private GroupByClause processFirstNode() {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return null; }

        GroupByClause groupByClause = null;

        if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.GROUP_BY_PLAIN_CLAUSE)) {
            groupByClause = new GroupByPlainClause();
        } else if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.ROLLUP)) {
            groupByClause = new GroupByRollupClause();
        } else if (SOQLCommonTreeUtils.matchesAnyType(child, SOQLParser.CUBE)) {
            groupByClause = new GroupByCubeClause();
        }

        this.fillGroupByFields(child, groupByClause);

        return groupByClause;
    }

    private void fillGroupByFields(CommonTree node, GroupByClause groupByPlainClause) {
        if(groupByPlainClause == null) { return; }

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            this.fillGroupByField(child, groupByPlainClause);
        }
    }

    private void fillGroupByField(CommonTree node, GroupByClause groupByPlainClause) {
        if(!SOQLCommonTreeUtils.matchesAnyType(node, SOQLParser.FIELD, SOQLParser.FUNCTION_CALL)) { return; }

        SOQLCommonTree soqlNode = (SOQLCommonTree) node;

        groupByPlainClause.addGroupField((GroupByField) soqlNode.createSOQLData());
    }

}
