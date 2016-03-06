package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Store_Num_Link__r.Rep__c, SUM(December_Rep__c,Parameter,Parameter) Dec, SUM(November_Rep__c) Nov, SUM(October_Rep__c) Oct, SUM(Store_Num_Link__r.First_Full_Month_Revenue__c) FFM FROM Store_Revenue__c WHERE Year_Text__c = '2013' AND Store_Num_Link__r.Office__c IN('S41','S43') AND Store_Num_Link__r.Assign_Date__c >= 2013-09-01 AND Store_Num_Link__r.Assign_Date__c <= 2013-12-31 GROUP BY Store_Num_Link__r.Rep__c ORDER BY Store_Num_Link__r.Rep__c ASC");
	}

}
