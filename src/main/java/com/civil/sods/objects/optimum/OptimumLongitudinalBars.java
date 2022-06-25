package com.civil.sods.objects.optimum;

/**
 * Class that Obtain Optimum Longitudinal Bars
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class OptimumLongitudinalBars {

    private int numberOfLongitudinalBars;
    private double diameter;
    private double numberOfLongitudinalBarsAlongWidth;
    private double numberOfLongitudinalBarsAlongLength;
    private double longitudinalBarsSpacingAlongWidth;
    private double longitudinalBarsSpacingAlongLength;
    private double cost;

    /**
     * Constructor For Optimum Longitudinal Bars Class with parameters
     *
     * @param numberOfLongitudinalBars Number Of Longitudinal Bars to be set
     * @param diameter Diameter to be set
     * @param numberOfLongitudinalBarsAlongWidth Number Of Longitudinal Bars Along Width to be set
     * @param numberOfLongitudinalBarsAlongLength Number Of Longitudinal Bars Along Length to be set
     * @param longitudinalBarsSpacingAlongWidth Longitudinal Bars Spacing Along Width to be set
     * @param longitudinalBarsSpacingAlongLength Longitudinal Bars Spacing Along Length to be set
     *
     */
    public OptimumLongitudinalBars(int numberOfLongitudinalBars, int diameter,
            double numberOfLongitudinalBarsAlongWidth, double numberOfLongitudinalBarsAlongLength,
            double longitudinalBarsSpacingAlongWidth, double longitudinalBarsSpacingAlongLength) {
        this.numberOfLongitudinalBars = numberOfLongitudinalBars;
        this.diameter = diameter;
        this.numberOfLongitudinalBarsAlongWidth = numberOfLongitudinalBarsAlongWidth;
        this.numberOfLongitudinalBarsAlongLength = numberOfLongitudinalBarsAlongLength;
        this.longitudinalBarsSpacingAlongWidth = longitudinalBarsSpacingAlongWidth;
        this.longitudinalBarsSpacingAlongLength = longitudinalBarsSpacingAlongLength;
    }

    /**
     * Constructor For Optimum Longitudinal Bars Class
     *
     */
    public OptimumLongitudinalBars() {
    }

    /**
     * Method that Gets Number Of Longitudinal Bars
     *
     * @return Number Of Longitudinal Bars
     */
    public int getNumberOfLongitudinalBars() {
        return numberOfLongitudinalBars;
    }

    /**
     * Method that Sets Number Of Longitudinal Bars
     *
     * @param numberOfLongitudinalBars Number Of Longitudinal Bars to be set
     *
     */
    public void setNumberOfLongitudinalBars(int numberOfLongitudinalBars) {
        this.numberOfLongitudinalBars = numberOfLongitudinalBars;
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
     * Method that Sets Diameter
     *
     * @param diameter Diameter to be set
     *
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * Method that Gets Number Of Longitudinal Bars Along Width
     *
     * @return Number Of Longitudinal Bars Along Width
     */
    public double getNumberOfLongitudinalBarsAlongWidth() {
        return numberOfLongitudinalBarsAlongWidth;
    }

    /**
     * Method that Sets Number Of Longitudinal Bars Along Width
     *
     * @param numberOfLongitudinalBarsAlongWidth Number Of Longitudinal Bars Along Width to be set
     *
     */
    public void setNumberOfLongitudinalBarsAlongWidth(double numberOfLongitudinalBarsAlongWidth) {
        this.numberOfLongitudinalBarsAlongWidth = numberOfLongitudinalBarsAlongWidth;
    }

    /**
     * Method that Gets Number Of Longitudinal Bars Along Length
     *
     * @return Number Of Longitudinal Bars Along Length
     */
    public double getNumberOfLongitudinalBarsAlongLength() {
        return numberOfLongitudinalBarsAlongLength;
    }

    /**
     * Method that Sets Number Of Longitudinal Bars Along Length
     *
     * @param numberOfLongitudinalBarsAlongLength Number Of Longitudinal Bars Along Length to be set
     *
     */
    public void setNumberOfLongitudinalBarsAlongLength(double numberOfLongitudinalBarsAlongLength) {
        this.numberOfLongitudinalBarsAlongLength = numberOfLongitudinalBarsAlongLength;
    }

    /**
     * Method that Gets Longitudinal Bars Spacing Along Width
     *
     * @return Longitudinal Bars Spacing Along Width
     */
    public double getLongitudinalBarsSpacingAlongWidth() {
        return longitudinalBarsSpacingAlongWidth;
    }

    /**
     * Method that Sets Longitudinal Bars Spacing Along Width
     *
     * @param longitudinalBarsSpacingAlongWidth Longitudinal Bars Spacing Along Width to be set
     *
     */
    public void setLongitudinalBarsSpacingAlongWidth(double longitudinalBarsSpacingAlongWidth) {
        this.longitudinalBarsSpacingAlongWidth = longitudinalBarsSpacingAlongWidth;
    }

    /**
     * Method Gets Longitudinal Bars Spacing Along Length
     *
     * @return Longitudinal Bars Spacing Along Length
     */
    public double getLongitudinalBarsSpacingAlongLength() {
        return longitudinalBarsSpacingAlongLength;
    }

    /**
     * Method that Sets Longitudinal Bars Spacing Along Length
     *
     * @param longitudinalBarsSpacingAlongLength Longitudinal Bars Spacing Along Length
     *
     */
    public void setLongitudinalBarsSpacingAlongLength(double longitudinalBarsSpacingAlongLength) {
        this.longitudinalBarsSpacingAlongLength = longitudinalBarsSpacingAlongLength;
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
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

}
