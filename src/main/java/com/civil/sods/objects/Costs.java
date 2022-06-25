package com.civil.sods.objects;

/**
 * Class that is responsible of Costs
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class Costs {

    double concreteCostPerTon;
    double oneSpliceCost;
    double stirrupCostPerTon;
    double longitudinalBarCostPerTon;

    /**
     * Constructor for Costs with parameters
     *
     * @param concreteCostPerTon Concrete Cost Per Ton to be set
     * @param oneSpliceCost One Splice Cost to be set
     * @param stirrupCostPerTon Stirrup Cost Per Ton to be set
     * @param longitudinalBarCostPerTon Longitudinal Bars Cost Per Ton to be set
     *
     */
    public Costs(double concreteCostPerTon, double oneSpliceCost, double stirrupCostPerTon,
            double longitudinalBarCostPerTon) {
        this.concreteCostPerTon = concreteCostPerTon;
        this.oneSpliceCost = oneSpliceCost;
        this.stirrupCostPerTon = stirrupCostPerTon;
        this.longitudinalBarCostPerTon = longitudinalBarCostPerTon;
    }

    /**
     * Method that Gets Concrete Cost Per Ton
     *
     * @return Concrete Cost Per Ton
     */
    public double getConcreteCostPerTon() {
        return concreteCostPerTon;
    }

    /**
     * Method that Sets Concrete Cost Per Ton
     *
     * @param concreteCostPerTon Concrete Cost Per Ton to be set
     *
     */
    public void setConcreteCostPerTon(double concreteCostPerTon) {
        this.concreteCostPerTon = concreteCostPerTon;
    }

    /**
     * Method that Gets One Splice Cost
     *
     * @return One Splice Cost
     */
    public double getOneSpliceCost() {
        return oneSpliceCost;
    }

    /**
     * Method that Sets One Splice Cost
     *
     * @param oneSpliceCost One Splice Cost to be set
     *
     */
    public void setOneSpliceCost(double oneSpliceCost) {
        this.oneSpliceCost = oneSpliceCost;
    }

    /**
     * Method that Gets Stirrup Cost Per Ton
     *
     * @return Stirrup Cost Per Ton
     */
    public double getStirrupCostPerTon() {
        return stirrupCostPerTon;
    }

    /**
     * Method that Sets Stirrup Cost Per Ton
     *
     * @param stirrupCostPerTon Stirrup Cost Per Ton to be set
     *
     */
    public void setStirrupCostPerTon(double stirrupCostPerTon) {
        this.stirrupCostPerTon = stirrupCostPerTon;
    }

    /**
     * Method that Gets Longitudinal Bar Cost Per Ton
     *
     * @return Longitudinal Bar Cost Per Ton
     */
    public double getLongitudinalBarCostPerTon() {
        return longitudinalBarCostPerTon;
    }

    /**
     * Method that Sets Longitudinal Bar Cost Per Ton
     *
     * @param longitudinalBarCostPerTon Longitudinal Bar Cost Per Ton to be set
     */
    public void setLongitudinalBarCostPerTon(double longitudinalBarCostPerTon) {
        this.longitudinalBarCostPerTon = longitudinalBarCostPerTon;
    }

}
