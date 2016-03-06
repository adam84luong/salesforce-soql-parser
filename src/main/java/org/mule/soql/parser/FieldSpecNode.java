package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.query.Field;
import org.mule.soql.query.FieldSpec;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FieldSpecNode extends SOQLCommonTree {

    public FieldSpecNode(int tokenType) {
        super(new CommonToken(tokenType, "FIELD_SPEC"));
    }

    @Override
    public FieldSpec createSOQLData() {
        CommonTree firstChild = (CommonTree) this.getChild(0);
        CommonTree secondChild = (CommonTree) this.getChild(1);

        Field field = null;
        String alias = null;

        if (this.matchesLabel(firstChild,"FIELD")) {
            field = this.createField((SOQLCommonTree) firstChild);
        }

        if (secondChild != null) {
            alias = secondChild.getText();
        }

        return new FieldSpec(field, alias);
    }

    private Field createField(SOQLCommonTree node) {
        return node.createSOQLData();
    }

}
