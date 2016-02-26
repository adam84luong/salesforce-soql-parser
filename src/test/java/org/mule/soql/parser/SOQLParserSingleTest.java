package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT createdDate, id, Owner.Name, TYPEOF What WHEN Contact THEN CellPhone,Phone WHEN Account THEN Phone,Name ELSE Name END,name,StageName,IsClosed,(select OpportunityAccessLevel, User.Name,Team_Member_Business_Line__c,Team_Member_Business_Unit__c,Team_Member_Sales_Team__c, TeamMemberRole,Team_Member_Region__c, Team_Member_GBL__c from OpportunityTeamMembers  where OpportunityAccessLevel ='Read') FROM Opportunity where IsClosed = false and CreatedDate > 2015-12-16T21:41:32.000Z order by CreatedDate limit 10000");
	}

}
