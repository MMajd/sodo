package com.civil.sods.objects;

/**
 * Class that is responsible of Rectangular Stirrup extends Stirrups Class
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */
public class RectangularStirrups extends Stirrups {

    private double dimensionNormalToDirection;
    private double dimensionAlongDirection;

    /**
     * Method that Gets Dimension Along Direction
     *
     * @return Dimension Along Direction
     */
    public double getDimensionAlongDirection() {
        return dimensionAlongDirection;
    }

    /**
     * Method that Gets Dimension Normal To Direction
     *
     * @return Dimension Normal To Direction
     */
    public double getDimensionNormalToDirection() {
        return dimensionNormalToDirection;
    }

    /**
     * Method that Sets Dimension Normal To Direction
     *
     * @param dimensionNormalToDirection Dimension Normal To Direction to be set
     *
     */
    public void setDimensionNormalToDirection(double dimensionNormalToDirection) {
        this.dimensionNormalToDirection = dimensionNormalToDirection;
    }

    /**
     * Method that Sets Dimension Along Direction
     *
     * @param dimensionAlongDirection Dimension Along Direction to be set
     */
    public void setDimensionAlongDirection(double dimensionAlongDirection) {
        this.dimensionAlongDirection = dimensionAlongDirection;
    }

    /**
     * Method to Calculate The Total Length
     *
     */
    public void calcLength() {
        this.setLength(this.getNumOfStirrups() * (dimensionNormalToDirection + dimensionAlongDirection) * 2);
    }
}
