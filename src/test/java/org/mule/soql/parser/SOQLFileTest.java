/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SOQLFileTest extends SOQLParserTest {

    public SOQLFileTest(String line) {
        super(line);
    }

    private static final String FILENAME = "src/test/resources/SOQLTest.csv";

    @Parameterized.Parameters
    public static Iterable<Object[]> data() throws Exception {
        return new FileIterable(FILENAME);
    }

}
