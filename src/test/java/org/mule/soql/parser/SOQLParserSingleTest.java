package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Id, Title FROM Offer__kav WHERE PublishStatus='Draft' AND Language = 'en_US' WITH DATA CATEGORY Geography__c AT (france__c,usa__c) AND Product__c ABOVE dsl__c");
	}

}
