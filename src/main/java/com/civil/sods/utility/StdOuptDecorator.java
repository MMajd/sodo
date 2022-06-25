/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.utility;

/**
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class StdOuptDecorator {

    /**
     * Method that Gets Symbol
     *
     * @param symbole Symbol instance to be get
     * @param strLength Stirrup Length to be get
     *
     * @return Decoration
     */
    public static String getSymbole(String symbole, int strLength) {
        String decoration = "";

        for (int i = 0; i < strLength; i++) {
            decoration += symbole;
        }
        return decoration;
    }

    /**
     * Method that Gets Stars
     *
     * @param numberOfStars Number Of Stars
     *
     * @return '*' Symbol According to Number Of Stars
     */
    public static String getStars(int numberOfStars) {
        return getSymbole("*", numberOfStars);
    }

    /**
     * Method that Gets Dashes
     *
     * @param numberOfDashes Number Of Dashes
     *
     * @return '-' Symbol According to number Of Dashes
     */
    public static String getDashes(int numberOfDashes) {
        return getSymbole("-", numberOfDashes);
    }

    /**
     * Method that Gets Hashes
     *
     * @param numberOfHashes Number Of Hashes
     *
     * @return '#' Symbol According to number of Hashes
     */
    public static String getHashes(int numberOfHashes) {
        return getSymbole("#", numberOfHashes);
    }

    /**
     * Method that Gets Equal Signs
     *
     * @param numberOfEqualSigns Number Of Equal Signs
     *
     * @return '=' Symbol According to number of Equal Signs
     */
    public static String getEqualSigns(int numberOfEqualSigns) {
        return getSymbole("=", numberOfEqualSigns);
    }

    /**
     * Method that Gets Underscores
     *
     * @param numberOfUsores Number Of Underscores
     *
     * @return '_' Symbol According to number of Underscores
     */
    public static String getUnderscores(int numberOfUsores) {
        return getSymbole("_", numberOfUsores);
    }
    
    /**
     * Constructor Fir Standard Output Decorator
     *
     */
    private StdOuptDecorator() {
    }
    
}
