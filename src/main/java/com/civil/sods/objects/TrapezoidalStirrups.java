package com.civil.sods.objects;

/**
 * Class that is responsible of Trapezoidal Stirrup extends Stirrups Class
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class TrapezoidalStirrups extends Stirrups {

    /**
     * s2
     */
    private double nominalDimensionAlongDirection;
    /**
     * s4
     */
    private double shortDimensionNormalToDirection;
    /**
     * s1
     */
    private double longDimensionNormalToDirection;
    /**
     * s3
     */
    private double inclinedDimension;

    /**
     * Method that Gets Normal Dimension Along Direction
     *
     * @return Normal Dimension Along Direction
     */
    public double getNominalDimensionAlongDirection() {
        return nominalDimensionAlongDirection;
    }

    /**
     * Method that Sets Normal Dimension Along Direction
     *
     * @param nominalDimensionAlongDirection Normal Dimension Along Direction to be set
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
     * Method that sets Short Dimension Normal To Direction
     *
     * @param shortDimensionNormalToDirection Short Dimension Normal To Direction to be set
     *
     */
    public void setShortDimensionNormalToDirection(double shortDimensionNormalToDirection) {
        this.shortDimensionNormalToDirection = shortDimensionNormalToDirection;
    }

    /**
     * Method that gets Long Dimension Normal To Direction
     *
     * @return Long Dimension Normal To Direction
     */
    public double getLongDimensionNormalToDirection() {
        return longDimensionNormalToDirection;
    }

    /**
     * Method that Sets Long Dimension Normal To Direction
     *
     * @param longDimensionNormalToDirection long Dimension Normal To Direction to be set
     *
     */
    public void setLongDimensionNormalToDirection(double longDimensionNormalToDirection) {
        this.longDimensionNormalToDirection = longDimensionNormalToDirection;
    }

    /**
     * Method that Gets Inclined Dimension
     *
     * @return double Inclined Dimension
     */
    public double getInclinedDimension() {
        return inclinedDimension;
    }

    /**
     * Method that sets Inclined Dimension
     *
     * @param inclinedDimension Inclined Dimension to be set
     *
     */
    public void setInclinedDimension(double inclinedDimension) {
        this.inclinedDimension = inclinedDimension;
    }

    /**
     * Method that calculates the perimeter of the stirrup and saves it in the {@link }
     *
     */
    @Override
    public void calcLength() {
        this.setLength(this.getNumOfStirrups() * (inclinedDimension * 2 + longDimensionNormalToDirection + shortDimensionNormalToDirection));
    }
}
