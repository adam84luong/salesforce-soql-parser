package org.mule.soql.exception;

public class SOQLParsingException extends RuntimeException {

	private static final long serialVersionUID = 3262890028578512425L;

	public SOQLParsingException(Throwable t) {
		super(t);
	}

    public SOQLParsingException(String s) {
        super(s);
    }

    public SOQLParsingException(String s, Throwable t) {
        super(s, t);
    }

    public SOQLParsingException() {
    }
    
}
