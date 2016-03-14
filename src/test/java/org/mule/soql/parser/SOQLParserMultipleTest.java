package org.mule.soql.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SOQLParserMultipleTest extends SOQLParserTest {

    public SOQLParserMultipleTest(String line) {
        super(line);
    }

    private static final String FILENAME = "src/test/resources/SOQLSmall.csv";

    @Parameterized.Parameters
    public static Iterable<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                //GROUP BY Aggregate functions Example
                { "SELECT Store_Num_Link__r.Rep__c, SUM(December_Rep__c,FunctionParameter,FunctionParameter) Dec FROM Parent.Store_Revenue__c store WHERE Year_Text__c = '2013' AND (Store_Num_Link__r.Office__c NOT IN ('S41','S43') AND Store_Num_Link__r.Assign_Date__c <   = 2013-09-01 AND Store_Num_Link__r.Assign_Date__c <= 2013-12-31) AND SomeField like 'Arebga%' GROUP BY Store_Num_Link__r.Rep__c,SomeField ORDER BY Store_Num_Link__r.Rep__c ASC NULLS FIRST, COUNT(SomeField) DESC" },

                //WITH DATA CATEGORY Example
                { "SELECT Title, Summary FROM KnowledgeArticleVersion WHERE PublishStatus='Online' AND Language = 'en_US' WITH DATA CATEGORY Geography__c ABOVE_OR_BELOW (europe__c,america_c) AND Product__c BELOW All__c" },

                //WITH Example
                { "SELECT Id FROM UserProfileFeed WITH UserId='005D0000001AamR' ORDER BY CreatedDate DESC, Id DESC LIMIT 20" },

                //USING SCOPE example
                { "select Id from Contact a, Contact.Account b, Contact.Parent c using scope my_territory where FirstName like 'A%' limit 10" },

                //UPDATE example
                { "select Id from Contact a, Contact.Account b, Contact.Parent c where FirstName like 'A%' limit 10 update TRACKING,VIEWSTAT" },

                //FOR example
                { "select Id from Contact a, Contact.Account b, Contact.Parent c using scope my_territory where FirstName like 'A%' limit 10 for REFERENCE,VIEW,UPDATE" },

                //GROUP BY ROLLUP
                { "SELECT LeadSource, Rating, GROUPING(LeadSource), GROUPING(Rating) grpRating, COUNT(Name) cnt FROM Lead GROUP BY ROLLUP(LeadSource, Rating)" },

                //SUBQUERY Example
                { "select id, (select id, createddate from campaignmembers order by createddate limit 1)  from campaign bla where recordtype.name like 'FDB %' and id in (select campaignid from campaignmember where createddate > n_days_ago:5)" },

                //TYPEOF Example
                { "SELECT TYPEOF What WHEN Account THEN Phone, NumberOfEmployees WHEN Opportunity THEN Amount, CloseDate ELSE Name, Email END FROM Event" },

                //New line Example
                { "SELECT Id,Body\nFROM Attachment\nWHERE parentid in (Select Id FROM Contact where ExportCheckbox__c=True\nand ExportInitializer__c='005900000033r8CAAQ')\nand description like 'CP%'\nORDER BY Id" }
        });
    }

}
