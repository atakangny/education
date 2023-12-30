package com.atakanguney.education.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void verifyEmail() {
        String validEmail1 = "test@test.com";
        String validEmail2 = "test.test@test.com";
        String validEmail3 = "test_1@test.com";

        String invalidEmail1 = "";
        String invalidEmail2 = "test@test._";
        String invalidEmail3 = "test@*test.com";
        String invalidEmail4 = "test.test.com";

        assertTrue(ValidationUtil.isValidEmail(validEmail1));
        assertTrue(ValidationUtil.isValidEmail(validEmail2));
        assertTrue(ValidationUtil.isValidEmail(validEmail3));

        assertFalse(ValidationUtil.isValidEmail(invalidEmail1));
        assertFalse(ValidationUtil.isValidEmail(invalidEmail2));
        assertFalse(ValidationUtil.isValidEmail(invalidEmail3));
        assertFalse(ValidationUtil.isValidEmail(invalidEmail4));
    }

    @Test
    void verifyPasswordStrength(){
        String validPassword1 = "Tst.Tst1";
        String validPassword2 = "Test*Test_1";
        String validPassword3 = "Test.Test.Test.Test1";

        String invalidPassword1 = ""; // Empty
        String invalidPassword2 = "Test Test 1.*"; // Has spaces
        String invalidPassword3 = "Test*TestTest"; // Missing digit
        String invalidPassword4 = "T1**********"; // Missing Lowercase
        String invalidPassword5 = "t1**********"; // Missing Uppercase
        String invalidPassword6 = "Test*Test_12345678901"; // 21 character
        String invalidPassword7 = "Test*_1"; // 7 chars

        assertTrue(ValidationUtil.isValidPassword(validPassword1));
        assertTrue(ValidationUtil.isValidPassword(validPassword2));
        assertTrue(ValidationUtil.isValidPassword(validPassword3));

        assertFalse(ValidationUtil.isValidPassword(invalidPassword1));
        assertFalse(ValidationUtil.isValidPassword(invalidPassword2));
        assertFalse(ValidationUtil.isValidPassword(invalidPassword3));
        assertFalse(ValidationUtil.isValidPassword(invalidPassword4));
        assertFalse(ValidationUtil.isValidPassword(invalidPassword5));
        assertFalse(ValidationUtil.isValidPassword(invalidPassword6));
        assertFalse(ValidationUtil.isValidPassword(invalidPassword7));

    }
}