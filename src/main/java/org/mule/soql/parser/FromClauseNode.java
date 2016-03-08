package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.FromClause;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class FromClauseNode extends SOQLCommonTree {

    public FromClauseNode(Token t) {
        super(t);
    }

    @Override
    public FromClause createSOQLData() {
        FromClause fromClause = new FromClause();

        this.processFirstNode(fromClause);
        this.processSecondNode(fromClause);
        this.processThirdNode(fromClause);

        return fromClause;
    }

    private void processFirstNode(FromClause fromClause) {
        CommonTree child = (CommonTree) this.getChild(0);

        if (SOQLCommonTreeUtils.matchesType(child,SOQLParser.OBJECT_PREFIX)) {
            this.createObjectNames(child,fromClause);
        } else {
            fromClause.setObjectName(child.getText());
        }
    }

    private void processSecondNode(FromClause fromClause) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child != null) {
            if(fromClause.getObjectName() == null) {
                fromClause.setObjectName(child.getText());
            } else {
                fromClause.setAlias(child.getText());
            }
        }
    }

    private void processThirdNode(FromClause fromClause) {
        CommonTree child = (CommonTree) this.getChild(2);

        if (child != null) {
            fromClause.setAlias(child.getText());
        }
    }

    private void createObjectNames(CommonTree node, FromClause fromClause) {
        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children != null) {
            for(CommonTree child : children) {
                fromClause.addObjectName(child.getText());
            }
        }
    }

}
