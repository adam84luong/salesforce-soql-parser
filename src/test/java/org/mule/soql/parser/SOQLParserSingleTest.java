package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Global_Region__c, Sub_Region__c, COUNT(Id) FROM Account group by  ROLLUP (Global_Region__c ,Sub_Region__c)");
	}

}
