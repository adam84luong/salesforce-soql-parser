package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.query.Literal;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class LiteralNode extends SOQLCommonTree {

    public LiteralNode(int tokenType) {
        super(new CommonToken(tokenType, "LITERAL"));
    }

    @Override
    public Literal createSOQLData() {
        CommonTree firstChild = (CommonTree) this.getChild(0);

        String value = null;

        if (firstChild != null) {
            value = firstChild.getText();
        }

        return new Literal(value);
    }

}
