package com.projects.pokemon.util;

public class Validators {

    public static boolean isValidNumber( String number) {
        Integer integerValue;

        try {
            integerValue = Integer.valueOf(number);

            if (integerValue < 0 )
                return false;


        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
