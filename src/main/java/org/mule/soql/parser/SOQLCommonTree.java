package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.query.SOQLData;

import java.util.List;

/**
 * Created by damianpelaez on 3/4/16.
 */
public abstract class SOQLCommonTree extends CommonTree {

    public SOQLCommonTree(CommonTree node) {
        super(node);
    }

    public SOQLCommonTree(Token t) {
        super(t);
    }

    public <T extends SOQLData> T createSOQLData() {
        return null;
    }

    public void printSOQLData() {
        List<CommonTree> children = (List<CommonTree>) this.getChildren();

        SOQLData soqlData = this.createSOQLData();

        if(soqlData != null) {
            System.out.println(this.getText() + ": " + soqlData.toSOQLText());
        }

        for(CommonTree child : children) {
            if(child instanceof SOQLCommonTree) {
                SOQLCommonTree node = (SOQLCommonTree) child;
                node.printSOQLData();
            }
        }
    }

}
