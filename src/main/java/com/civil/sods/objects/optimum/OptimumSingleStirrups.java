package com.civil.sods.objects.optimum;

/**
 * Class to Obtain Single Stirrups extends Optimum Stirrups Class
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class OptimumSingleStirrups extends OptimumStirrups {

    private double dimensionNormalToDirection;

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
     F*/
    public void setDimensionNormalToDirection(double dimensionNormalToDirection) {
        this.dimensionNormalToDirection = dimensionNormalToDirection;
    }

}
