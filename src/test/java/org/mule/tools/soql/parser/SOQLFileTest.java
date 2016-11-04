package org.mule.tools.soql.parser;

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
