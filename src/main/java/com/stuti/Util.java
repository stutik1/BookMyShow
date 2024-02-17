package com.stuti;

public class Util {

    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

//        int atIndex = email.indexOf('@');
//        int dotIndex = email.lastIndexOf('.');
//
//        // Check if '@' and '.' are present and in correct positions
//        if (atIndex <= 0 || dotIndex <= atIndex || dotIndex == email.length() - 1) {
//            return false;
//        }
//        return true;

        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }
        return true;

    }
}
