package com.atakanguney.education.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$");
        return pattern.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        String lengthPattern = "^.{8,20}$";
        String numberPattern = "\\d+";
        String lowercasePattern = "[a-z]+";
        String uppercasePattern = "[A-Z]+";
        String specialCharPattern = "[@.*#$%^&+=]+";
        String spacePattern = "^\\S*$";

        String[] patterns = {lengthPattern, numberPattern, lowercasePattern,
                uppercasePattern, specialCharPattern, spacePattern};

        for (String pattern : patterns) {
            Pattern regex = Pattern.compile(pattern);
            if (!regex.matcher(password).find()) {
                return false;
            }
        }

        return true;
    }

}
