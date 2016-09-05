/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.soql.exception;

public class LexerException extends RuntimeException {

	private static final long serialVersionUID = 3262890028578512425L;

	public LexerException(Throwable t) {
		super(t);
	}

    public LexerException(String s) {
        super(s);
    }

    public LexerException(String s, Throwable t) {
        super(s, t);
    }

    public LexerException() {
    }
    
}
