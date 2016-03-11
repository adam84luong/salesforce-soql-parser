package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("select id, body from attachment where parentid in (select id from contact where exportcheckbox__c = true and exportinitializer__c = '005900000033r8caaq') and description like 'cp%' order by id");
	}

}