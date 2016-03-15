package org.mule.soql.query;

import org.mule.soql.SOQLDataVisitor;

/**
 * Created by damianpelaez on 3/7/16.
 */
public interface SOQLData {

    String toSOQLText();

    <T> T accept(SOQLDataVisitor<? extends T> soqlDataVisitor);

}
