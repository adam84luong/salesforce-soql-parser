package org.mule.soql.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.query.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damianpelaez on 2/23/16.
 */
public class FieldNode extends SOQLCommonTree {

    public FieldNode(int tokenType) {
        super(new CommonToken(tokenType, "FIELD"));
    }

    @Override
    public Field createSOQLData() {
        CommonTree firstChild = (CommonTree) this.getChild(0);
        CommonTree secondChild = (CommonTree) this.getChild(1);

        List<String> objectNames = null;
        String fieldName = null;

        if (firstChild != null) {
            if(this.matchesLabel(firstChild,"OBJECT_PREFIX")){
                objectNames = this.createObjectNameList(firstChild);
            } else {
                fieldName = firstChild.getText();
            }
        }

        if (secondChild != null) {
            fieldName = secondChild.getText();
        }

        return new Field(objectNames,fieldName);
    }

    private List<String> createObjectNameList(CommonTree node) {
        List<String> objectNames = new ArrayList<String>();

        List<CommonTree> children = (List<CommonTree>) node.getChildren();

        if(children != null) {
            for(CommonTree child : children) {
                objectNames.add(child.getText());
            }
        }

        return objectNames;
    }

}

