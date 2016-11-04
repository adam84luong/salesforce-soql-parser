/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.soql.parser;

public class SOQLParserSingleTest extends SOQLParserTest {

	public SOQLParserSingleTest() {
		super("select id, body from attachment where parentid in (select id from contact where exportcheckbox__c = true and exportinitializer__c = '005900000033r8caaq') and description like 'cp%' order by id");
	}

}