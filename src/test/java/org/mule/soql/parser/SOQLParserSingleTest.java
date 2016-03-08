package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Store_Num_Link__r.Rep__c, SUM(December_Rep__c,FunctionParameter,FunctionParameter) Dec, COUNT() FFM FROM Parent.Store_Revenue__c store WHERE Year_Text__c = '2013' AND (Store_Num_Link__r.Office__c IN('S41','S43') AND Store_Num_Link__r.Assign_Date__c >= 2013-09-01 AND Store_Num_Link__r.Assign_Date__c <= 2013-12-31) AND SomeField like 'Arebga%' GROUP BY Store_Num_Link__r.Rep__c ORDER BY Store_Num_Link__r.Rep__c ASC");
	}

}