package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.SOQLGenericQuery;
import org.mule.soql.query.clause.*;

/**
 * Created by damianpelaez on 2/26/16.
 */
public abstract class SOQLGenericQueryNode extends SOQLCommonTree {

    public SOQLGenericQueryNode(CommonToken commonToken) {
        super(commonToken);
    }

    protected void fillSoqlQuery(SOQLGenericQuery soqlQuery) {
        this.fillSelectClause(soqlQuery);
        this.fillFromClause(soqlQuery);
        this.fillUsingFilterScope(soqlQuery);
        this.fillWhereClause(soqlQuery);
        this.fillWithClause(soqlQuery);
        this.fillGroupByClause(soqlQuery);
        this.fillHavingClause(soqlQuery);
        this.fillOrderByClause(soqlQuery);
        this.fillLimit(soqlQuery);
        this.fillOffset(soqlQuery);
        this.fillForClause(soqlQuery);
        this.fillUpdateClause(soqlQuery);
    }

    protected void fillSelectClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.SELECT);

        if(node == null) { return; }

        soqlQuery.setSelectClause((SelectClause) node.createSOQLData());
    }

    protected void fillFromClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.FROM);

        if(node == null) { return; }

        soqlQuery.setFromClause((FromClause) node.createSOQLData());
    }

    protected void fillUsingFilterScope(SOQLGenericQuery soqlQuery) {
        CommonTree node = (CommonTree) this.getFirstChildWithType(SOQLParser.USING);

        if(node == null) { return; }

        CommonTree child = (CommonTree) node.getChild(0);

        if(child == null) { return; }

        soqlQuery.setUsingFilterScope(child.getText());
    }

    protected void fillWhereClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.WHERE);

        if(node == null) { return; }

        soqlQuery.setWhereClause((WhereClause) node.createSOQLData());
    }

    protected void fillWithClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.WITH);

        if(node == null) { return; }

        soqlQuery.setWithClause((WithClause) node.createSOQLData());
    }

    protected void fillGroupByClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.GROUP);

        if(node == null) { return; }

        soqlQuery.setGroupByClause((GroupByClause) node.createSOQLData());
    }

    protected void fillHavingClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.HAVING);

        if(node == null) { return; }

        soqlQuery.setHavingClause((HavingClause) node.createSOQLData());
    }

    protected void fillOrderByClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.ORDER);

        if(node == null) { return; }

        soqlQuery.setOrderByClause((OrderByClause) node.createSOQLData());
    }

    protected void fillLimit(SOQLGenericQuery soqlQuery) {
        CommonTree node = (CommonTree) this.getFirstChildWithType(SOQLParser.LIMIT);

        if(node == null) { return; }

        CommonTree child = (CommonTree) node.getChild(0);

        soqlQuery.setLimit(SOQLCommonTreeUtils.getTextAsInteger(child));
    }

    protected void fillOffset(SOQLGenericQuery soqlQuery) {
        CommonTree node = (CommonTree) this.getFirstChildWithType(SOQLParser.OFFSET);

        if(node == null) { return; }

        CommonTree child = (CommonTree) node.getChild(0);

        soqlQuery.setOffset(SOQLCommonTreeUtils.getTextAsInteger(child));
    }

    protected void fillForClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.FOR);

        if(node == null) { return; }

        soqlQuery.setForClause((ForClause) node.createSOQLData());
    }

    protected void fillUpdateClause(SOQLGenericQuery soqlQuery) {
        SOQLCommonTree node = (SOQLCommonTree) this.getFirstChildWithType(SOQLParser.UPDATE);

        if(node == null) { return; }

        soqlQuery.setUpdateClause((UpdateClause) node.createSOQLData());
    }

}
