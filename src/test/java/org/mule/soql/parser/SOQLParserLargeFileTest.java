package org.mule.soql.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SOQLParserLargeFileTest extends SOQLParserTest {

    public SOQLParserLargeFileTest(String line) {
        super(line);
    }

    private static final String FILENAME = "src/test/resources/SOQLLarge.csv";

    @Parameterized.Parameters
    public static Iterable<Object[]> data() throws Exception {
        return new FileIterable(FILENAME);
    }

}
