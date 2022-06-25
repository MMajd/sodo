package com.civil.sods.objects;

/**
 * Class abstract that is responsible of Stirrups
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */
public abstract class Stirrups {

    private int numOfStirrups;
    private double length;
    private double[] offset;

    /**
     * Method that Calculate the Length
     *
     */
    public abstract void calcLength();

    /**
     * Method that Gets Number of Stirrups
     *
     * @return Number of Stirrups
     */
    public int getNumOfStirrups() {
        return numOfStirrups;
    }

    /**
     * Method that Sets Number of Stirrups
     *
     * @param numOfStirrups Number Of Stirrups to be set
     *
     */
    public void setNumOfStirrups(int numOfStirrups) {
        this.numOfStirrups = numOfStirrups;
    }

    /**
     * Method that Gets Length
     *
     * @return Length
     */
    public double getLength() {
        return length;
    }

    /**
     * Method that sets Length
     *
     * @param length Length to be set
     *
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Method that Gets Offset
     *
     * @return Offset
     */
    public double[] getOffset() {
        return offset;
    }

    /**
     * Method that Sets Offset
     *
     * @param offset Offset to be set
     *
     */
    public void setOffset(double[] offset) {
        this.offset = offset;
    }
}
