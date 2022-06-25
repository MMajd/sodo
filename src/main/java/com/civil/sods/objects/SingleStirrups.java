package com.civil.sods.objects;

/**
 * Class that is responsible of Rectangular Stirrup extends Stirrups Class
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class SingleStirrups extends Stirrups {

    private double dimensionNormalToDirection;

    /**
     * Method that Gets Dimension Normal to Direction
     *
     * @return Dimension Normal to Direction
     */
    public double getDimensionNormalToDirection() {
        return dimensionNormalToDirection;
    }

    /**
     * Method that Sets Dimension Normal to Direction
     *
     * @param dimensionNormalToDirection Dimension Normal to Direction to be set
     *
     */
    public void setDimensionNormalToDirection(double dimensionNormalToDirection) {
        this.dimensionNormalToDirection = dimensionNormalToDirection;
    }

    /**
     * Method that Calculate Total Length of the Dimension Normal to Direction
     *
     */
    public void calcLength() {
        this.setLength(this.getNumOfStirrups() * dimensionNormalToDirection * 2);
    }
}
