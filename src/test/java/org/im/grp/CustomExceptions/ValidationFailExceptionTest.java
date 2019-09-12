package org.im.grp.CustomExceptions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidationFailExceptionTest {

    @Test(expected = ValidationFailException.class)
    public void testForTheValidationFailExceptionThrown() {
        throw new ValidationFailException("verify for the exception is thrown");
    }

    @Test
    public void testForAssertionOfMessageThrownInException() {
        Throwable s = new ValidationFailException("my custom message exception");
        assertEquals(s.getMessage(), "my custom message exception");
    }

}