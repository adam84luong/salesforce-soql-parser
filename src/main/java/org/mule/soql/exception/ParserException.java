package org.mule.soql.exception;

public class ParserException extends RuntimeException {

	private static final long serialVersionUID = 3262890028578512425L;

	public ParserException(Throwable t) {
		super(t);
	}

    public ParserException(String s) {
        super(s);
    }

    public ParserException(String s, Throwable t) {
        super(s, t);
    }

    public ParserException() {
    }
    
}
