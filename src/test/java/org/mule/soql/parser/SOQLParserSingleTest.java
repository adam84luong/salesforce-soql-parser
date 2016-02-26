package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Id, Account_Manager__c, LastModifiedBy.Name, LastModifiedDate, RecordType.Name FROM Case WHERE Account_Manager__c != null");
	}

}
