package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Id, Name, TYPEOF Parent WHEN Opportunity THEN Name, Id END FROM Attachment WHERE Parent.Type IN ('Opportunity')");
	}

}
