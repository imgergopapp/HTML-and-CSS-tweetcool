package com.codecool.web.service;

public class FormValidator {

    public static void formCheck(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            throw new InvalidFormException("Invalid Form. Fill both name & tweet fields.");
        }
    }
}
