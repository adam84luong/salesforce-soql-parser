package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
import org.mule.soql.query.data.Literal;

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
        this.processSecondNode(literal);

        return literal;
    }

    private void processFirstNode(Literal literal) {
        CommonTree child = (CommonTree) this.getChild(0);

        if(child == null) { return; }

        literal.setValue(child.getText());
    }

    private void processSecondNode(Literal literal) {
        CommonTree child = (CommonTree) this.getChild(1);

        if(child == null) { return; }

        literal.setParameter(SOQLCommonTreeUtils.getTextAsInteger(child));
    }

}
