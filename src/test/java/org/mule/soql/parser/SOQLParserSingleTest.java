package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Store_Num_Link__r.Rep__c, SUM(December_Rep__c,FunctionParameter,FunctionParameter) Dec, COUNT() FFM FROM Parent.Store_Revenue__c store WHERE Year_Text__c = '2013' AND (Store_Num_Link__r.Office__c NOT IN ('S41','S43') AND Store_Num_Link__r.Assign_Date__c >= 2013-09-01 AND Store_Num_Link__r.Assign_Date__c <= 2013-12-31) AND SomeField like 'Arebga%' GROUP BY Store_Num_Link__r.Rep__c,SomeField ORDER BY Store_Num_Link__r.Rep__c ASC NULLS FIRST, COUNT(SomeField) DESC");
//		super("SELECT Title, Summary FROM KnowledgeArticleVersion WHERE PublishStatus='Online' AND Language = 'en_US' WITH DATA CATEGORY Geography__c ABOVE_OR_BELOW europe__c AND Product__c BELOW All__c");
//		super("SELECT Id FROM UserProfileFeed WITH UserId='005D0000001AamR' ORDER BY CreatedDate DESC, Id DESC LIMIT 20");
//		super("select id, (select id, createddate from campaignmembers order by createddate limit 1)  from campaign  where recordtype.name like 'FDB %' and id in (select campaignid from campaignmember where createddate > n_days_ago:5)");
	}

}