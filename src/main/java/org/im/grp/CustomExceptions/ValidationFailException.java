package org.im.grp.CustomExceptions;

public class ValidationFailException extends RuntimeException {

    public ValidationFailException(String errorMessage) {
        super(errorMessage);
    }

}


