/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.objects;

import com.civil.sods.objects.optimum.OptimumColumn;
import com.civil.sods.objects.optimum.OptimumLongitudinalBars;
import com.civil.sods.objects.optimum.OptimumRectangularStirrups;
import com.civil.sods.objects.optimum.OptimumSingleStirrups;
import com.civil.sods.objects.optimum.OptimumTrapezoidalStirrups;

/**
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */
public class Column {

    private double minWidth;
    private double maxWidth;
    private double minLength;
    private double maxLength;
    private double compressiveLoad;
    private double concreteCover;
    private double maxAreaOfSteelRatio;

    private OptimumColumn optColumn;
    private OptimumRectangularStirrups optRectStirLen;
    private OptimumRectangularStirrups optRectStirWid;
    private OptimumRectangularStirrups optMainStirLen;
    private OptimumSingleStirrups optSnglStirLen;
    private OptimumSingleStirrups optSnglStirWid;
    private OptimumTrapezoidalStirrups optTrapStirLen;
    private OptimumLongitudinalBars optLongBars;

    /**
     * Constructor For Column Class
     *
     */
    public Column() {
    }

    /**
     * Constructor for Column Class with Parameters
     *
     * @param minWidth Minimum Width Of the Column instance
     * @param maxWidth Maximum Width Of the Column instance
     * @param minLength Minimum Length Of the Column instance
     * @param maxLength Maximum Length Of the Column instance
     * @param compressiveLoad Compressive Load for the Column instance
     * @param concreteCover Concrete Cover For the Column instance
     * @param maxAreaOfSteelRatio Maximum Area Of Steal Ratio for the Column instance
     *
     */
    public Column(double minWidth, double maxWidth, double minLength, double maxLength, double compressiveLoad,
            double concreteCover, double maxAreaOfSteelRatio) {
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.compressiveLoad = compressiveLoad;
        this.concreteCover = concreteCover;
        this.maxAreaOfSteelRatio = maxAreaOfSteelRatio;
    }

    /**
     * Method that Sets Optimum Rectangular Stirrup Along Length with Null
     *
     */
    public void setOptRectStirLenNull() {
        optRectStirLen = null;
    }

    /**
     * Method that Sets Optimum Rectangular Stirrup Along Width with Null
     *
     */
    public void setOptRectStirWidNull() {
        optRectStirWid = null;
    }

    /**
     * Method that Sets Optimum Single Stirrup Along Length with Null
     *
     */
    public void setOptSnglStirLenNull() {
        optSnglStirLen = null;
    }

    /**
     * Method that Sets Optimum Single Stirrup Along Width with Null
     *
     */
    public void setOptSnglStirWidNull() {
        optSnglStirWid = null;
    }

    /**
     * Method that Sets Optimum Trapezoidal Stirrup Along Length with Null
     *
     */
    public void setOptTrapStirLenNull() {
        optTrapStirLen = null;
    }

    /**
     * Method that Checks if the Optimum Rectangular Stirrup Along Length is Null
     *
     * @return True if the Optimum Rectangular Stirrup Along Length is Null
     */
    public boolean optRectStirLenIsNull() {
        return optRectStirLen == null;
    }

    /**
     * Method that Checks if the Optimum Rectangular Stirrup Along Width is Null
     *
     * @return True if the Optimum Rectangular Stirrup Along Width is Null
     */
    public boolean optRectStirWidIsNull() {
        return optRectStirWid == null;
    }

    /**
     * Method that Checks if the Optimum Single Stirrup Along Length is Null
     *
     * @return True if the Optimum Single Stirrup Along Length is Null
     */
    public boolean optSnglStirLenIsNull() {
        return optSnglStirLen == null;
    }

    /**
     * Method that Checks if the Optimum Single Stirrup Along Width is Null
     *
     * @return True if the Optimum Single Stirrup Along Width is Null
     */
    public boolean optSnglStirWidIsNull() {
        return optSnglStirWid == null;
    }

    /**
     * Method that Checks if the Optimum Trapezoidal Stirrup Along Length is Null
     *
     * @return True if the Optimum Trapezoidal Stirrup Along Length is Null
     */
    public boolean optTrapStirLenIsNull() {
        return optTrapStirLen == null;
    }

    /**
     * Method that Gets the Optimum Longitudinal Bars instances
     *
     * @return the Optimum Longitudinal Bars instances
     */
    public OptimumLongitudinalBars getOptLongBars() {
        if (optLongBars == null) {
            optLongBars = new OptimumLongitudinalBars();
        }
        return optLongBars;
    }

    /**
     * Method that Gets Optimum Column instance
     *
     * @return Optimum Column instance
     */
    public OptimumColumn getOptColumn() {
        if (optColumn == null) {
            optColumn = new OptimumColumn();
        }
        return optColumn;
    }

    /**
     * Method that Gets Optimum Rectangular Stirrups Along Length instance
     *
     * @return Optimum Rectangular Stirrups Along Length instance
     */
    public OptimumRectangularStirrups getOptRectStirLen() {
        if (optRectStirLen == null) {
            optRectStirLen = new OptimumRectangularStirrups();
        }
        return optRectStirLen;
    }

    /**
     * Method that Gets Optimum Main Stirrup Along Length instance
     *
     * @return Optimum Main Stirrup Along Length instance
     */
    public OptimumRectangularStirrups getOptMainStirLen() {
        if (optMainStirLen == null) {
            optMainStirLen = new OptimumRectangularStirrups();
        }
        return optMainStirLen;
    }

    /**
     * Method that Gets Optimum Rectangular Stirrup Along Width instance
     *
     * @return Optimum Rectangular Stirrup Along Width instance
     */
    public OptimumRectangularStirrups getOptRectStirWid() {
        if (optRectStirWid == null) {
            optRectStirWid = new OptimumRectangularStirrups();
        }
        return optRectStirWid;
    }

    /**
     * Method that Gets Optimum Single Stirrup Along Length instance
     *
     * @return Optimum Single Stirrup Along Length instance
     */
    public OptimumSingleStirrups getOptSnglStirLen() {
        if (optSnglStirLen == null) {
            optSnglStirLen = new OptimumSingleStirrups();
        }
        return optSnglStirLen;
    }

    /**
     * Method that Gets Optimum Single Stirrup Along Width instance
     *
     * @return Optimum Single Stirrup Along Width instance
     */
    public OptimumSingleStirrups getOptSnglStirWid() {
        if (optSnglStirWid == null) {
            optSnglStirWid = new OptimumSingleStirrups();
        }
        return optSnglStirWid;
    }

    /**
     * Method that Gets Optimum Trapezoidal Stirrup Along Width instance
     *
     * @return Optimum Trapezoidal Stirrup Along Width instance
     */
    public OptimumTrapezoidalStirrups getOptTrapStirLen() {
        if (optTrapStirLen == null) {
            optTrapStirLen = new OptimumTrapezoidalStirrups();
        }
        return optTrapStirLen;
    }

    /**
     * Method that Gets Minimum Width
     *
     * @return Minimum Width
     */
    public double getMinWidth() {
        return minWidth;
    }

    /**
     * Method that Sets Minimum Width
     *
     * @param minWidth Minimum Width to be set
     */
    public void setMinWidth(double minWidth) {
        this.minWidth = minWidth;
    }

    /**
     * Method that Gets Maximum Width
     *
     * @return Maximum Width
     */
    public double getMaxWidth() {
        return maxWidth;
    }

    /**
     * Method that Sets Maximum Width
     *
     * @param maxWidth Maximum Width to be set
     */
    public void setMaxWidth(double maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * Method that Gets Minimum Length
     *
     * @return Minimum Length
     */
    public double getMinLength() {
        return minLength;
    }

    /**
     * Method that Sets Minimum Length
     *
     * @param minLength Minimum Length to be set
     */
    public void setMinLength(double minLength) {
        this.minLength = minLength;
    }

    /**
     * Method that Gets Maximum Length
     *
     * @return Maximum Length
     */
    public double getMaxLength() {
        return maxLength;
    }

    /**
     * Method that Sets Maximum Length
     *
     * @param maxLength Maximum length to be set
     */
    public void setMaxLength(double maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * Method that Gets Compressive Load
     *
     * @return Compressive Load
     */
    public double getCompressiveLoad() {
        return compressiveLoad;
    }

    /**
     * Method that Sets Compressive Load
     *
     * @param compressiveLoad Compressive Load to be set
     */
    public void setCompressiveLoad(double compressiveLoad) {
        this.compressiveLoad = compressiveLoad;
    }

    /**
     * Method that Gets Concrete Cover
     *
     * @return Concrete Cover
     */
    public double getConcreteCover() {
        return concreteCover;
    }

    /**
     * Method that Sets Concrete Cover
     *
     * @param concreteCover Concrete Cover to be set
     */
    public void setConcreteCover(double concreteCover) {
        this.concreteCover = concreteCover;
    }

    /**
     * Method that Gets Maximum Area Of Steel Ratio
     *
     * @return Maximum Area Of Steel Ratio
     */
    public double getMaxAreaOfSteelRatio() {
        return maxAreaOfSteelRatio;
    }

    /**
     * Method that Gets Maximum Area Of Steel Ratio
     *
     * @param maxAreaOfSteelRatio Maximum Area Of Steel Ratio to be set
     */
    public void setMaxAreaOfSteelRatio(double maxAreaOfSteelRatio) {
        this.maxAreaOfSteelRatio = maxAreaOfSteelRatio;
    }

}
