package com.civil.sods.objects.optimum;

/**
 * Class that Obtain the Optimum Column
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class OptimumColumn {

    private double width;
    private double length;
    private double compressiveCapacity;
    private double cost;
    private double reinforcementRatio;
    private double spacingBetweenStirrups;
    private int numOfStirrups;

    /**
     * Method that Gets Width
     *
     * @return Width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Method that sets Width
     *
     * @param width Width to be set
     *
     */
    public void setWidth(double width) {
        this.width = width;
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
     * Method that sets length
     *
     * @param length Length to be set
     *
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Method that Gets Compressive Capacity
     *
     * @return Compressive Capacity
     */
    public double getCompressiveCapacity() {
        return compressiveCapacity;
    }

    /**
     * Method that Sets Compressive Capacity
     *
     * @param compressiveCapacity Compressive Capacity
     *
     */
    public void setCompressiveCapacity(double compressiveCapacity) {
        this.compressiveCapacity = compressiveCapacity;
    }

    /**
     * Method that Gets Cost
     *
     * @return Cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Method that Sets Cost
     *
     * @param cost Cost to be set
     *
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Method that Gets Reinforcement Ratio
     *
     * @return Reinforcement Ratio
     */
    public double getReinforcementRatio() {
        return reinforcementRatio;
    }

    /**
     * Method that sets Reinforcement Ratio
     *
     * @param reinforcementRatio Reinforcement Ratio to be set
     */
    public void setReinforcementRatio(double reinforcementRatio) {
        this.reinforcementRatio = reinforcementRatio;
    }

    /**
     * Method that Gets Spacing Between Stirrups
     *
     * @return Spacing Between Stirrups
     */
    public double getSpacingBetweenStirrups() {
        return spacingBetweenStirrups;
    }

    /**
     * Method that Sets Spacing Between Stirrups
     *
     * @param spacingBetweenStirrups Spacing Between Stirrups to be set
     *
     */
    public void setSpacingBetweenStirrups(double spacingBetweenStirrups) {
        this.spacingBetweenStirrups = spacingBetweenStirrups;
    }

    /**
     * Method that Gets Number Of Stirrups
     *
     * @return Number Of Stirrups
     */
    public int getNumOfStirrups() {
        return numOfStirrups;
    }

    /**
     * Method that sets Number Of Stirrups
     *
     * @param numOfStirrups Number Of Stirrups to be set
     */
    public void setNumOfStirrups(int numOfStirrups) {
        this.numOfStirrups = numOfStirrups;
    }

}
