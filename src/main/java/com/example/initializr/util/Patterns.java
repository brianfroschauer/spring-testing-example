package com.example.initializr.unit.util;

public class Patterns {

    /**
     * ^                 # start-of-string.
     * (?=.{8,50}$)      # anything, at least eight places and maximum fifty.
     * (?![_.])          # no _ or . at the beginning.
     * (?!.*[_.]{2})     # no __ or _. or ._ or .. inside.
     * (?<![_.])         # no _ or . at the end.
     * ([a-zA-Z0-9._]+)  # allowed characters.
     * $                 # end-of-string.
     */
    public final static String PATTERN_USERNAME = "^(?=.{8,50}$)(?![_.])(?!.*[_.]{2})(?<![_.])([a-zA-Z0-9._]+)$";

    /**
     * ^                 # start-of-string.
     * (?=.*[0-9])       # a digit must occur at least once.
     * (?=.*[a-z])       # a lower case letter must occur at least once.
     * (?=.*[A-Z])       # an upper case letter must occur at least once.
     * (?=.*[@#$%^&+=])  # a special character must occur at least once.
     * (?=\S+$)          # no whitespace allowed in the entire string.
     * .{8,50}           # anything, at least eight places and maximum fifty.
     * $                 # end-of-string.
     */
    public final static String PATTERN_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,50}$";
}
