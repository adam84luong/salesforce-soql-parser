/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.clause.ForClause;
import org.mule.soql.query.clause.OptionClause;
import org.mule.soql.query.clause.UpdateClause;
import org.mule.soql.query.option.ForOption;
import org.mule.soql.query.option.UpdateOption;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class OptionClauseNode extends SOQLCommonTree {

    public OptionClauseNode(Token t) {
        super(t);
    }

    @Override
    public OptionClause createSOQLData() {
        if(SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.UPDATE)) {
            return this.createUpdateClause();
        } else if (SOQLCommonTreeUtils.matchesAnyType(this, SOQLParser.FOR)) {
            return this.createForClause();
        }
        return null;
    }

    private UpdateClause createUpdateClause() {
        UpdateClause updateClause = new UpdateClause();

        this.processChildren(this, updateClause);

        return updateClause;
    }

    private ForClause createForClause() {
        ForClause forClause = new ForClause();

        this.processChildren(this, forClause);

        return forClause;
    }

    private void processChildren(CommonTree node, ForClause forClause) {
        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            forClause.addOption(ForOption.get(child.getText()));
        }
    }

    private void processChildren(CommonTree node, UpdateClause updateClause) {
        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children == null) { return; }

        for(CommonTree child : children) {
            updateClause.addOption(UpdateOption.get(child.getText()));
        }
    }

}
