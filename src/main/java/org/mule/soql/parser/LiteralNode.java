package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.query.Literal;
import org.mule.soql.query.condition.LogicalOperator;

/**
 * Created by damianpelaez on 3/4/16.
 */
public class LiteralNode extends SOQLCommonTree {

    public LiteralNode(int tokenType) {
        super(new CommonToken(tokenType, "LITERAL"));
    }

    @Override
    public Literal createSOQLData() {
        Literal literal = new Literal();

        this.processFirstNode(literal);

        return literal;
    }

    private void processFirstNode(Literal literal) {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return; }

        literal.setValue(child.getText());
    }

}
