package org.mule.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("SELECT Id, Nom_Ticket_de_caisse__c, OwnerId, Moyen_de_paiement__c, Moyen_Paiement_Acompte__c, Moyen_Paiement_Solde__c, Date_de_paiement__c, Date_acompte__c, Date_solde__c, Amount, Montant_acompte__c, Montant_solde__c, Aloa_Groupe_individuel__c FROM Opportunity WHERE (StageName = 'Fermée / Gagnée' AND Date_acompte__c != null) OR (StageName = 'Fermée / Gagnée' AND Date_solde__c != null) OR NOT (StageName = 'Fermée / Gagnée' AND Date_de_paiement__c != null)");
	}

}
