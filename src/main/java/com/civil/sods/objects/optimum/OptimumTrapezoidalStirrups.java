package com.civil.sods.objects.optimum;

/**
 * Class to Obtain Optimum Trapezoidal Stirrups extends Optimum Stirrups Class
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class OptimumTrapezoidalStirrups extends OptimumStirrups {

    /**
     * It is the dimension parallel to direction
     */
    private double nominalDimensionAlongDirection;
    /**
     * It is the short dimension normal to direction
     */
    private double shortDimensionNormalToDirection;
    /**
     * It is the long dimension normal to direction
     */
    private double longDimensionNormalToDirection;
    /**
     * It is the inclined dimension between the short and long dimensions
     */
    private double inclinedDirection;

    /**
     * Method that Gets Nominal Dimension Along Direction
     *
     * @return Nominal Dimension Along Direction
     */
    public double getNominalDimensionAlongDirection() {
        return nominalDimensionAlongDirection;
    }

    /**
     * Method that sets Nominal Dimension Along Direction
     *
     * @param nominalDimensionAlongDirection Nominal Dimension Along Direction to be set
     *
     */
    public void setNominalDimensionAlongDirection(double nominalDimensionAlongDirection) {
        this.nominalDimensionAlongDirection = nominalDimensionAlongDirection;
    }

    /**
     * Method that Gets Short Dimension Normal To Direction
     *
     * @return Short Dimension Normal To Direction
     */
    public double getShortDimensionNormalToDirection() {
        return shortDimensionNormalToDirection;
    }

    /**
     * Method that Sets Dimension Normal To Direction
     *
     * @param shortDimensionNormalToDirection Dimension Normal To Direction to be set
     *
     */
    public void setShortDimensionNormalToDirection(double shortDimensionNormalToDirection) {
        this.shortDimensionNormalToDirection = shortDimensionNormalToDirection;
    }

    /**
     * Method that Gets Long Dimension Normal To Direction
     *
     * @return Long Dimension Normal To Direction
     */
    public double getLongDimensionNormalToDirection() {
        return longDimensionNormalToDirection;
    }

    /**
     * Method that Sets Long Dimension Normal To Direction
     *
     * @param longDimensionNormalToDirection Long Dimension Normal To Direction to be set
     *
     */
    public void setLongDimensionNormalToDirection(double longDimensionNormalToDirection) {
        this.longDimensionNormalToDirection = longDimensionNormalToDirection;
    }

    /**
     * Method that Gets Inclined Direction
     *
     * @return Inclined Direction
     */
    public double getInclinedDirection() {
        return inclinedDirection;
    }

    /**
     * Method that Sets Inclined Direction
     *
     * @param inclinedDirection Inclined Direction to be set
     *
     */
    public void setInclinedDirection(double inclinedDirection) {
        this.inclinedDirection = inclinedDirection;
    }

}
