package com.civil.sods.optimize;

import com.civil.sods.objects.RectangularStirrups;
import com.civil.sods.objects.SingleStirrups;
import com.civil.sods.objects.TrapezoidalStirrups;
import com.civil.sods.objects.optimum.OptimumFloor;

/**
 * Class responsible Of Optimization
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class Optimizer {

    /**
     * Number of Bars Along Width Normal Case
     */
    public static final int NBAWNC = 1;

    /**
     * Number of Bars Along Width Special Case: To avoid a problem where the spacing between bars along the length is
     * more than 250 mm
     */
    public static final int NBAWSC = 2;

    /**
     * Maximum Distance Between Successive Tied And Untied Bars
     */
    public static final int MDBSTU = 150;

    /**
     * Maximum Distance Between Two Tied Bars That Are Successive
     */
    private static final int MDBTTBTAS = 250;

    /**
     * Standard Value
     */
    private static final double DIMENSION_RATIO = 1.5;

    /**
     * Standard Value
     */
    private static final int NUMBER_OF_BARS_THREE = 3, NUMBER_OF_BARS_FOUR = 4, NUMBER_OF_BARS_FIVE = 5,
            NUMBER_OF_BARS_SIX = 6, NUMBER_OF_BARS_SEVEN = 7;

    /**
     * Method that Gets Area Of Steel
     *
     * @param characteristicStrengthOfConcrete Characteristics Strength Of Concrete to be get
     * @param yieldStrengthOfSteel Yield Strength Of Steel to be get
     * @param compressiveLoad Compressive Load to be get
     * @param width Width to get
     * @param length Length to be get
     *
     * @return Area Of Steel
     */
    public static double getAreaOfSteel(double characteristicStrengthOfConcrete, double yieldStrengthOfSteel,
            double compressiveLoad, double width, double length) {
        return Double.max((compressiveLoad - 0.35 * characteristicStrengthOfConcrete * width * length)
                / (0.67 * yieldStrengthOfSteel - 0.35 * characteristicStrengthOfConcrete),
                0.008 * width * length);
    }

    /**
     * Method that Gets Concrete Cost
     *
     * @param heightOfFloor Height Of Floor to be get
     * @param width Width to be get
     * @param length Length to be get
     * @param concreteCostPerTon Concrete Cost Per Ton to be get
     *
     * @return Concrete Cost
     */
    public static double getConcreteCost(double heightOfFloor, double width, double length, double concreteCostPerTon) {
        return heightOfFloor * width * length * concreteCostPerTon * 0.000001;
    }

    /**
     * Method that Gets Maximum Area Of Steel
     *
     * @param maxAreaOfSteelRatio Maximum Area Of Steel Ratio to be set
     * @param width Width to be set
     * @param length Length to be set
     *
     * @return Maximum Area Of Steel
     */
    public static double getMaxAreaOfSteel(double maxAreaOfSteelRatio, double width, double length) {
        return maxAreaOfSteelRatio * width * length;
    }

    /**
     * Method that Gets Minimum Number Of Bars In Cross Section
     *
     * @param width Width to be get
     * @param length Length to be get
     * @param concreteCover Concrete Cover to be get
     *
     * @return Minimum Number Of Bars In Cross Section
     */
    public static int getMinNumOfBarsInCrossSection(double width, double length, double concreteCover) {
        return (int) (2 * (Math.ceil((length - 2.0 * concreteCover) / MDBTTBTAS)
                + Math.ceil((width - 2.0 * concreteCover) / MDBTTBTAS)));
    }

    /**
     * Method that Gets the number of bars as the nearest bigger even number
     *
     * @param areaOfSteel Area Of Steel to be get
     * @param longitudinalBarDiameter Longitudinal Bars Diameter to be get
     *
     * @return the Number Of Bars to the nearest bigger even number
     */
    public static int getNumOfBars(double areaOfSteel, double longitudinalBarDiameter) {
        return (int) (Math.ceil((areaOfSteel * 4.0 / (Math.PI * Math.pow(longitudinalBarDiameter, 2))) / 2.0) * 2);
    }

    /**
     * OK: no of spacings = no of bars
     *
     * Method that Gets Average Spacing Between Bars
     *
     * @param width Width to be get
     * @param length Length to be get
     * @param concreteCover Concrete Cover to be get
     * @param noOfBars Number Of Bars to be get
     *
     * @return Average Spacing Between Bars
     */
    public static double getAverageSpacingBetweenBars(double width, double length, double concreteCover, int noOfBars) {
        return 2 * (width + length - 4 * concreteCover) / noOfBars;
    }

    /**
     * Method that Gets Number Of Bars Along Length
     *
     * @param noOfBars Number Of Bars to be get
     * @param numOfBarsAlongWidth Number Of Bars Along Width to be get
     *
     * @return Number Of Bars Along Length
     */
    public static int getNumOfBarsAlongLength(int noOfBars, int numOfBarsAlongWidth) {
        return (noOfBars - 2 * numOfBarsAlongWidth) / 2 + 2;
    }

    /**
     * Method that Gets Spacing Between Bars
     *
     * @param columnDimension Column Dimension to be get
     * @param concreteCover Concrete Cover to be get
     * @param numOfBarsAlongDimensionDirection Number Of Bars Along DImension Direction
     *
     * @return Spacing Between Bars
     */
    public static double getSpacingBetweenBars(double columnDimension, double concreteCover,
            int numOfBarsAlongDimensionDirection) {
        return (columnDimension - 2 * concreteCover) / (numOfBarsAlongDimensionDirection - 1);
    }

    /**
     * Method that Gets Number Of Bars Along Width
     *
     * @param width Width to be get
     * @param concreteCover Concrete Cover to be get
     * @param averageSpacingBetweenBars Average Spacing Between Bars to be get
     * @param solvingCase Solving Case to be get
     *
     * @return Number Of Bars Along Width According to the Solving Case
     */
    public static int getNumOfBarsAlongWidth(double width, double concreteCover, double averageSpacingBetweenBars,
            int solvingCase) {
        if (solvingCase == NBAWNC) {
            return getNumOfBarsAlongWidthNormalCase(width, concreteCover, averageSpacingBetweenBars);
        } else if (solvingCase == NBAWSC) {
            return getNumOfBarsAlongWidthSpecialCase(width, concreteCover);
        }
        return -1;
    }

    /**
     * Method that Gets Number Of Bars Along Width in Normal Case
     *
     * @param width Width to be get
     * @param concreteCover Concrete Cover to be get
     * @param averageSpacingBetweenBars Average Spacing Between Bars to be get
     *
     * @return Number Of Bars Along Width in Normal Case
     */
    private static int getNumOfBarsAlongWidthNormalCase(double width, double concreteCover,
            double averageSpacingBetweenBars) {
        return (int) (Math.ceil((width - 2.0 * concreteCover) / averageSpacingBetweenBars) + 1);
    }

    /**
     * Method that Gets Number Of Bars Along Width in Special Case
     *
     * @param width Width to be get
     * @param concreteCover Concrete Cover to be get
     *
     * @return Number Of Bars Along Width in Special Case
     */
    private static int getNumOfBarsAlongWidthSpecialCase(double width, double concreteCover) {
        return (int) (Math.ceil((width - 2.0 * concreteCover) / MDBTTBTAS) + 1);
    }

    // check whether to delete or no
    /**
     * Method that Gets Rectangular Stirrups Along Length
     *
     * @param rectStirNum Rectangular Stirrups Number to get
     * @param rectStirDimNormalToDir Rectangular Stirrups Dimension Normal To Direction to get
     * @param rectStirDimAlongDir Rectangular Stirrups Dimension Along Direction to get
     *
     * @return Rectangular Stirrups Along Length
     */
    public static double getRectStirLength(int rectStirNum, double rectStirDimNormalToDir, double rectStirDimAlongDir) {
        return rectStirNum * (rectStirDimNormalToDir + rectStirDimAlongDir);
    }

    // check whether to delete or no
    /**
     * Method that Gets Single Stirrup Along Length
     *
     * @param snglStirNum Single Stirrup Number
     * @param snglStirNumDimNormalToDir Single Stirrups Number Dimension Normal To Direction
     *
     * @return Single Stirrup Along Length
     */
    public static double getSnglStirLength(int snglStirNum, double snglStirNumDimNormalToDir) {
        return snglStirNum * snglStirNumDimNormalToDir;
    }

    // check whether to delete or no
    /**
     * Method that Gets Trapezoidal Stirrup Along Length
     *
     * @param trapStirNum Trapezoidal Stirrup Number
     * @param trapShortDimensionNormalToDirection Trapezoidal Short Dimension Normal To Direction
     * @param trapLongDimensionNormalToDirection Trapezoidal Long Dimension Normal To Direction
     * @param trapInclinedDirection Trapezoidal Inclined Direction
     *
     * @return Trapezoidal Stirrup Along Length
     */
    public static double getTrapStirLength(int trapStirNum, double trapShortDimensionNormalToDirection,
            double trapLongDimensionNormalToDirection, double trapInclinedDirection) {
        return trapStirNum * (trapInclinedDirection * 2 + trapLongDimensionNormalToDirection + trapShortDimensionNormalToDirection);
    }

    /**
     * Method that Gets Main Stirrup Length
     *
     * @param width Width to be get
     * @param length Length to be get
     * @param concreteCover Concrete Cover to be get
     *
     * @return Main Stirrup Length
     */
    public static double getMainStirLength(double width, double length, double concreteCover) {
        return (width + length - 4 * concreteCover) * 2;
    }

    /**
     * Method that Gets Main Stirrup Dimension
     *
     * @param columnDimension Column Dimension to be get
     * @param concreteCover Concrete Cover to be get
     *
     * @return Main Stirrup Dimension
     */
    private static double getMainStirDim(double columnDimension, double concreteCover) {
        return columnDimension - 2 * concreteCover;
    }

    /**
     * Method that Gets Reinforcement Ratio
     *
     * @param numOfBars Number Of Bars to be get
     * @param longitudinalBarsDiameter Longitudinal Bars Diameter to be get
     * @param width Width to be get
     * @param length Length to be get
     *
     * @return Reinforcement Ratio
     */
    public static double getReinforcementRatio(int numOfBars, double longitudinalBarsDiameter, double width,
            double length) {
        return (numOfBars * Math.PI * Math.pow(longitudinalBarsDiameter, 2)) / (4.0 * width * length);
    }

    /**
     * Method that Gets Compressive Capacity
     *
     * @param characteristicStrengthOfConcrete Characteristic Strength Of Concrete to be get
     * @param width Width to be get
     * @param length Length to be get
     * @param yieldStrengthOfSteel Yield Strength Of Steel to be get
     * @param diameterOfLongitudinalStirrups Diameter Of Longitudinal Stirrups to be get
     * @param noOfBars Number Of Bars to be get
     *
     * @return Compressive Capacity
     */
    public static double getCompressiveCapacity(double characteristicStrengthOfConcrete, double width, double length,
            double yieldStrengthOfSteel, double diameterOfLongitudinalStirrups, int noOfBars) {
        return 0.35 * characteristicStrengthOfConcrete * width * length + 0.67 * yieldStrengthOfSteel * 0.25
                * Math.PI * diameterOfLongitudinalStirrups * diameterOfLongitudinalStirrups * noOfBars;
    }

    /**
     * Method that Assign Type Of Stirrup
     *
     * @param mainStirLen Main Stirrup Along Length to be assign
     * @param rectStirWid Rectangular Stirrup Along Width to be assign
     * @param rectStirLen Rectangular Stirrup Along Length to be assign
     * @param snglStirWid Single Stirrup Along Width to be assign
     * @param snglStirLen Single Stirrup Along Length to be assign
     * @param trapStirLen Trapezoidal Stirrup Along Length to be assign
     * @param width Width to be assign
     * @param length Length to be assign
     * @param spacingBetweenBarsAlongWidth Spacing Between Bars Along Width to be assign
     * @param spacingBetweenBarsAlongLength Spacing Between Bars Along Length to be assign
     * @param numOfBarsAlongWidth Number Of Bars Along Width to be assign
     * @param numOfBarsAlongLength Number Of Bars Along Length to be assign
     * @param concreteCover Concrete Cover to be assign
     * @param longDiameter Longitudinal bar diameter
     *
     */
    public static void assignTypesOfStirrups(RectangularStirrups mainStirLen, RectangularStirrups rectStirWid,
            RectangularStirrups rectStirLen, SingleStirrups snglStirWid, SingleStirrups snglStirLen,
            TrapezoidalStirrups trapStirLen, double width, double length, double spacingBetweenBarsAlongWidth,
            double spacingBetweenBarsAlongLength, int numOfBarsAlongWidth, int numOfBarsAlongLength,
            double concreteCover, double longDiameter) {
        int numOfBarsToBeSubtractedAlongLength = 0;
        int temporaryNumOfStirrups;
        double[] offset;

        // TODO to be removed after generalizing this concept
        double spacingBetweenBarsAlongWidthPtp = (width - numOfBarsAlongWidth * longDiameter) / (numOfBarsAlongWidth - 1);
        double spacingBetweenBarsAlongLengthPtp = (length - numOfBarsAlongLength * longDiameter) / (numOfBarsAlongLength - 1);

        // Working along width
        if (spacingBetweenBarsAlongWidth <= MDBSTU) {
            // For using trapezoidal stirrups
            if ((length / width >= DIMENSION_RATIO)
                    && (numOfBarsAlongWidth <= NUMBER_OF_BARS_SEVEN && numOfBarsAlongWidth >= NUMBER_OF_BARS_FOUR)) {
                trapStirLen.setNumOfStirrups(2);
                trapStirLen.setLongDimensionNormalToDirection(width - 2 * concreteCover);
                if (numOfBarsAlongWidth == NUMBER_OF_BARS_FIVE || numOfBarsAlongWidth == NUMBER_OF_BARS_SIX
                        || numOfBarsAlongWidth == NUMBER_OF_BARS_SEVEN) {
                    int barNumTiedWithTrapStirAfterCornerBarAlongLength;
                    if (spacingBetweenBarsAlongLength <= Optimizer.MDBSTU) {
                        barNumTiedWithTrapStirAfterCornerBarAlongLength = 2;
                    } else {
                        barNumTiedWithTrapStirAfterCornerBarAlongLength = 1;
                    }
                    trapStirLen.setNominalDimensionAlongDirection(
                            barNumTiedWithTrapStirAfterCornerBarAlongLength * spacingBetweenBarsAlongLength
                    );
                    trapStirLen.setInclinedDimension(
                            Math.sqrt(
                                    Math.pow(2 * spacingBetweenBarsAlongWidth, 2)
                                    + Math.pow(trapStirLen.getNominalDimensionAlongDirection(), 2)
                            )
                    );
                    numOfBarsToBeSubtractedAlongLength = 2 * barNumTiedWithTrapStirAfterCornerBarAlongLength;
                    trapStirLen.setShortDimensionNormalToDirection(
                            (numOfBarsAlongWidth - 5) * spacingBetweenBarsAlongWidth
                    );
                } else {
                    // Will enter only if numOfBarsAlongWidth == 4

                    trapStirLen.setNominalDimensionAlongDirection(spacingBetweenBarsAlongLength);
                    trapStirLen.setInclinedDimension(
                            Math.sqrt(
                                    Math.pow(spacingBetweenBarsAlongWidth, 2)
                                    + Math.pow(spacingBetweenBarsAlongLength, 2)
                            )
                    );

                    trapStirLen.setShortDimensionNormalToDirection(spacingBetweenBarsAlongWidth);
                    numOfBarsToBeSubtractedAlongLength = 2;
                }
            } else {
                if (Math.ceil((numOfBarsAlongWidth - 3) / 4.0) < Math.ceil((numOfBarsAlongWidth - 3) / 3.0)) {
                    temporaryNumOfStirrups = (int) Math.ceil((numOfBarsAlongWidth - 3) / 4.0);
                    rectStirWid.setNumOfStirrups(temporaryNumOfStirrups);
                    rectStirWid.setDimensionNormalToDirection(length - 2 * concreteCover);
                    rectStirWid.setDimensionAlongDirection(2 * spacingBetweenBarsAlongWidth);
//                    if (numOfBarsAlongLength == 13) {
                    if (numOfBarsAlongWidth == 13) {
                        snglStirWid.setNumOfStirrups(1);
                        snglStirWid.setDimensionNormalToDirection(length - 2 * concreteCover);
                        offset = new double[snglStirWid.getNumOfStirrups()];
//                        offset[0] = ((numOfBarsAlongWidth - 1.0) / 2) * spacingBetweenBarsAlongWidth;
                        offset[0] = ((numOfBarsAlongWidth - 1.0) / 2) * (spacingBetweenBarsAlongWidthPtp + longDiameter) + concreteCover;
                        snglStirWid.setOffset(offset);
                        temporaryNumOfStirrups--;
                        rectStirWid.setNumOfStirrups(temporaryNumOfStirrups);
                    }

                } else {
                    temporaryNumOfStirrups = (int) Math.ceil((numOfBarsAlongWidth - 3) / 3.0);
                    rectStirWid.setNumOfStirrups(temporaryNumOfStirrups);
                    rectStirWid.setDimensionNormalToDirection(length - 2 * concreteCover);
                    rectStirWid.setDimensionAlongDirection(spacingBetweenBarsAlongWidth);
//                    if (numOfBarsAlongLength == 5) {
                    if (numOfBarsAlongWidth == 5) {
                        snglStirWid.setNumOfStirrups(1);
                        snglStirWid.setDimensionNormalToDirection(length - 2 * concreteCover);
                        offset = new double[1];
//                        offset[0] = ((numOfBarsAlongWidth - 1.0) / 2) * spacingBetweenBarsAlongWidth;
                        offset[0] = ((numOfBarsAlongWidth - 1.0) / 2) * (spacingBetweenBarsAlongWidthPtp + longDiameter) + concreteCover;
                        snglStirWid.setOffset(offset);
                        temporaryNumOfStirrups--;
                        rectStirWid.setNumOfStirrups(temporaryNumOfStirrups);
                    }
                }

                if (temporaryNumOfStirrups > 0) {
                    rectStirWid.setOffset(
                            getRectangularStirrupsOffsetWhenSpacingLessThanOrEqualMdbstu(
                                    temporaryNumOfStirrups, numOfBarsAlongWidth, spacingBetweenBarsAlongWidth,
                                    rectStirWid.getDimensionAlongDirection(), width, concreteCover, longDiameter
                            )
                    );
                }
            }
        } else {
            // Will enter only if spacingBetweenBarsAlongWidth > MDBSTU

            // For using trapezoidal stirrups
            if ((length / width >= DIMENSION_RATIO)
                    && (numOfBarsAlongWidth == NUMBER_OF_BARS_THREE || numOfBarsAlongWidth == NUMBER_OF_BARS_FOUR)) {
                trapStirLen.setNumOfStirrups(2);
                trapStirLen.setLongDimensionNormalToDirection(width - 2 * concreteCover);
                trapStirLen.setNominalDimensionAlongDirection(spacingBetweenBarsAlongLength);
                trapStirLen.setInclinedDimension(Math.sqrt(Math.pow(spacingBetweenBarsAlongWidth, 2)
                        + Math.pow(spacingBetweenBarsAlongLength, 2)
                )
                );
                numOfBarsToBeSubtractedAlongLength = 2;
                if (numOfBarsAlongWidth == 3) {
                    trapStirLen.setShortDimensionNormalToDirection(0);
                } else {
                    // Will enter only if numOfBarsAlongWidth == NUMBER_OF_BARS_THREE

                    trapStirLen.setShortDimensionNormalToDirection(spacingBetweenBarsAlongWidth);
                }
            } else {
                rectStirWid.setDimensionNormalToDirection(length - 2 * concreteCover);
                rectStirWid.setDimensionAlongDirection(spacingBetweenBarsAlongWidth);
                if (numOfBarsAlongWidth % 2 == 0) {
                    temporaryNumOfStirrups = (numOfBarsAlongWidth - 2) / 2;
                    rectStirWid.setNumOfStirrups(temporaryNumOfStirrups);
                    offset = new double[temporaryNumOfStirrups];
                    for (int stirrupIndex = 0; stirrupIndex < temporaryNumOfStirrups; stirrupIndex++) {
                        offset[stirrupIndex] = spacingBetweenBarsAlongWidth * (2 * stirrupIndex + 1);
                    }
                    rectStirWid.setOffset(offset);
                } else {
                    if ((numOfBarsAlongWidth - 5) % 4 == 0) {
                        temporaryNumOfStirrups = (numOfBarsAlongWidth - 1) / 2;
                        rectStirWid.setNumOfStirrups(temporaryNumOfStirrups);
                    } else {
                        temporaryNumOfStirrups = (numOfBarsAlongWidth - 3) / 2;
                        rectStirWid.setNumOfStirrups(temporaryNumOfStirrups);
                        snglStirWid.setNumOfStirrups(1);
                        snglStirWid.setDimensionNormalToDirection(length - 2 * concreteCover);
                        offset = new double[1];
                        offset[0] = ((numOfBarsAlongWidth - 1) / 2) * spacingBetweenBarsAlongWidth;
                        snglStirWid.setOffset(offset);
                    }

                    if (temporaryNumOfStirrups > 0) {
                        rectStirWid.setOffset(
                                getRectangularStirrupsOffsetWhenSpacingGreaterThanMdbstu(temporaryNumOfStirrups,
                                        numOfBarsAlongWidth, 0, spacingBetweenBarsAlongWidth, width, concreteCover,
                                        longDiameter
                                )
                        );
                    }
                }
            }
        }

        int numOfBarsAlongLengthAfterEdit = numOfBarsAlongLength - numOfBarsToBeSubtractedAlongLength;

        // Working along length
        if (spacingBetweenBarsAlongLength <= MDBSTU) {
            if (Math.ceil((numOfBarsAlongLengthAfterEdit - 3) / 4.0)
                    < Math.ceil((numOfBarsAlongLengthAfterEdit - 3) / 3.0)) {
                temporaryNumOfStirrups = (int) Math.ceil((numOfBarsAlongLengthAfterEdit - 3) / 4.0);
                rectStirLen.setNumOfStirrups(temporaryNumOfStirrups);
                rectStirLen.setDimensionNormalToDirection(width - 2 * concreteCover);
                rectStirLen.setDimensionAlongDirection(2 * spacingBetweenBarsAlongLength);
                if (numOfBarsAlongLengthAfterEdit == 13) {
                    snglStirLen.setNumOfStirrups(1);
                    snglStirLen.setDimensionNormalToDirection(width - 2 * concreteCover);
                    offset = new double[1];
                    offset[0] = ((numOfBarsAlongLength - 1) / 2) * spacingBetweenBarsAlongLength;
                    snglStirLen.setOffset(offset);
                    temporaryNumOfStirrups--;
                    rectStirLen.setNumOfStirrups(temporaryNumOfStirrups);
                }
            } else {
                temporaryNumOfStirrups = (int) Math.ceil((numOfBarsAlongLengthAfterEdit - 3) / 3.0);
                rectStirLen.setNumOfStirrups(temporaryNumOfStirrups);
                rectStirLen.setDimensionNormalToDirection(width - 2 * concreteCover);
                rectStirLen.setDimensionAlongDirection(spacingBetweenBarsAlongLength);
                if (numOfBarsAlongLengthAfterEdit == 5) {
                    snglStirLen.setNumOfStirrups(1);
                    snglStirLen.setDimensionNormalToDirection(width - 2 * concreteCover);
                    offset = new double[1];
                    offset[0] = ((numOfBarsAlongLength - 1) / 2) * spacingBetweenBarsAlongLength;
                    snglStirLen.setOffset(offset);
                    temporaryNumOfStirrups--;
                    rectStirLen.setNumOfStirrups(temporaryNumOfStirrups);
                }
            }

            if (temporaryNumOfStirrups > 0) {
                rectStirLen.setOffset(
                        getRectangularStirrupsOffsetWhenSpacingLessThanOrEqualMdbstu(
                                temporaryNumOfStirrups, numOfBarsAlongLength, spacingBetweenBarsAlongLength,
                                rectStirLen.getDimensionAlongDirection(), length, concreteCover, longDiameter
                        )
                );
            }
        } else {
            // Will enter only if spacingBetweenBarsAlongLength > MDBSTU

            rectStirLen.setDimensionNormalToDirection(width - 2 * concreteCover);
            rectStirLen.setDimensionAlongDirection(spacingBetweenBarsAlongLength);
            if (numOfBarsAlongLengthAfterEdit % 2 == 0) {
                temporaryNumOfStirrups = (numOfBarsAlongLengthAfterEdit - 2) / 2;
                rectStirLen.setNumOfStirrups(temporaryNumOfStirrups);
                offset = new double[temporaryNumOfStirrups];
                for (int stirrupIndex = 0; stirrupIndex < temporaryNumOfStirrups; stirrupIndex++) {
                    offset[stirrupIndex] = spacingBetweenBarsAlongLength * (2 * stirrupIndex + 1
                            + (numOfBarsToBeSubtractedAlongLength % 2));
                }
                rectStirLen.setOffset(offset);
            } else {
                if ((numOfBarsAlongLengthAfterEdit - 5) % 4 == 0) {
                    temporaryNumOfStirrups = (numOfBarsAlongLengthAfterEdit - 1) / 2;
                    rectStirLen.setNumOfStirrups(temporaryNumOfStirrups);
                } else {
                    temporaryNumOfStirrups = (numOfBarsAlongLengthAfterEdit - 3) / 2;
                    rectStirLen.setNumOfStirrups(temporaryNumOfStirrups);
                    snglStirLen.setNumOfStirrups(1);
                    snglStirLen.setDimensionNormalToDirection(width - 2 * concreteCover);
                    offset = new double[1];
                    offset[0] = ((numOfBarsAlongLength - 1) / 2) * spacingBetweenBarsAlongLength;
                    snglStirLen.setOffset(offset);
                }

                if (temporaryNumOfStirrups > 0) {
                    rectStirLen.setOffset(
                            getRectangularStirrupsOffsetWhenSpacingGreaterThanMdbstu(temporaryNumOfStirrups,
                                    numOfBarsAlongLength, numOfBarsToBeSubtractedAlongLength, spacingBetweenBarsAlongLength,
                                    length, concreteCover, longDiameter
                            )
                    );
                }
            }
        }

        mainStirLen.setNumOfStirrups(1);
        mainStirLen.setDimensionAlongDirection(
                getMainStirDim(length, concreteCover)
        );
        mainStirLen.setDimensionNormalToDirection(
                getMainStirDim(width, concreteCover)
        );
        offset = new double[1];
        offset[0] = 0;
        mainStirLen.setOffset(offset);
    }

    /**
     * Method that Gets Rectangular Stirrups Offset When Spacing is Greater than Mdbstu
     *
     * @param numOfStirrups Number Of Stirrups
     * @param numOfBarsAlongDirection Number Of Bars Along Direction
     * @param numOfBarsToBeSubtractedAlongDirection Number Of Bars To Be Subtracted Along Direction
     * @param spacingBetweenBarsAlongDirection Spacing Between Bars Along Direction
     * @param columnDimensionAlongDirection Column Dimension Along Direction
     * @param concreteCover Concrete Cover
     *
     * @return Rectangular Stirrups Offset When Spacing is Greater than Mdbstu
     */
    private static double[] getRectangularStirrupsOffsetWhenSpacingGreaterThanMdbstu(int numOfStirrups,
            int numOfBarsAlongDirection, int numOfBarsToBeSubtractedAlongDirection,
            double spacingBetweenBarsAlongDirection, double columnDimensionAlongDirection, double concreteCover,
            double longDiameter) {
        double[] offset = new double[numOfStirrups];

        for (int stirrupIndex = 0; stirrupIndex < numOfStirrups; stirrupIndex++) {
            if (stirrupIndex < numOfStirrups / 2) {
                offset[stirrupIndex] = spacingBetweenBarsAlongDirection * (2 * stirrupIndex + 1
                        + (numOfBarsToBeSubtractedAlongDirection % 2)) + concreteCover;
            } else {
                offset[stirrupIndex] = columnDimensionAlongDirection - concreteCover
                        - spacingBetweenBarsAlongDirection * (2 * (stirrupIndex - numOfStirrups / 2) + 2
                        + (numOfBarsToBeSubtractedAlongDirection % 2));
            }
        }

        return offset;
    }

    /**
     * Method that Gets Rectangular Stirrup Offset When Spacing is Less Than Or Equal Mdbstu
     *
     * @param numOfStirrups Number Of Stirrups
     * @param numOfBarsAlongDirection Number Of Bars Along Direction
     * @param spacingBetweenBarsAlongDirection Spacing Between Bars Along Direction
     * @param dimensionOfStirAlongDirection Dimension Of Stirrup Along Direction
     * @param columnDimensionAlongDirection Column Dimension Along Direction
     * @param concreteCover Concrete Cover
     *
     * @return Rectangular Stirrup Offset When Spacing is Less Than Or Equal Mdbstu
     */
    private static double[] getRectangularStirrupsOffsetWhenSpacingLessThanOrEqualMdbstu(int numOfStirrups,
            double numOfBarsAlongDirection, double spacingBetweenBarsAlongDirection,
            double dimensionOfStirAlongDirection, double columnDimensionAlongDirection, double concreteCover,
            double longDiameter) {
        double[] offset = new double[numOfStirrups];

        for (int stirrupIndex = 0; stirrupIndex < numOfStirrups; stirrupIndex++) {
            if (numOfBarsAlongDirection % 2 == 0) {
                if (stirrupIndex < numOfStirrups / 2) {
                    if (numOfBarsAlongDirection == 4) {
                        offset[stirrupIndex] = spacingBetweenBarsAlongDirection + concreteCover;
                    } else {
                        offset[stirrupIndex] = spacingBetweenBarsAlongDirection * (stirrupIndex + 2)
                                + stirrupIndex * dimensionOfStirAlongDirection + concreteCover;
                    }
                } else {
                    offset[stirrupIndex] = columnDimensionAlongDirection - concreteCover
                            - spacingBetweenBarsAlongDirection * ((stirrupIndex - numOfStirrups / 2) + 2)
                            - (stirrupIndex - numOfStirrups / 2 + 1) * dimensionOfStirAlongDirection;
                }
            } else {
                if (stirrupIndex < numOfStirrups / 2) {
                    offset[stirrupIndex] = spacingBetweenBarsAlongDirection * (2 * stirrupIndex + 2)
                            + stirrupIndex * dimensionOfStirAlongDirection + concreteCover;
                } else {
                    offset[stirrupIndex] = columnDimensionAlongDirection - concreteCover
                            - spacingBetweenBarsAlongDirection * (2 * (stirrupIndex - numOfStirrups / 2) + 2)
                            - (stirrupIndex - numOfStirrups / 2 + 1) * dimensionOfStirAlongDirection;
                }
            }
        }

        return offset;
    }

    /**
     * Method that Gets Area Of Bars
     *
     * @param diameter Diameter to be get
     *
     * @return Area Of Bars
     */
    public static double getAreaOfBar(double diameter) {
        return (Math.PI * Math.pow(diameter, 2)) / 4;
    }

    /**
     * Method that Gets Total Length Of Stirrups
     *
     * @param numOfStirrups Number Of Stirrups
     * @param totalPerimOfStirrups Total Perimeter Of Stirrups
     * @param diameterOfStir Diameter Of Stirrups
     *
     * @return Total Length Of Stirrups
     */
    public static double getTotalLengthOfStirrups(int numOfStirrups, double totalPerimOfStirrups,
            double diameterOfStir) {
        return totalPerimOfStirrups + numOfStirrups * 10 * 2 * diameterOfStir;
    }

    /**
     * Method that Gets Total Cost
     *
     * @param stirrupsCost Stirrups Length
     * @param concreteCost Concrete Cost
     * @param spliceCost Splice Cost
     * @param longitudinalBarsCost Longitudinal Bars Cost
     *
     * @return Total Cost
     */
    public static double getTotalCost(double stirrupsCost, double concreteCost, double spliceCost,
            double longitudinalBarsCost) {
        return stirrupsCost + concreteCost + spliceCost + longitudinalBarsCost;
    }

    /**
     * Method that Gets Longitudinal Bars Cost
     *
     * @param numOfBars Number Of Bars
     * @param longitudinalBarsDiameter Longitudinal Bars Diameter
     * @param heightOfFloor Height Of Floor
     * @param longitudinalBarCostPerTon Longitudinal Bars Cost Per Ton
     *
     * @return Longitudinal Bars Cost
     */
    public static double getLongitudinalBarsCost(int numOfBars, double longitudinalBarsDiameter, double heightOfFloor,
            double longitudinalBarCostPerTon) {
        return numOfBars * getAreaOfBar(longitudinalBarsDiameter) * heightOfFloor * 7.851 * longitudinalBarCostPerTon
                * 0.000001;
    }

    /**
     * Method that Gets Stirrups Total Cost
     *
     * @param totalLengthOfStirrups Total length Of Stirrups
     * @param stirrupsDiameter Stirrups Diameter
     * @param heightOfFloor Height Of Floor
     * @param spacingBetweenStirrups Spacing Between Stirrups
     * @param stirrupCostPerTon Stirrup Cost Per Ton
     *
     * @return Stirrups Total Cost
     */
    public static double getStirrupsCost(double totalLengthOfStirrups, double stirrupsDiameter, double heightOfFloor,
            double spacingBetweenStirrups, double stirrupCostPerTon) {
        return totalLengthOfStirrups * getAreaOfBar(stirrupsDiameter)
                * Math.ceil(heightOfFloor * 1000.0 / spacingBetweenStirrups) * 7.851 * stirrupCostPerTon * 0.000000001;
    }

    /**
     * Method that Gets Optimum Column Model Indices
     *
     * @param optFloor Optimum Floor
     * @param numOfCols Number Of Columns
     * @param numOfModels Number Of Models
     * @param reachedSol Reached Solution
     * @param colCost Column Cost
     * @param reachedCost Reached Cost
     * @param optSol Optimum Solution
     *
     * @return Optimum Solution for Optimum Column Model Indices
     */
    public static int[] getOptimumColumnModelIndices(OptimumFloor optFloor, int numOfCols, int numOfModels,
            int[] reachedSol, double[] colCost, double reachedCost, int[] optSol) {
        if (numOfModels == 1) {
            --numOfCols;

            for (int colNum = 0; colNum <= numOfCols; colNum++) {
                reachedSol[colNum] = numOfCols;
                reachedCost += colCost[numOfCols];
            }

            if (reachedCost < optFloor.getColumnsCost()) {
                optFloor.setColumnsCost(reachedCost);
                optSol = reachedSol.clone();
            }
        } else if (numOfCols == numOfModels) {
            --numOfCols;

            for (int colNum = 0; colNum <= numOfCols; colNum++) {
                reachedSol[colNum] = colNum;
                reachedCost += colCost[colNum];
            }

            if (reachedCost < optFloor.getColumnsCost()) {
                optFloor.setColumnsCost(reachedCost);
                optSol = reachedSol.clone();
            }
        } else {
            double tempReachedCost = reachedCost;

            --numOfModels;
            --numOfCols;

            for (int colsNum = numOfModels; colsNum <= numOfCols; colsNum++) {
                reachedCost = tempReachedCost;
                for (int colNum = colsNum; colNum <= numOfCols; colNum++) {
                    reachedSol[colNum] = numOfCols;
                    reachedCost += colCost[numOfCols];
                }

                optSol = getOptimumColumnModelIndices(optFloor, colsNum, numOfModels, reachedSol, colCost, reachedCost,
                        optSol);
            }
        }

        return optSol;
    }

    /**
     * Method that Gets Number Of Different Combinations For Modeling
     *
     * @param numOfCols Number Of Columns
     * @param numOfModels Number Of Models
     *
     * @return Sum Number Of Different Combinations For Modeling
     */
    public static int getNumOfDifferentCombinationsForModelling(int numOfCols, int numOfModels) {
        if (numOfModels == 1 || numOfModels == numOfCols) {
            return 1;
        }

        int sum = 0;
        for (int colsNum = numOfModels - 1; colsNum < numOfCols; colsNum++) {
            sum += getNumOfDifferentCombinationsForModelling(colsNum, numOfModels - 1);
        }

        return sum;
    }

    /**
     * Constructor for Optimizer Class
     */
    private Optimizer() {
    }

    /**
     * Method that enumerate Splice
     *
     */
    public enum Splice {

        /**
         * LAP Splice
         */
        LAP,
        /**
         * COUPLER Splice
         */
        COUPLER,
        /**
         * WELD Splice
         */
        WELD
    }
}



