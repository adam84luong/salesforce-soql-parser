package org.mule.soql.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SOQLSmallFileTest extends SOQLParserTest {

    public SOQLSmallFileTest(String line) {
        super(line);
    }

    private static final String FILENAME = "src/test/resources/SOQLSmall.csv";

    @Parameterized.Parameters
    public static Iterable<Object[]> data() throws Exception {
        return new FileIterable(FILENAME);
    }

}
