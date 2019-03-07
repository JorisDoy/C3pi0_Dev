/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telkom.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gaddafi
 */
public class ValidateInput {
    
    public boolean isValidInput(String text, String matchString) {
        String expression = matchString;
        CharSequence inputStr = text;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
}
