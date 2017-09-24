package com.jdkd.academy.utils.validators;

import java.util.regex.Pattern;

public class StringValidator {

    private static final Pattern TEXT_ONLY = Pattern.compile("^[A-Za-z]+");

    public static boolean validateStringContainsOnlyText(String toValidate){
        return TEXT_ONLY.matcher(toValidate).matches();
    }

}
