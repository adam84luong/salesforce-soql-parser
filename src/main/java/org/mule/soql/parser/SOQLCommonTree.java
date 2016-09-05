/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.mule.soql.query.SOQLData;

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

    public abstract <T extends SOQLData> T createSOQLData();

}
