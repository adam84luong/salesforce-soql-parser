package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.parser.utils.SOQLCommonTreeUtils;
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
        FieldSpec fieldSpec = new FieldSpec();

        this.processFirstNode(fieldSpec);
        this.processSecondNode(fieldSpec);

        return fieldSpec;
    }

    private void processFirstNode(FieldSpec fieldSpec) {
        CommonTree child = (CommonTree) this.getChild(0);

        if (SOQLCommonTreeUtils.matchesType(child,SOQLParser.FIELD)) {
            fieldSpec.setField(this.createField((SOQLCommonTree) child));
        }
    }

    private void processSecondNode(FieldSpec fieldSpec) {
        CommonTree child = (CommonTree) this.getChild(1);

        if (child != null) {
            fieldSpec.setAlias(child.getText());
        }
    }

    private Field createField(SOQLCommonTree node) {
        return node.createSOQLData();
    }

}
