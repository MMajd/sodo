package com.civil.sods.objects.optimum;

/**
 * Class to Obtain Optimum Rectangular Stirrups
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class OptimumRectangularStirrups extends OptimumStirrups {

    private double dimensionNormalToDirection;
    private double dimensionAlongDirection;

    /**
     * Method that Gets Dimension Normal To Direction
     *
     * @return Dimension Normal To Direction
     */
    public double getDimensionNormalToDirection() {
        return dimensionNormalToDirection;
    }

    /**
     * Method that sets Dimension Normal To Direction
     *
     * @param dimensionNormalToDirection Dimension Normal To Direction to be set
     *
     */
    public void setDimensionNormalToDirection(double dimensionNormalToDirection) {
        this.dimensionNormalToDirection = dimensionNormalToDirection;
    }

    /**
     * Method that Gets Dimension Along Direction
     *
     * @return Dimension Along Direction
     */
    public double getDimensionAlongDirection() {
        return dimensionAlongDirection;
    }

    /**
     * Method that Sets Dimension Along Direction
     *
     * @param dimensionAlongDirection Dimension Along Direction to be set
     */
    public void setDimensionAlongDirection(double dimensionAlongDirection) {
        this.dimensionAlongDirection = dimensionAlongDirection;
    }
}
