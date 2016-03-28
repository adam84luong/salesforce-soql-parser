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
