package com.civil.sods.handle;

import com.civil.sods.objects.Building;
import com.civil.sods.objects.Column;
import com.civil.sods.objects.Costs;
import com.civil.sods.objects.Floor;
import com.civil.sods.objects.RectangularStirrups;
import com.civil.sods.objects.SingleStirrups;
import com.civil.sods.objects.TrapezoidalStirrups;
import com.civil.sods.objects.optimum.OptimumLongitudinalBars;
import com.civil.sods.objects.optimum.OptimumRectangularStirrups;
import com.civil.sods.objects.optimum.OptimumSingleStirrups;
import com.civil.sods.objects.optimum.OptimumTrapezoidalStirrups;
import com.civil.sods.optimize.Optimizer;
import com.civil.sods.optimize.Optimizer.Splice;
import com.civil.sods.utility.Utilities;
import java.util.ArrayList;

/**
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class Handler {

    /**
     * Gravitational acceleration measured in meter per second square
     */
    public static final double G = 9.80655;

    private Building building;

    /**
     * Constructor for Handler Class
     *
     */
    public Handler() {
    }

    /**
     * Method that returns the building instance
     *
     * @return Handler Building instance
     */
    public Building getBuilding() {
        if (this.building == null) {
            this.building = new Building();
        }
        return this.building;
    }

    /**
     * Method that sets the building instance
     *
     * @param building Building instance to be set
     */
    public void setBuilding(Building building) {
        this.building = building;
    }

    /**
     * Method that gets the Total Number Of Stirrups
     *
     * @param mainStirLen Main Stirrup along Length instance to be get
     * @param rectStirLen Rectangular Stirrup Length instance to be get
     * @param rectStirWid Rectangular Stirrup Width instance to be get
     * @param snglStirLen Single Stirrup Length instance to be get
     * @param snglStirWid Single Stirrup Width instance to be get
     * @param trapStirLen Trapezoidal Stirrup Length instance to be get
     *
     * @return the total Number Of Stirrups
     */
    private int getNumOfStirrups(RectangularStirrups mainStirLen, RectangularStirrups rectStirLen,
            RectangularStirrups rectStirWid, SingleStirrups snglStirLen,
            SingleStirrups snglStirWid, TrapezoidalStirrups trapStirLen) {
        return mainStirLen.getNumOfStirrups() + rectStirLen.getNumOfStirrups() + rectStirWid.getNumOfStirrups()
                + snglStirLen.getNumOfStirrups() + snglStirWid.getNumOfStirrups() + trapStirLen.getNumOfStirrups();
    }

    /**
     * Method that gets the total Perimeter Of Stirrup instances
     *
     * @param mainStirLen Main Stirrup Length instance
     * @param rectStirLen Rectangular Stirrup Length instance
     * @param rectStirWid Rectangular Stirrup Width instance
     * @param snglStirLen Single Stirrup Length instance
     * @param snglStirWid Single Stirrup Width instance
     * @param trapStirLen Trapezoidal Stirrup Length instance
     *
     * @return The total Perimeter of Stirrup instances
     */
    private double getPerimOfStirrups(RectangularStirrups mainStirLen, RectangularStirrups rectStirLen,
            RectangularStirrups rectStirWid, SingleStirrups snglStirLen, SingleStirrups snglStirWid,
            TrapezoidalStirrups trapStirLen) {
        return mainStirLen.getLength()
                + rectStirLen.getLength()
                + rectStirWid.getLength()
                + snglStirLen.getLength()
                + snglStirWid.getLength()
                + trapStirLen.getLength();
    }

    /**
     * Method that Assign the optimum Rectangular Stirrup instance from another rectangular stirrup instance
     *
     * @param optRectStir OPtimum Rectangular Stirrup instance to be assign from another rectangular stirrup instance
     * @param rectStir Rectangular Stirrup instance to be assign to the optimum rectangular stirrup instance
     *
     */
    private void assignRectStir(OptimumRectangularStirrups optRectStir, RectangularStirrups rectStir, double diameter) {
        optRectStir.setNumberOfStirrups(rectStir.getNumOfStirrups());
        optRectStir.setDimensionAlongDirection(rectStir.getDimensionAlongDirection());
        optRectStir.setDimensionNormalToDirection(rectStir.getDimensionNormalToDirection());
        optRectStir.setDiameter(diameter);
        optRectStir.setLength(rectStir.getLength());
        optRectStir.setOffset(rectStir.getOffset());
    }

    /**
     * Method that Assign Optimum Rectangular Stirrup instance from another rectangular stirrup instance
     *
     * @param optSnglStir OPtimum Single Stirrup instance to be assign from another single stirrup instance
     * @param snglStir Single Stirrup instance to be assign to the optimum single stirrup instance
     *
     */
    private void assignSnglStir(OptimumSingleStirrups optSnglStir, SingleStirrups snglStir, double diameter) {
        optSnglStir.setNumberOfStirrups(snglStir.getNumOfStirrups());
        optSnglStir.setDimensionNormalToDirection(snglStir.getDimensionNormalToDirection());
        optSnglStir.setDiameter(diameter);
        optSnglStir.setLength(snglStir.getLength());
        optSnglStir.setOffset(snglStir.getOffset());
    }

    /**
     * Method that Assign the Optimum Trapezoidal Stirrup instance
     *
     * @param optTrapStir OPtimum Trapezoidal Stirrup instance to be assign to another Trapezoidal Stirrup
     * @param trapStir Trapezoidal Stirrup instance to be assign to the optimum Trapezoidal stirrup instance
     *
     */
    private void assignTrapStir(OptimumTrapezoidalStirrups optTrapStir, TrapezoidalStirrups trapStir, double diameter) {
        optTrapStir.setNumberOfStirrups(trapStir.getNumOfStirrups());
        optTrapStir.setInclinedDirection(trapStir.getInclinedDimension());
        optTrapStir.setLongDimensionNormalToDirection(trapStir.getLongDimensionNormalToDirection());
        optTrapStir.setNominalDimensionAlongDirection(trapStir.getNominalDimensionAlongDirection());
        optTrapStir.setShortDimensionNormalToDirection(trapStir.getShortDimensionNormalToDirection());
        optTrapStir.setDiameter(diameter);
        optTrapStir.setLength(trapStir.getLength());
    }

    /**
     * Method that Assign the Optimum Longitudinal Bars instances Details
     *
     * @param column Column instance to be assign
     * @param diameter Diameter to be assign
     * @param longitudinalBarsSpacingAlongLength Longitudinal Bars Spacing Along Length to be assign
     * @param longitudinalBarsSpacingAlongWidth Longitudinal Bars Spacing Along Width to be assign
     * @param numberOfLongitudinalBars Number Of Longitudinal Bars to be assign
     * @param numberOfLongitudinalBarsAlongLength Number Of Longitudinal Bars Along Length to be assign
     * @param numberOfLongitudinalBarsAlongWidth Number Of Longitudinal Bars Along Width to be assign
     *
     */
    private void assignOptimumLongitudinalBarsDetails(Column column, double diameter,
            double longitudinalBarsSpacingAlongLength, double longitudinalBarsSpacingAlongWidth,
            int numberOfLongitudinalBars, int numberOfLongitudinalBarsAlongLength,
            int numberOfLongitudinalBarsAlongWidth) {
        OptimumLongitudinalBars optLongBars = column.getOptLongBars();
        optLongBars.setDiameter(diameter);
        optLongBars.setLongitudinalBarsSpacingAlongLength(longitudinalBarsSpacingAlongLength);
        optLongBars.setLongitudinalBarsSpacingAlongWidth(longitudinalBarsSpacingAlongWidth);
        optLongBars.setNumberOfLongitudinalBars(numberOfLongitudinalBars);
        optLongBars.setNumberOfLongitudinalBarsAlongLength(numberOfLongitudinalBarsAlongLength);
        optLongBars.setNumberOfLongitudinalBarsAlongWidth(numberOfLongitudinalBarsAlongWidth);
    }

    /**
     * Method that Assign Optimum Stirrups instances Details
     *
     * @param diameter Diameter to be assign to the Optimum Stirrup
     * @param column Column instance to be assign to the Optimum Stirrup
     * @param mainStirLen Main Stirrup Along Length instance to be assign to the Optimum Stirrup
     * @param rectStirLen Rectangular Stirrup Along Length instance to be assign to the Optimum Stirrup
     * @param rectStirWid Rectangular Stirrup Along Width instance to be assign to the Optimum Stirrup
     * @param snglStirLen Single Stirrup Along Length instance to be assign to the Optimum Stirrup
     * @param snglStirWid Single Stirrup ALong Width instance to be assign to the Optimum Stirrup
     * @param trapStirLen Trapezoidal Stirrup Along Length instance to be assign to the Optimum Stirrup
     *
     */
    private void assignOptimumStirrupsDetails(double diameter, Column column, RectangularStirrups mainStirLen,
            RectangularStirrups rectStirLen, RectangularStirrups rectStirWid,
            SingleStirrups snglStirLen, SingleStirrups snglStirWid,
            TrapezoidalStirrups trapStirLen) {
        assignRectStir(column.getOptMainStirLen(), mainStirLen, diameter);
        /**
         * If there is any number of this type of stirrups, then we should save its results. Otherwise, there is no need
         * of presence of such object
         */
        if (rectStirLen.getNumOfStirrups() > 0) {
            assignRectStir(column.getOptRectStirLen(), rectStirLen, diameter);
        } else {
            column.setOptRectStirLenNull();
        }
        if (rectStirWid.getNumOfStirrups() > 0) {
            assignRectStir(column.getOptRectStirWid(), rectStirWid, diameter);
        } else {
            column.setOptRectStirWidNull();
        }
        if (snglStirLen.getNumOfStirrups() > 0) {
            assignSnglStir(column.getOptSnglStirLen(), snglStirLen, diameter);
        } else {
            column.setOptSnglStirLenNull();
        }
        if (snglStirWid.getNumOfStirrups() > 0) {
            assignSnglStir(column.getOptSnglStirWid(), snglStirWid, diameter);
        } else {
            column.setOptSnglStirWidNull();
        }
        if (trapStirLen.getNumOfStirrups() > 0) {
            assignTrapStir(column.getOptTrapStirLen(), trapStirLen, diameter);
        } else {
            column.setOptTrapStirLenNull();
        }
    }

    /**
     * Method that Get Maximum Area Of Steel Ratio for different cases
     *
     * @param columnLocation Column Location
     *
     * @return The Maximum Area Of Steel Ratio
     */
    public double getMaxAreaOfSteelRatio(String columnLocation) {
        switch (columnLocation) {
            case "Interior":
                return 0.04;
            case "Exterior":
                return 0.05;
            default:
                return 0.06;
        }
    }

    /**
     * Method that Optimize All Floors instances
     *
     * @param characteristicStrengthOfConcrete Characteristic Strength Of Concrete for All Optimize Floors
     * @param yieldStrengthOfSteel yield Strength Of Steel for All Optimize Floors
     * @param costs Costs of All Optimize Floors
     * @param usedLongitudinalBarDiameters used Longitudinal Bar Diameters for All Optimize Floors
     * @param usedStirrupDiameters Used Stirrup Diameter for All Optimize Floors
     * @param spliceType Splice Type instance for All Optimize Floors
     *
     */
    public void optimizeAllFloors(double characteristicStrengthOfConcrete, double yieldStrengthOfSteel, Costs costs,
            ArrayList<Double> usedLongitudinalBarDiameters, ArrayList<Double> usedStirrupDiameters, Splice spliceType) {
        this.assignOptimizedFloors(this.building.getFloors(), characteristicStrengthOfConcrete, yieldStrengthOfSteel,
                costs, usedLongitudinalBarDiameters, usedStirrupDiameters, spliceType);
    }

    /**
     * Method that Assign All Optimized Columns in the given Floor instance
     *
     * @param floor Floor instance to be assign
     * @param characteristicStrengthOfConcrete Characteristics Strength Of Concrete to be assign
     * @param yieldStrengthOfSteel Yield Strength Of Steel to be assign
     * @param costs Costs of ALL Optimized Columns to be assign
     * @param usedLongitudinalBarDiameters used Longitudinal Bar Diameters of All Optimized Columns to be assign
     * @param usedStirrupDiameters used Stirrup Diameters of All Optimized Column to be assign
     * @param spliceType Splice Type instance to be assign
     *
     */
    public void assignOptimizedFloor(Floor floor, double characteristicStrengthOfConcrete, double yieldStrengthOfSteel,
            Costs costs, ArrayList<Double> usedLongitudinalBarDiameters, ArrayList<Double> usedStirrupDiameters,
            Splice spliceType) {
        ArrayList<Column> columns = floor.getColumns();
        for (Column column : columns) {
            this.assignOptimizedColumn(column, characteristicStrengthOfConcrete, yieldStrengthOfSteel,
                    floor.getHeightOfFloor(), costs, usedLongitudinalBarDiameters, usedStirrupDiameters, spliceType);
        }
    }

    /**
     * Method that Assign All optimized floors in the given list of Floors instances
     *
     * @param floors Floors instance to be assign
     * @param characteristicStrengthOfConcrete Characteristic Strength Of Concrete to be assign for all floors
     * @param yieldStrengthOfSteel Yield Strength Of Steel to be assign for all floors
     * @param costs Total Costs of All Floors to be assign
     * @param usedLongitudinalBarDiameters Used Longitudinal Bar Diameters to be assign for all Floors
     * @param usedStirrupDiameters Used Stirrup Diameters to be assign for all Floors
     * @param spliceType Splice Type to be assign for all Floors
     *
     */
    public void assignOptimizedFloors(ArrayList<Floor> floors, double characteristicStrengthOfConcrete,
            double yieldStrengthOfSteel, Costs costs, ArrayList<Double> usedLongitudinalBarDiameters,
            ArrayList<Double> usedStirrupDiameters, Splice spliceType) {
        for (Floor floor : floors) {
            assignOptimizedFloor(floor, characteristicStrengthOfConcrete, yieldStrengthOfSteel, costs,
                    usedLongitudinalBarDiameters, usedStirrupDiameters, spliceType);
        }
    }

    /**
     * Method that Assign Optimized Column instance
     *
     * @param column Column instance to be assign
     * @param characteristicStrengthOfConcrete Characteristic Strength Of Concrete for Optimized Column to be assign
     * @param yieldStrengthOfSteel Yield Strength Of Steel for Optimized Column to be assign
     * @param heightOfFloor Height Of Floor to be assign
     * @param costs Total Costs instance for Optimized Column to be assign
     * @param usedLongitudinalBarDiameters Used Longitudinal Bar Diameters for Optimized Column to be assign
     * @param usedStirrupDiameters Used Stirrup Diameters For Optimized Column to be assign
     *
     */
    private void assignOptimizedColumn(Column column, double characteristicStrengthOfConcrete,
            double yieldStrengthOfSteel, double heightOfFloor, Costs costs,
            ArrayList<Double> usedLongitudinalBarDiameters, ArrayList<Double> usedStirrupDiameters, Splice spliceType) {

        double minWidth = column.getMinWidth();
        double minLength = column.getMinLength();
        double maxWidth = column.getMaxWidth();
        double maxLength = column.getMaxLength();
        double compressiveLoad = column.getCompressiveLoad();
        double concreteCover = column.getConcreteCover();
        double maxAreaOfSteelRatio = column.getMaxAreaOfSteelRatio();

        double totalCostMin = Double.MAX_VALUE;

        // Costs calculated during execution
        double totalCost, costSt, costSplice, costBars, concreteCost;

        // All costs
        double oneSpliceCost, stirrupCostPerTon, longitudinalBarCostPerTon, concreteCostPerTon;
        oneSpliceCost = costs.getOneSpliceCost();
        stirrupCostPerTon = costs.getStirrupCostPerTon();
        longitudinalBarCostPerTon = costs.getLongitudinalBarCostPerTon();
        concreteCostPerTon = costs.getConcreteCostPerTon();

        for (double width = Math.max(minWidth, 200); width <= maxWidth; width = Math.floor((width + 50) / 50.0) * 50) {
            System.out.println("b = " + width);
            for (double length = Math.max(minLength, width); length <= maxLength; length = Math.floor((length + 50) / 50.0) * 50) {
                System.out.println("t = " + length);
                if (length > 5 * width) {
                    System.out.println("t > 5*b");
                    continue;
                }

                double areaOfSteel = Optimizer.getAreaOfSteel(characteristicStrengthOfConcrete, yieldStrengthOfSteel,
                        compressiveLoad, width, length);

                System.out.println("u = " + areaOfSteel / (width * length));

                concreteCost = Optimizer.getConcreteCost(heightOfFloor, width, length, concreteCostPerTon);

                if (areaOfSteel <= Optimizer.getMaxAreaOfSteel(maxAreaOfSteelRatio, width, length)) {
                    /* Function calculateLongDiameter */
                    for (double usedLongitudinalBarDiameter : usedLongitudinalBarDiameters) {
                        System.out.println("ULD: = " + usedLongitudinalBarDiameter);
                        int noOfBars = Optimizer.getNumOfBars(areaOfSteel, usedLongitudinalBarDiameter);
                        /**
                         * Minimum number of bars in cross section
                         */
                        int minNumOfBarsInCrossSection;
                        double spacingBetweenBarsAlongWidth, spacingBetweenBarsAlongLength, averageSpacingBetweenBars;
                        /* average no. of stirrups in one section */
                        /**
                         * Number Of Bars Along Width
                         */
                        int numOfBarsAlongWidth;
                        /**
                         * Number Of Bars Along Length
                         */
                        int numOfBarsAlongLength;
                        double totalPerimOfStirrups;
                        double totalLengthOfStirrups;
                        /**
                         * Total number of stirrups
                         */
                        int numOfStirrups;

                        minNumOfBarsInCrossSection = Optimizer.getMinNumOfBarsInCrossSection(
                                width, length, concreteCover
                        );
                        if (noOfBars < minNumOfBarsInCrossSection) {
                            noOfBars = minNumOfBarsInCrossSection;
                        }

                        averageSpacingBetweenBars = Optimizer.getAverageSpacingBetweenBars(
                                width, length, concreteCover, noOfBars
                        );

                        if (noOfBars == minNumOfBarsInCrossSection) {
                            numOfBarsAlongWidth = Optimizer.getNumOfBarsAlongWidth(width, concreteCover,
                                    averageSpacingBetweenBars, Optimizer.NBAWSC);  // special case  to avoid a problem where the
                            // spacing between bars along t is
                            // more than 250 mm
                        } else {

                            numOfBarsAlongWidth = Optimizer.getNumOfBarsAlongWidth(width, concreteCover,
                                    averageSpacingBetweenBars, Optimizer.NBAWNC); // the normal case
                        }
                        numOfBarsAlongLength = Optimizer.getNumOfBarsAlongLength(noOfBars, numOfBarsAlongWidth);
                        spacingBetweenBarsAlongLength = Optimizer.getSpacingBetweenBars(
                                length, concreteCover, numOfBarsAlongLength
                        );
                        spacingBetweenBarsAlongWidth = Optimizer.getSpacingBetweenBars(
                                width, concreteCover, numOfBarsAlongWidth
                        );

                        /**
                         * Main Stirrup
                         */
                        RectangularStirrups mainStirLen = new RectangularStirrups();
                        /**
                         * Rectangular Stirrups Along Length
                         */
                        RectangularStirrups rectStirLen = new RectangularStirrups();
                        /**
                         * Rectangular Stirrups Along Width
                         */
                        RectangularStirrups rectStirWid = new RectangularStirrups();
                        /**
                         * Single Stirrups Along Width
                         */
                        SingleStirrups snglStirWid = new SingleStirrups();
                        /**
                         * Single Stirrups Along Length
                         */
                        SingleStirrups snglStirLen = new SingleStirrups();
                        /**
                         * Trapezoidal Stirrups Along Length
                         */
                        TrapezoidalStirrups trapStirLen = new TrapezoidalStirrups();

                        Optimizer.assignTypesOfStirrups(
                                mainStirLen, rectStirWid, rectStirLen, snglStirWid, snglStirLen, trapStirLen, width,
                                length, spacingBetweenBarsAlongWidth, spacingBetweenBarsAlongLength,
                                numOfBarsAlongWidth, numOfBarsAlongLength, concreteCover, usedLongitudinalBarDiameter
                        );

                        /*
                         * getStrripCost function comes after getLongCost: attributes strriup cost,
                         * strriup diameter, longDiameter, concerteCover, longBarsNumber,
                         *
                         */
                        for (double usedStirrupDiameter : usedStirrupDiameters) {
                            System.out.println("USD: = " + usedStirrupDiameter);
                            if (usedStirrupDiameter < 0.25 * usedLongitudinalBarDiameter) {
                                continue;
                            }

                            mainStirLen.calcLength();
                            rectStirLen.calcLength();
                            rectStirWid.calcLength();
                            snglStirLen.calcLength();
                            snglStirWid.calcLength();
                            trapStirLen.calcLength();

                            totalPerimOfStirrups = getPerimOfStirrups(
                                    mainStirLen, rectStirLen, rectStirWid, snglStirLen, snglStirWid, trapStirLen
                            );

                            numOfStirrups = getNumOfStirrups(
                                    mainStirLen, rectStirLen, rectStirWid, snglStirLen, snglStirWid, trapStirLen
                            );

                            totalLengthOfStirrups = Optimizer.getTotalLengthOfStirrups(
                                    numOfStirrups, totalPerimOfStirrups, usedStirrupDiameter
                            );

                            costBars = Optimizer.getLongitudinalBarsCost(noOfBars, usedLongitudinalBarDiameter, heightOfFloor,
                                    longitudinalBarCostPerTon);

                            if (spliceType == Splice.LAP) {
                                costSplice = Double.max(40 * usedLongitudinalBarDiameter, 1000) * noOfBars
                                        * Optimizer.getAreaOfBar(usedLongitudinalBarDiameter) * 7.851
                                        * longitudinalBarCostPerTon * 0.000000001;
                            } else {
                                costSplice = noOfBars * oneSpliceCost;
                            }

                            for (double spacingBetweenStirrups = Math.min(usedLongitudinalBarDiameter * 15, 200);
                                    spacingBetweenStirrups >= 50;
                                    spacingBetweenStirrups = Math.ceil((spacingBetweenStirrups - 50) / 50.0) * 50) {
                                if ((totalPerimOfStirrups * 1000 * Optimizer.getAreaOfBar(usedStirrupDiameter))
                                        / spacingBetweenStirrups >= 2.5 * width * length) {
                                    costSt = Optimizer.getStirrupsCost(totalLengthOfStirrups, usedStirrupDiameter,
                                            heightOfFloor, spacingBetweenStirrups, stirrupCostPerTon);

                                    totalCost = Optimizer.getTotalCost(
                                            costSt, concreteCost, costSplice, costBars
                                    );

                                    System.out.println("sSt = " + spacingBetweenStirrups);
                                    System.out.println("totalCost = " + totalCost);

                                    // function updateTotalCost
                                    if (totalCost < totalCostMin) {
                                        totalCostMin = totalCost;
                                        column.getOptColumn().setSpacingBetweenStirrups(spacingBetweenStirrups);
                                        column.getOptColumn().setNumOfStirrups(numOfStirrups);
                                        column.getOptColumn().setCost(totalCostMin);
                                        column.getOptColumn().setLength(length);
                                        column.getOptColumn().setWidth(width);
                                        assignOptimumLongitudinalBarsDetails(column, usedLongitudinalBarDiameter, spacingBetweenBarsAlongLength,
                                                spacingBetweenBarsAlongWidth, noOfBars, numOfBarsAlongLength, numOfBarsAlongWidth);
                                        assignOptimumStirrupsDetails(usedStirrupDiameter, column, mainStirLen, rectStirLen, rectStirWid, snglStirLen, snglStirWid, trapStirLen);
                                        column.getOptColumn().setCompressiveCapacity(Optimizer.getCompressiveCapacity(characteristicStrengthOfConcrete, width, length, yieldStrengthOfSteel, usedLongitudinalBarDiameter, noOfBars));
                                        column.getOptColumn().setReinforcementRatio(Optimizer.getReinforcementRatio(noOfBars, usedLongitudinalBarDiameter, width, length));
                                    }

                                    break;
                                }
                            }
                        }

//                                System.out.println("Total Stirrups Perimeter = " + Perim + " mm");
//                                System.out.println("Total Needed Length for stirrups production = " + L + " mm");
                    }
                }
            }
        }

        System.out.println("=========================================");
        System.out.println("Ultimate capacity = " + column.getOptColumn().getCompressiveCapacity() + " N");
        System.out.println("Width = " + column.getOptColumn().getWidth());
        System.out.println("Length = " + column.getOptColumn().getLength());
        System.out.println("-----------------------------------------");
        System.out.println("RFT ratio = " + column.getOptColumn().getReinforcementRatio() * 100 + " %");
        System.out.println("No. of bars = " + column.getOptLongBars().getNumberOfLongitudinalBars());
        System.out.println("Bars diameter = " + column.getOptLongBars().getDiameter());
        System.out.println("No. of bars along width = " + column.getOptLongBars().getNumberOfLongitudinalBarsAlongWidth());
        System.out.println("No. of bars along length = " + column.getOptLongBars().getNumberOfLongitudinalBarsAlongLength());
        System.out.println("Bars spacing along width = " + column.getOptLongBars().getLongitudinalBarsSpacingAlongWidth());
        System.out.println("Bars spacing along length = " + column.getOptLongBars().getLongitudinalBarsSpacingAlongLength());
        System.out.println("-----------------------------------------");
        System.out.println("Stirrups spacing = " + column.getOptColumn().getSpacingBetweenStirrups());
        System.out.println("Stirrups diameter = " + column.getOptMainStirLen().getDiameter());
        System.out.println("-----------------------------------------");
        System.out.println("Total no. of stirrups = " + column.getOptColumn().getNumOfStirrups());
        System.out.println("----------------------");
        System.out.println("1 Main Stirrup " + column.getOptMainStirLen().getDimensionNormalToDirection() + " x "
                + column.getOptMainStirLen().getDimensionAlongDirection() + " mm");
        if (!column.optRectStirLenIsNull()) {
            System.out.println(column.getOptRectStirLen().getNumberOfStirrups() + " rectangular stirrups "
                    + column.getOptRectStirLen().getDimensionNormalToDirection() + " x "
                    + column.getOptRectStirLen().getDimensionAlongDirection() + " mm");
            System.out.println("along the length");
        }
        if (!column.optRectStirWidIsNull()) {
            System.out.println(column.getOptRectStirWid().getNumberOfStirrups() + " rectangular stirrups "
                    + column.getOptRectStirWid().getDimensionAlongDirection() + " x "
                    + column.getOptRectStirWid().getDimensionNormalToDirection() + " mm");
            System.out.println("along the width");
        }
        if (!column.optTrapStirLenIsNull()) {
            System.out.println(column.getOptTrapStirLen().getNumberOfStirrups() + " trapezoidal stirrups: long y dimension "
                    + column.getOptTrapStirLen().getLongDimensionNormalToDirection() + " , short y dimension "
                    + column.getOptTrapStirLen().getShortDimensionNormalToDirection() + " mm");
            System.out.println("and inclined dimension " + column.getOptTrapStirLen().getInclinedDirection() + " mm");
        }
        if (!column.optSnglStirLenIsNull()) {
            System.out.println(column.getOptSnglStirLen().getNumberOfStirrups() + " single stirrups "
                    + column.getOptSnglStirLen().getDimensionNormalToDirection() + " mm");
            System.out.println("along the length");
        }
        if (!column.optSnglStirWidIsNull()) {
            System.out.println(column.getOptSnglStirWid().getNumberOfStirrups() + " single stirrups "
                    + column.getOptSnglStirWid().getDimensionNormalToDirection() + " mm");
            System.out.println("along the width");
        }
        System.out.println("----------------------");
        System.out.println("Total Cost = " + column.getOptColumn().getCost());
        System.out.println("=========================================");

    }

    /**
     * Method that Assign Models in Floor
     *
     * @param floor Floor instance
     * @param numOfmodels Number Of Models used in Floor instance
     *
     */
    public void assignModelsInFloor(Floor floor, int numOfmodels) {
        int numOfCols = floor.getColumns().size();

        double colCost[] = new double[numOfCols];
        for (int colNum = 0; colNum < numOfCols; colNum++) {
            colCost[colNum] = floor.getColumns().get(colNum).getOptColumn().getCost();
        }

        int[] indices = new int[numOfCols];
        for (int i = 0; i < numOfCols; i++) {
            indices[i] = i;
        }

        Utilities.quickSortWithIndices(colCost, indices);

        floor.getOptFloor().setColumnsCost(Double.MAX_VALUE);
        int[] optSol = Optimizer.getOptimumColumnModelIndices(
                floor.getOptFloor(), numOfCols, numOfmodels, new int[numOfCols], colCost, 0, new int[numOfCols]
        );

        optSol = resortGivenIndices(optSol, indices);

        int[] optTrueSol = new int[numOfCols];
        for (int i = 0; i < numOfCols; i++) {
            optTrueSol[i] = Utilities.indexOfElementInArray(
                    indices, optSol[i]
            );
        }

        floor.getOptFloor().setColumnToColumnModelIndicesMap(optTrueSol);
    }

    /**
     * Method that Return a sorted array according to the switchedIndices given, with no harm to the given array
     *
     * @param arr Given array of elements
     * @param switchedIndices Array containing the indices of each element in the given array
     *
     * @return The resorted array
     */
    public int[] resortGivenIndices(int[] arr, int[] switchedIndices) {
        int n = arr.length;
        int[] resortedArr = new int[n];

        for (int i = 0; i < n; i++) {
            resortedArr[switchedIndices[i]] = arr[i];
        }

        return resortedArr;
    }

    /**
     * Method that Assign Models for Floors instances
     *
     * @param floors Floors instances
     * @param numOfModels Number of Models to be assign for Floors
     *
     */
    public void assignModelsInFloors(ArrayList<Floor> floors, int numOfModels) {
        for (Floor floor : floors) {
            assignModelsInFloor(floor, numOfModels);
        }
    }
}


