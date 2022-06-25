package com.civil.sods.objects.optimum;

/**
 * Class to Obtain Optimum Stirrups
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public abstract class OptimumStirrups {

    private int numberOfStirrups;
    private double cost;
    private double length;
    private double diameter;
    private double[] offset;

    /**
     * Method that Gets Length
     *
     * @return Length
     */
    public double getLength() {
        return length;
    }

    /**
     * Method that Sets Length
     *
     * @param length Length to be set
     *
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Method that Gets Diameter
     *
     * @return Diameter
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * Method that sets Diameter
     *
     * @param diameter Diameter to be set
     *
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * Method that Gets Number Of Stirrups
     *
     * @return Number Of Stirrups
     */
    public int getNumberOfStirrups() {
        return numberOfStirrups;
    }

    /**
     * Method that Sets Number Of Stirrups
     *
     * @param numberOfStirrups Number Of Stirrups to be set
     *
     */
    public void setNumberOfStirrups(int numberOfStirrups) {
        this.numberOfStirrups = numberOfStirrups;
    }

    /**
     * Method that Get Cost
     *
     * @return Cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Method that sets Cost
     *
     * @param cost Cost to be set
     *
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Method that Get Offset
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
