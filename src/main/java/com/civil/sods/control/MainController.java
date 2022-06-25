package com.civil.sods.control;

import com.civil.sods.gui.InputValuesFrame;
import com.civil.sods.gui.MainFrame;
import com.civil.sods.gui.OutputValuesFrame;
import com.civil.sods.gui.UsedLongDiametersFrame;
import com.civil.sods.gui.UsedStirDiametersFrame;
import com.civil.sods.handle.UiHandler;
import com.civil.sods.handle.Handler;
import static com.civil.sods.handle.Handler.G;
import com.civil.sods.objects.Column;
import com.civil.sods.objects.Costs;
import com.civil.sods.objects.Floor;
import com.civil.sods.optimize.Optimizer.Splice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import com.civil.sods.gui.IValuesFrame;
import com.civil.sods.gui.ModelOutputValuesFrame;
import com.civil.sods.handle.ExportHandler;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 * Main Controller Class
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class MainController {

    private static MainController mainControllerInstance;
    private static final Logger LOG = Logger.getLogger(MainController.class.getName());

    /**
     * Method that Gets Main Controller Instance Using Double Locking instance
     *
     * @return Main Controller Instance
     */
    public static MainController getMainControllerInstanceUsingDoubleLocking() {
        if (mainControllerInstance == null) {
            synchronized (MainController.class) {
                if (mainControllerInstance == null) {
                    mainControllerInstance = new MainController();
                }
            }
        }
        return mainControllerInstance;
    }

    private final UiHandler uIHandler;
    private final Handler handler;
    private final ExportHandler exportHandler;

    /**
     * Constructor for Main Controller Class
     *
     */
    private MainController() {
        this.uIHandler = new UiHandler();
        this.handler = new Handler();
        this.exportHandler = new ExportHandler();
        this.uIHandler.showFrame(this.uIHandler.getMainFrame());
        this.assignMainFrameListeners(this.uIHandler.getMainFrame());
        this.assignInputValuesFrameListeners(this.uIHandler.getInputValuesFrame());
        this.assignOutputValuesFrameListeners(this.uIHandler.getOutputValuesFrame());
        this.assignModelOutputValuesFrameListeners(this.uIHandler.getModelOutputValuesFrame());
        this.assignUsedLongDiameterFrameListeners(this.uIHandler.getUsedLongDiameter());
        this.assignUsedStirDiameterFrameListeners(this.uIHandler.getUsedStirDiameter());
    }

    /**
     * Method that Assign Main Frame Listeners
     *
     * @param mainFrame Main Frame instance
     *
     */
    private void assignMainFrameListeners(MainFrame mainFrame) {
        mainFrame.setSolveButtonActionListener(new SolveListener());
        mainFrame.setForceUnitActionListener(new ForceUnitListener());
        mainFrame.setLengthUnitActionListener(new LengthUnitListener());
        mainFrame.setInputValuesActionListener(new InputValuesListener());
        mainFrame.setUsedLongDiametersActionListener(new UsedLongDiameterListener());
        mainFrame.setUsedStirDiametersActionListener(new UsedStirDiameterListener());
    }

    /**
     * Method that Assign Input Values Frame Listeners
     *
     * @param inputValuesFrame Input Values Frame instance
     *
     */
    private void assignInputValuesFrameListeners(InputValuesFrame inputValuesFrame) {
        inputValuesFrame.setNextFloorTableActionListener(new NextFloorInputValuesTableListener());
        inputValuesFrame.setPreviousFloorTableActionListener(new PreviousFloorInputValuesTableListener());
        inputValuesFrame.setLastFloorTableActionListener(new LastFloorInputValuesTableListener());
        inputValuesFrame.setFirstFloorTableActionListener(new FirstFloorInputValuesTableListener());
    }

    /**
     * Method that Assign Output Values Frame Listeners
     *
     * @param outputValuesFrame Output Values Frame instance
     *
     */
    private void assignOutputValuesFrameListeners(OutputValuesFrame outputValuesFrame) {
        outputValuesFrame.setNextFloorTableActionListener(new NextFloorOutputValuesTableListener());
        outputValuesFrame.setPreviousFloorTableActionListener(new PreviousFloorOutputValuesTableListener());
        outputValuesFrame.setLastFloorTableActionListener(new LastFloorOutputValuesTableListener());
        outputValuesFrame.setFirstFloorTableActionListener(new FirstFloorOutputValuesTableListener());
        outputValuesFrame.setChooseNumOfModelsActionListener(new ChooseNumOfModelsListener());
        outputValuesFrame.setExportDataActionListener(new ExportOutputDataListener());
        outputValuesFrame.setExportDxfActionListener(new ExportOutputDxfListener());
    }

    /**
     * Method that Assign Model Output Values Frame Listeners
     *
     * @param modelOutputValuesFrame Model Output Values Frame instance
     *
     */
    private void assignModelOutputValuesFrameListeners(ModelOutputValuesFrame modelOutputValuesFrame) {
        modelOutputValuesFrame.setNextFloorTableActionListener(new NextFloorModelOutputValuesTableListener());
        modelOutputValuesFrame.setPreviousFloorTableActionListener(new PreviousFloorModelOutputValuesTableListener());
        modelOutputValuesFrame.setLastFloorTableActionListener(new LastFloorModelOutputValuesTableListener());
        modelOutputValuesFrame.setFirstFloorTableActionListener(new FirstFloorModelOutputValuesTableListener());
        modelOutputValuesFrame.setModelSolveActionListener(new ModelSolveListener());
    }

    /**
     * Method that Assign Used Long Diameter Frame Listeners
     *
     * @param usedLongDiameter Used Long Diameter Frame instance
     *
     */
    private void assignUsedLongDiameterFrameListeners(UsedLongDiametersFrame usedLongDiameter) {
        usedLongDiameter.setAddDiameterActionListener(new AddDiameterLongListener());
        usedLongDiameter.setRemoveSelectedActionListener(new RemoveSelectedLongListener());
        usedLongDiameter.setResetDefaultsActionListener(new ResetDefaultsLongListener());
    }

    /**
     * Method that Assign Used Stirrups Diameter Frame Listeners
     *
     * @param usedStirDiameter Used Stirrups Diameter Frame instance
     *
     */
    private void assignUsedStirDiameterFrameListeners(UsedStirDiametersFrame usedStirDiameter) {
        usedStirDiameter.setAddDiameterActionListener(new AddDiameterStirListener());
        usedStirDiameter.setRemoveSelectedActionListener(new RemoveSelectedStirListener());
        usedStirDiameter.setResetDefaultsActionListener(new ResetDefaultsStirListener());
    }

    /**
     * Method that Gets Force Unit
     *
     * @return Force Unit According to the user's choice
     */
    private ForceUnit getForceUnit() {
        String forceUnitSelected = uIHandler.getMainFrame().getjForceUnit().getSelectedItem().toString();
        switch (forceUnitSelected) {
            case "KN":
                return ForceUnit.KILONEWTON;
            case "Ton":
                return ForceUnit.TON;
            case "Kg":
                return ForceUnit.KILOGRAM;
            default:
                return ForceUnit.NEWTON;
        }
    }

    /**
     * Method that Gets Length Unit
     *
     * @return Length Unit According to the user's choice
     */
    private LengthUnit getLengthUnit() {
        String lengthUnitSelected = uIHandler.getMainFrame().getjLengthUnit().getSelectedItem().toString();
        switch (lengthUnitSelected) {
            case "m":
                return LengthUnit.METER;
            case "cm":
                return LengthUnit.CENTIMETER;
            default:
                return LengthUnit.MILLIMETER;
        }
    }

    /**
     * Method that Converts Force Unit According to User's Choice
     *
     * @param from From Unit before converting
     * @param to To the unit the user wants to convert to
     *
     * @return Force Unit After Converting to the users choice
     */
    private double convertForceUnit(ForceUnit from, ForceUnit to) {
        if (null != from) {
            switch (from) {
                case KILOGRAM:
                    if (null == to) {
                        return 1;
                    } else {
                        switch (to) {
                            case NEWTON:
                                return G;
                            case KILONEWTON:
                                return G / 1000;
                            case TON:
                                return 0.001;
                            default:
                                return 1;
                        }
                    }
                case KILONEWTON:
                    if (null == to) {
                        return 1;
                    } else {
                        switch (to) {
                            case NEWTON:
                                return 1000;
                            case KILOGRAM:
                                return 1000 / G;
                            case TON:
                                return 1 / G;
                            default:
                                return 1;
                        }
                    }
                case TON:
                    if (null == to) {
                        return 1;
                    } else {
                        switch (to) {
                            case NEWTON:
                                return 1000 * G;
                            case KILOGRAM:
                                return 1000;
                            case KILONEWTON:
                                return G;
                            default:
                                return 1;
                        }
                    }
                case NEWTON:
                    if (null == to) {
                        return 1;
                    } else {
                        switch (to) {
                            case TON:
                                return 1 / (1000 * G);
                            case KILOGRAM:
                                return 1 / G;
                            case KILONEWTON:
                                return 0.001;
                            default:
                                return 1;
                        }
                    }
                default:
                    break;
            }
        }

        return 1;
    }

    /**
     * Method that Convert Length Unit
     *
     * @param from From Length Unit Before Converting
     * @param to To Length Unit the user wants to convert to
     *
     * @return Length Unit After Converting to the users choice
     */
    private double convertLengthUnit(LengthUnit from, LengthUnit to) {
        if (null != from) {
            switch (from) {
                case METER:
                    if (null == to) {
                        return 1;
                    } else {
                        switch (to) {
                            case CENTIMETER:
                                return 100;
                            case MILLIMETER:
                                return 1000;
                            default:
                                return 1;
                        }
                    }
                case CENTIMETER:
                    if (null == to) {
                        return 1;
                    } else {
                        switch (to) {
                            case METER:
                                return 0.01;
                            case MILLIMETER:
                                return 10;
                            default:
                                return 1;
                        }
                    }
                case MILLIMETER:
                    if (null == to) {
                        return 1;
                    } else {
                        switch (to) {
                            case METER:
                                return 0.001;
                            case CENTIMETER:
                                return 0.01;
                            default:
                                return 1;
                        }
                    }
                default:
                    break;
            }
        }

        return 1;
    }

    /**
     * Method that Copies Input Tables Data TO Floors
     *
     * @param inputTablesData Array of Input Table Data
     *
     */
    private void copyInputTablesDataToFloors(ArrayList<ArrayList<String[]>> inputTablesData) {
        this.handler.getBuilding().removeAllFloors();

        ForceUnit usedForceUnit = this.getForceUnit();
        LengthUnit usedLengthUnit = this.getLengthUnit();
        Floor floor;

        double heightOfFloor = Double.parseDouble(uIHandler.getMainFrame().getjHeightOfFloor().getText())
                * convertLengthUnit(usedLengthUnit, LengthUnit.METER);

        for (ArrayList<String[]> table : inputTablesData) {
            floor = new Floor(heightOfFloor);

            this.handler.getBuilding().addFloor(floor);

            double concreteCover = Double.parseDouble(uIHandler.getMainFrame().getjConcreteCover().getText())
                    * convertLengthUnit(usedLengthUnit, LengthUnit.MILLIMETER);

            for (String[] row : table) {
                this.handler.getBuilding().addColumnToFloor(
                        floor,
                        new Column(
                                Double.parseDouble(row[2]) * convertLengthUnit(usedLengthUnit, LengthUnit.MILLIMETER),
                                Double.parseDouble(row[3]) * convertLengthUnit(usedLengthUnit, LengthUnit.MILLIMETER),
                                Double.parseDouble(row[4]) * convertLengthUnit(usedLengthUnit, LengthUnit.MILLIMETER),
                                Double.parseDouble(row[5]) * convertLengthUnit(usedLengthUnit, LengthUnit.MILLIMETER),
                                Double.parseDouble(row[1]) * convertForceUnit(usedForceUnit, ForceUnit.NEWTON),
                                concreteCover,
                                handler.getMaxAreaOfSteelRatio(row[6])
                        )
                );
            }
        }
    }

    /**
     * Method that Copy Floors To Output Tables Data
     *
     * @param outputTablesData Array of Output Table Data
     *
     */
    private void copyFloorsToOutputTablesData(ArrayList<ArrayList<String[]>> outputTablesData) {
        double convertForceUnitValue = convertForceUnit(ForceUnit.NEWTON, getForceUnit());
        double convertLengthUnitValue = convertLengthUnit(LengthUnit.MILLIMETER, getLengthUnit());

        ArrayList<Floor> floors = handler.getBuilding().getFloors();

        int rowNum = 0;
        String[] row;
        for (Floor floor : floors) {
            ArrayList<String[]> table = new ArrayList<>();
            outputTablesData.add(table);
            ArrayList<Column> columns = floor.getColumns();
            for (Column column : columns) {
                row = new String[8];
                row[0] = Integer.toString(++rowNum);
                row[1] = Double.toString(
                        column.getOptColumn().getWidth() * convertLengthUnitValue
                );
                row[2] = Double.toString(
                        column.getOptColumn().getLength() * convertLengthUnitValue
                );
                row[3] = Double.toString(
                        column.getOptColumn().getCompressiveCapacity() * convertForceUnitValue
                );
                row[4] = Double.toString(
                        column.getOptColumn().getCost()
                );
                row[5] = Double.toString(
                        column.getOptColumn().getReinforcementRatio() * 100
                );
                row[6] = column.getOptLongBars().getNumberOfLongitudinalBars()
                        + " Ø " + (column.getOptLongBars().getDiameter() * convertLengthUnitValue);
                row[7] = column.getOptColumn().getNumOfStirrups()
                        + " Ø " + (column.getOptMainStirLen().getDiameter() * convertLengthUnitValue)
                        + " @ " + (column.getOptColumn().getSpacingBetweenStirrups() * convertLengthUnitValue);
                table.add(row);
            }
        }
    }

    // TODO make use of curtailmentsAfterEachNumOfFloors
    /**
     * Method that Copy Output Table Data To Model Output Tables Data
     *
     * @param floors Array of Floors instances
     * @param modelOutputTablesData Array of Model Output Table Data instances
     * @param outputTablesData Array of Output Table Data instances
     * @param curtailmentsAfterEachNumOfFloors Curtailments After Each Number Of Floors
     *
     */
    private void copyOutputTablesDataToModelOutputTablesData(ArrayList<Floor> floors,
            ArrayList<ArrayList<String[]>> modelOutputTablesData, ArrayList<ArrayList<String[]>> outputTablesData,
            int curtailmentsAfterEachNumOfFloors) {
        ArrayList<String[]> table;
        int numOfTables = outputTablesData.size();
        int numOfModels;
        int rowNum;
        int[] indicesOfModels;

        for (int tableNum = 0; tableNum < numOfTables; tableNum += curtailmentsAfterEachNumOfFloors) {
            table = outputTablesData.get(tableNum);
            rowNum = 0;

            indicesOfModels = floors.get(tableNum).getOptFloor().getModelToColumnIndicesMap();
            numOfModels = indicesOfModels.length;

            ArrayList<String[]> newTable = new ArrayList<>();
            modelOutputTablesData.add(newTable);

            for (int colNum = 0; colNum < numOfModels; colNum++) {
                newTable.add(cloneStringArray(table.get(indicesOfModels[colNum])));
                newTable.get(colNum)[0] = Integer.toString(++rowNum);
            }
        }
    }

    /**
     * Method that Clones String Array
     *
     * @param arr Array Of String to be Clone
     *
     * @return Cloned Array
     */
    private String[] cloneStringArray(String[] arr) {
        int n = arr.length;
        String[] clonedArr = new String[n];

        System.arraycopy(arr, 0, clonedArr, 0, n);

        return clonedArr;
    }

    /**
     * Method that Assign Map To Column Model Map Tables
     *
     * @param floors Array of Floors instances
     * @param columnModelMapTables Array of Column Model Map Tables instances
     * @param curtailmentsAfterEachNumOfFloors Curtailments After Each Number Of Floors
     *
     */
    private void assignMapToColumnModelMapTables(ArrayList<Floor> floors,
            ArrayList<ArrayList<String[]>> columnModelMapTables, int curtailmentsAfterEachNumOfFloors) {
        int numOfTables = floors.size();
        int numOfCols;
        int rowNum;
        int[] indicesOfModels;

        for (int tableNum = 0; tableNum < numOfTables; tableNum += curtailmentsAfterEachNumOfFloors) {
            rowNum = 0;

            indicesOfModels = floors.get(tableNum).getOptFloor().getColumnToModelIndicesMap();
            numOfCols = indicesOfModels.length;

            ArrayList<String[]> newTable = new ArrayList<>();
            columnModelMapTables.add(newTable);

            for (int colNum = 0; colNum < numOfCols; colNum++) {
                newTable.add(new String[]{Integer.toString(++rowNum), Integer.toString(indicesOfModels[colNum] + 1)});
            }
        }
    }

    /**
     * Method that Gets Table Values
     *
     */
    private void getTableValues(ArrayList<String[]> tableData, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int currentNumOfRows = dtm.getRowCount();
        int currentNumOfCols = dtm.getColumnCount();
        String[] row;

        for (int rowNum = 0; rowNum < currentNumOfRows; rowNum++) {
            row = tableData.get(rowNum);
            for (int colNum = 0; colNum < currentNumOfCols; colNum++) {
                try {
                    row[colNum] = dtm.getValueAt(rowNum, colNum).toString();
                } catch (NullPointerException e) {
                    dtm.setValueAt(null, rowNum, colNum);
                }
            }
        }
    }

    private void updateTableValues(ArrayList<String[]> tableData, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int numOfRows = tableData.size();
        int currentNumOfRows = dtm.getRowCount();
        int currentNumOfCols = dtm.getColumnCount();

        // Delete all rows
        for (int rowNum = currentNumOfRows - 1; rowNum >= 0; rowNum--) {
            dtm.removeRow(rowNum);
        }

        // Add all rows
        for (int rowNum = 0; rowNum < numOfRows; rowNum++) {
            dtm.addRow(new String[currentNumOfCols]);
            for (int colNum = 0; colNum < currentNumOfCols; colNum++) {
                if (tableData.get(rowNum)[colNum] != null) {
                    if (dtm.getColumnClass(colNum) == java.lang.Integer.class) {
                        dtm.setValueAt(Integer.parseInt(tableData.get(rowNum)[colNum]), rowNum, colNum);
                    } else if (dtm.getColumnClass(colNum) == java.lang.Double.class) {
                        dtm.setValueAt(Double.parseDouble(tableData.get(rowNum)[colNum]), rowNum, colNum);
                    } else {
                        dtm.setValueAt(tableData.get(rowNum)[colNum], rowNum, colNum);
                    }
                }
            }
        }

        table.setModel(dtm);
    }

    /**
     * Method that Remove All Table Values
     *
     * @param table Table Instance
     *
     */
    private void removeAllTableValues(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int currentNumOfRows = dtm.getRowCount();

        // Delete all rows
        for (int rowNum = currentNumOfRows - 1; rowNum >= 0; rowNum--) {
            dtm.removeRow(rowNum);
        }

        table.setModel(dtm);
    }

    /**
     * Method that Gets Splice Type
     *
     * @return Splice Type According to the user selection
     */
    private Splice getSpliceType() {
        int selected = uIHandler.getMainFrame().getjSpliceType().getSelectedIndex();
        switch (selected) {
            case 0:
                return Splice.LAP;
            case 1:
                return Splice.COUPLER;
            default:
                return Splice.WELD;
        }
    }

    /**
     * Method that Display Error Message That Number Of Floors And Number Of Columns Must Be Positive
     *
     */
    private void errorMessageNumOfFloorsAndNumOfColsInputs() {
        JOptionPane.showMessageDialog(
                uIHandler.getMainFrame(),
                "'Number of floors' and 'Number of columns in each floor' inputs should be positive integers",
                "Inputs error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Method that Checks the Number Of Floors And Number Of Columns Inputs
     *
     * @return True if the Number Of Floors And Number Of Columns Inputs Are Integer Numbers And Greater than or Equal 1
     */
    private boolean checkNumOfFloorsAndNumOfColsInputs() {
        int numOfFloors, numOfCols;
        try {
            numOfFloors = Integer.parseInt(uIHandler.getMainFrame().getjNumOfFloors().getText());
            numOfCols = Integer.parseInt(uIHandler.getMainFrame().getjNumOfColumns().getText());
        } catch (NumberFormatException e) {
            errorMessageNumOfFloorsAndNumOfColsInputs();
            return false;
        }

        if (numOfFloors < 1 || numOfCols < 1) {
            errorMessageNumOfFloorsAndNumOfColsInputs();
            return false;
        }

        return true;
    }

    /**
     * Method that Sets Tables Numbers And Rows
     *
     * @param tablesData Array of String Of Tables Data to be set
     * @param numOfTables Number Of Tables to be set
     * @param numOfRows Number Of Rows to be set
     *
     */
    private void setTablesNumAndRows(ArrayList<ArrayList<String[]>> tablesData, int numOfTables, int numOfRows) {
        int currentNumOfTables = tablesData.size();
        int numOfCols = currentNumOfTables == 0 ? 0 : tablesData.get(0).get(0).length;

        // Will be entered only if currentNumOfTables < numOfTables, so we should add tables
        for (int tableNum = currentNumOfTables; tableNum < numOfTables; tableNum++) {
            tablesData.add(new ArrayList<>());
        }

        // Will be entered only if currentNumOfTables > numOfTables, so we should delete tables
        for (int tableNum = currentNumOfTables - 1; tableNum >= numOfTables; tableNum--) {
            tablesData.remove(tableNum);
        }

        for (ArrayList<String[]> tableData : tablesData) {
            int currentNumOfRows = tableData.size();

            // Will be entered only if currentNumOfRows < numOfRows, so we should add rows,
            // and set "Column No." table column correctly
            for (int rowNum = currentNumOfRows; rowNum < numOfRows; rowNum++) {
                tableData.add(new String[numOfCols]);
                tableData.get(rowNum)[0] = Integer.toString(rowNum + 1);
            }

            // Will be entered only if currentNumOfRows > numOfRows, so we should delete rows
            for (int rowNum = currentNumOfRows - 1; rowNum >= numOfRows; rowNum--) {
                tableData.remove(rowNum);
            }
        }
    }

    /**
     * Method that Sets Buttons Enable
     *
     * @param valuesFrame Values Frame instance
     * @param d Direction instance to be set
     * @param enabled Enabled to be set
     *
     */
    private void setButtonsEnabled(IValuesFrame valuesFrame, Direction d, boolean enabled) {
        if (d == Direction.FORWARD) {
            valuesFrame.getjNextFloorTable().setEnabled(enabled);
            valuesFrame.getjLastFloorTable().setEnabled(enabled);
        } else {
            valuesFrame.getjPreviousFloorTable().setEnabled(enabled);
            valuesFrame.getjFirstFloorTable().setEnabled(enabled);
        }
    }

    /**
     * Method that Sets the Navigate To According to User Choice
     *
     * @param valuesFrame Values Frame Instance
     * @param table Table Instance
     * @param tablesData Table Data Instance
     * @param to To the Destination Of The Navigation
     *
     */
    private void navigateTo(IValuesFrame valuesFrame, JTable table, ArrayList<ArrayList<String[]>> tablesData,
            Navigation to) {
        navigateTo(valuesFrame, table, tablesData, to, false);
    }

    /**
     * Method that Sets the Navigation To Destination
     *
     * @param valuesFrame Values Frame instance
     * @param table Table instance
     * @param tablesData Table Data instance
     * @param to To that determined the Destination Of the Navigation
     * @param refreshTableOnly Refresh Table Only to Refresh the Table in the current Frame Only Without Navigation
     *
     */
    private void navigateTo(IValuesFrame valuesFrame, JTable table, ArrayList<ArrayList<String[]>> tablesData,
            Navigation to, boolean refreshTableOnly) {
        int currentTableNum = Integer.parseInt(valuesFrame.getjFloorTableNum().getText());

        if (!refreshTableOnly) {
            if ((to == Navigation.NEXT || to == Navigation.LAST) && currentTableNum == 1) {
                setButtonsEnabled(valuesFrame, Direction.BACKWARD, true);
            } else if ((to == Navigation.PREVIOUS || to == Navigation.FIRST) && currentTableNum == tablesData.size()) {
                setButtonsEnabled(valuesFrame, Direction.FORWARD, true);
            }
        }

        getTableValues(tablesData.get(currentTableNum - 1), table);

        if (null == to) {
            currentTableNum = 1;
        } else {
            if (!refreshTableOnly) {
                switch (to) {
                    case NEXT:
                        currentTableNum++;
                        break;
                    case LAST:
                        currentTableNum = tablesData.size();
                        break;
                    case PREVIOUS:
                        currentTableNum--;
                        break;
                    default:
                        currentTableNum = 1;
                        break;
                }
            }
        }

        updateTableValues(tablesData.get(currentTableNum - 1), table);

        if (!refreshTableOnly) {
            valuesFrame.getjFloorTableNum().setText(Integer.toString(currentTableNum));

            if (currentTableNum == tablesData.size()) {
                setButtonsEnabled(valuesFrame, Direction.FORWARD, false);
            } else if (currentTableNum == 1) {
                setButtonsEnabled(valuesFrame, Direction.BACKWARD, false);
            }
        }
    }

    /**
     * Method that Refreshes Floor From Model Output
     *
     */
    private void refreshFloorFromToModelOutput() {
        int curtailmentsAfterEachNumOfFloors = Integer.parseInt(
                uIHandler.getModelOutputValuesFrame().getjCurtailmentsAfterEachNumOfFloors().getText()
        );
        int floorNum = Integer.parseInt(uIHandler.getModelOutputValuesFrame().getjFloorTableNum().getText());

        uIHandler.getModelOutputValuesFrame().getjFloorNumFrom().setText(Integer.toString(
                (floorNum - 1) * curtailmentsAfterEachNumOfFloors + 1
        ));
        uIHandler.getModelOutputValuesFrame().getjFloorNumTo().setText(Integer.toString(
                floorNum * curtailmentsAfterEachNumOfFloors
        ));
    }

    /**
     * Method that Enumerates Force Units
     *
     */
    private enum ForceUnit {

        NEWTON, KILONEWTON, TON, KILOGRAM
    }

    /**
     * Method that Enumerates Length Units
     */
    private enum LengthUnit {

        METER, CENTIMETER, MILLIMETER
    }

    /**
     * Method that Enumerates Navigation Directions
     *
     */
    private enum Navigation {

        NEXT, PREVIOUS, LAST, FIRST
    }

    /**
     * Method that Enumerates Directions
     *
     */
    private enum Direction {

        FORWARD, BACKWARD
    }

    /**
     * Class that Solves Listeners
     *
     */
    public class SolveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            forceUnit usedForceUnit = getForceUnit();
            LengthUnit usedLengthUnit = getLengthUnit();

            Costs costs = new Costs(
                    Double.parseDouble(uIHandler.getMainFrame().getjConcreteCostPerTon().getText()),
                    Double.parseDouble(uIHandler.getMainFrame().getjOneSpliceCost().getText()),
                    Double.parseDouble(uIHandler.getMainFrame().getjStirrupCostPerTon().getText()),
                    Double.parseDouble(uIHandler.getMainFrame().getjLongitudinalBarCostPerTon().getText())
            );

            ArrayList<ArrayList<String[]>> inputTablesData = uIHandler.getInputTablesData();

            if (inputTablesData.isEmpty()) {
                JOptionPane.showMessageDialog(
                        uIHandler.getMainFrame(),
                        "First enter columns details\nClick on 'Show/Refresh Input Values Window' button",
                        "Inputs error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            getTableValues(
                    inputTablesData.get(
                            Integer.parseInt(uIHandler.getInputValuesFrame().getjFloorTableNum().getText()) - 1
                    ),
                    uIHandler.getInputValuesFrame().getTable()
            );

            if (!uIHandler.checkInputTablesDataNotNull()) {
                JOptionPane.showMessageDialog(
                        uIHandler.getMainFrame(),
                        "All requested input tables should be completed",
                        "Inputs error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            double min = 200 * convertLengthUnit(LengthUnit.MILLIMETER, usedLengthUnit);
            if (!uIHandler.checkInputTablesMinGreaterThan(min)) {
                JOptionPane.showMessageDialog(
                        uIHandler.getMainFrame(),
                        "Minimum width and minimum length values should be greater than or equal " + min,
                        "Inputs error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (!uIHandler.checkInputTablesMaxGreaterThanMin()) {
                JOptionPane.showMessageDialog(
                        uIHandler.getMainFrame(),
                        "Maximum width and maximum length values should be greater than or equal corresponding "
                        + "\nminimum width and minimum length values",
                        "Inputs error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            copyInputTablesDataToFloors(inputTablesData);

            ArrayList<Double> usedLongitudinalBarDiameters = uIHandler.getUsedLongDiameter().getSelectedDiameters();
            ArrayList<Double> usedStirrupDiameters = uIHandler.getUsedStirDiameter().getSelectedDiameters();

            if (usedLongitudinalBarDiameters.isEmpty() || usedStirrupDiameters.isEmpty()) {
                JOptionPane.showMessageDialog(
                        uIHandler.getMainFrame(),
                        "At least one longitudinal bar diameter and one stirrup diameter should be entered",
                        "Inputs error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            handler.assignOptimizedFloors(
                    handler.getBuilding().getFloors(),
                    // (Double.parseDouble(uIHandler.getMainFrame().getjCharacteristicStrengthOfConcrete().getText())
                    // * convertForceUnit(usedForceUnit, forceUnit.NEWTON))
                    // / Math.pow(convertLengthUnit(usedLengthUnit, lengthUnit.MILLIMETER), 2),
                    Double.parseDouble(uIHandler.getMainFrame().getjCharacteristicStrengthOfConcrete().getText()),
                    // (Double.parseDouble(uIHandler.getMainFrame().getjYieldStrengthOfSteel().getSelectedItem().toString())
                    // * convertForceUnit(usedForceUnit, forceUnit.NEWTON))
                    // / Math.pow(convertLengthUnit(usedLengthUnit, lengthUnit.MILLIMETER), 2),
                    Double.parseDouble(uIHandler.getMainFrame().getjYieldStrengthOfSteel().getSelectedItem().toString()),
                    costs,
                    usedLongitudinalBarDiameters,
                    usedStirrupDiameters,
                    getSpliceType()
            );

            ArrayList<ArrayList<String[]>> outputTablesData = uIHandler.getOutputTablesData();

            setTablesNumAndRows(
                    outputTablesData,
                    0,
                    0
            );

            copyFloorsToOutputTablesData(outputTablesData);

            int floorNum = Integer.parseInt(uIHandler.getOutputValuesFrame().getjFloorTableNum().getText());

            if (floorNum >= inputTablesData.size()) {
                floorNum = inputTablesData.size();
                uIHandler.getOutputValuesFrame().getjFloorTableNum().setText(Integer.toString(floorNum));
                setButtonsEnabled(uIHandler.getOutputValuesFrame(), Direction.FORWARD, false);
            } else {
                setButtonsEnabled(uIHandler.getOutputValuesFrame(), Direction.FORWARD, true);
            }

            if (floorNum == 1) {
                uIHandler.getOutputValuesFrame().getjFloorTableNum().setText(Integer.toString(floorNum));
                setButtonsEnabled(uIHandler.getOutputValuesFrame(), Direction.BACKWARD, false);
            }

            updateTableValues(outputTablesData.get(floorNum - 1), uIHandler.getOutputValuesFrame().getTable());

            String forceUnit = uIHandler.getMainFrame().getjForceUnit().getSelectedItem().toString();
            String lengthUnit = uIHandler.getMainFrame().getjLengthUnit().getSelectedItem().toString();

            TableColumnModel tcm = uIHandler.getOutputValuesFrame().getTable().getColumnModel();
            tcm.getColumn(1).setHeaderValue("Width (" + lengthUnit + ")");
            tcm.getColumn(2).setHeaderValue("Length (" + lengthUnit + ")");
            tcm.getColumn(3).setHeaderValue("Compressive Capacity (" + forceUnit + ")");
            tcm.getColumn(6).setHeaderValue("Longitudinal Bars (" + lengthUnit + ")");
            tcm.getColumn(7).setHeaderValue("Stirrups (" + lengthUnit + ")");
            uIHandler.getOutputValuesFrame().getTable().getTableHeader().repaint();

            uIHandler.showFrame(uIHandler.getOutputValuesFrame());

            // TODO to be removed from here and create appropriate button
//            exportHandler.exportDxf(handler.getBuilding().getFloors().get(0).getColumns().get(0));
//            exportHandler.exportPdf(handler.getBuilding().getFloors());
//            handler.assignModelsInFloor();
        }
    }

    /**
     * Class That Sets Force Unit Listeners
     *
     */
    public class ForceUnitListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String forceUnit = uIHandler.getMainFrame().getjForceUnit().getSelectedItem().toString();
//            StringTokenizer st;
//            st = new StringTokenizer(
//                    uIHandler.getMainFrame().getjCharacteristicStrengthOfConcreteUnit().getText(), "/");
//            uIHandler.getMainFrame().getjCharacteristicStrengthOfConcreteUnit().setText(
//                    uIHandler.getMainFrame().getjCharacteristicStrengthOfConcreteUnit().getText().replace(
//                            st.nextToken(), forceUnit
//                    )
//            );
//            st = new StringTokenizer(
//                    uIHandler.getMainFrame().getjYieldStrengthOfSteelUnit().getText(), "/");
//            uIHandler.getMainFrame().getjYieldStrengthOfSteelUnit().setText(
//                    uIHandler.getMainFrame().getjYieldStrengthOfSteelUnit().getText().replace(
//                            st.nextToken(), forceUnit
//                    )
//            );

            uIHandler.getInputValuesFrame().getTable().getColumnModel().getColumn(1).setHeaderValue(
                    "Load (" + forceUnit + ")"
            );
            uIHandler.getInputValuesFrame().getTable().getTableHeader().repaint();
        }
    }

    /**
     * Class that Sets Length Unit Listeners
     *
     */
    public class LengthUnitListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String lengthUnit = uIHandler.getMainFrame().getjLengthUnit().getSelectedItem().toString();
//            StringTokenizer st;
//            st = new StringTokenizer(
//                    uIHandler.getMainFrame().getjCharacteristicStrengthOfConcreteUnit().getText(), "/");
//            st.nextToken();
//            uIHandler.getMainFrame().getjCharacteristicStrengthOfConcreteUnit().setText(
//                    uIHandler.getMainFrame().getjCharacteristicStrengthOfConcreteUnit().getText().replace(
//                            st.nextToken(),
//                            lengthUnit + "²"
//                    )
//            );
//            st = new StringTokenizer(
//                    uIHandler.getMainFrame().getjYieldStrengthOfSteelUnit().getText(), "/"
//            );
//            st.nextToken();
//            uIHandler.getMainFrame().getjYieldStrengthOfSteelUnit().setText(
//                    uIHandler.getMainFrame().getjYieldStrengthOfSteelUnit().getText().replace(
//                            st.nextToken(),
//                            lengthUnit + "²"
//                    )
//            );
            uIHandler.getMainFrame().getjHeightOfFloorUnit().setText(lengthUnit);
            uIHandler.getMainFrame().getjConcreteCoverUnit().setText(lengthUnit);

            TableColumnModel tcm = uIHandler.getInputValuesFrame().getTable().getColumnModel();
            tcm.getColumn(2).setHeaderValue("Minimum width (" + lengthUnit + ")");
            tcm.getColumn(3).setHeaderValue("Maximum width (" + lengthUnit + ")");
            tcm.getColumn(4).setHeaderValue("Minimum length (" + lengthUnit + ")");
            tcm.getColumn(5).setHeaderValue("Maximum length (" + lengthUnit + ")");
            uIHandler.getInputValuesFrame().getTable().getTableHeader().repaint();
        }
    }

    /**
     * Class that Sets Input Values Listeners
     *
     */
    public class InputValuesListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!checkNumOfFloorsAndNumOfColsInputs()) {
                return;
            }

            ArrayList<ArrayList<String[]>> inputTablesData = uIHandler.getInputTablesData();

            if (inputTablesData.isEmpty()) {
                inputTablesData.add(
                        new ArrayList<>()
                );
                inputTablesData.get(0).add(new String[uIHandler.getInputValuesFrame().getTable().getColumnCount()]);
                inputTablesData.get(0).get(0)[0] = Integer.toString(1);
            }

            int floorNum = Integer.parseInt(uIHandler.getInputValuesFrame().getjFloorTableNum().getText());

            getTableValues(inputTablesData.get(floorNum - 1), uIHandler.getInputValuesFrame().getTable());

            setTablesNumAndRows(
                    inputTablesData,
                    Integer.parseInt(uIHandler.getMainFrame().getjNumOfFloors().getText()),
                    Integer.parseInt(uIHandler.getMainFrame().getjNumOfColumns().getText())
            );

            if (floorNum >= inputTablesData.size()) {
                floorNum = inputTablesData.size();
                uIHandler.getInputValuesFrame().getjFloorTableNum().setText(Integer.toString(floorNum));
                setButtonsEnabled(uIHandler.getInputValuesFrame(), Direction.FORWARD, false);
            } else {
                setButtonsEnabled(uIHandler.getInputValuesFrame(), Direction.FORWARD, true);
            }

            if (floorNum == 1) {
                uIHandler.getInputValuesFrame().getjFloorTableNum().setText(Integer.toString(floorNum));
                setButtonsEnabled(uIHandler.getInputValuesFrame(), Direction.BACKWARD, false);
            }

            updateTableValues(inputTablesData.get(floorNum - 1), uIHandler.getInputValuesFrame().getTable());

            uIHandler.showFrame(uIHandler.getInputValuesFrame());
        }
    }

    /**
     * Class that Sets Choose Number Of Models Listeners
     *
     */
    public class ChooseNumOfModelsListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            uIHandler.getModelOutputValuesFrame().getjFloorTableNum().setText(Integer.toString(0));
            setButtonsEnabled(uIHandler.getModelOutputValuesFrame(), Direction.FORWARD, false);
            setButtonsEnabled(uIHandler.getModelOutputValuesFrame(), Direction.BACKWARD, false);

            removeAllTableValues(uIHandler.getModelOutputValuesFrame().getTable());

            String forceUnit = uIHandler.getMainFrame().getjForceUnit().getSelectedItem().toString();
            String lengthUnit = uIHandler.getMainFrame().getjLengthUnit().getSelectedItem().toString();

            TableColumnModel tcm = uIHandler.getModelOutputValuesFrame().getTable().getColumnModel();
            tcm.getColumn(1).setHeaderValue("Width (" + lengthUnit + ")");
            tcm.getColumn(2).setHeaderValue("Length (" + lengthUnit + ")");
            tcm.getColumn(3).setHeaderValue("Compressive Capacity (" + forceUnit + ")");
            tcm.getColumn(6).setHeaderValue("Longitudinal Bars (" + lengthUnit + ")");
            tcm.getColumn(7).setHeaderValue("Stirrups (" + lengthUnit + ")");
            uIHandler.getModelOutputValuesFrame().getTable().getTableHeader().repaint();

            uIHandler.showFrame(uIHandler.getModelOutputValuesFrame());

            uIHandler.getModelOutputValuesFrame().getjFloorNumFrom().setText(Integer.toString(0));
            uIHandler.getModelOutputValuesFrame().getjFloorNumTo().setText(Integer.toString(0));
        }
    }

    /**
     * Class that sets Model Solve Listeners
     *
     */
    public class ModelSolveListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int curtailmentsAfterEachNumOfFloors = Integer.parseInt(
                    uIHandler.getModelOutputValuesFrame().getjCurtailmentsAfterEachNumOfFloors().getText()
            );
            int numOfModels = Integer.parseInt(
                    uIHandler.getModelOutputValuesFrame().getjNumOfModels().getText()
            );

            ArrayList<ArrayList<String[]>> outputTablesData = uIHandler.getOutputTablesData();
            ArrayList<ArrayList<String[]>> modelOutputTablesData = uIHandler.getModelOutputTablesData();
            ArrayList<ArrayList<String[]>> columnModelMapTables = uIHandler.getColumnModelMapTables();

            setTablesNumAndRows(modelOutputTablesData, 0, 0);
            setTablesNumAndRows(columnModelMapTables, 0, 0);

            handler.assignModelsInFloors(handler.getBuilding().getFloors(), numOfModels);

            copyOutputTablesDataToModelOutputTablesData(
                    handler.getBuilding().getFloors(), modelOutputTablesData, outputTablesData,
                    curtailmentsAfterEachNumOfFloors
            );

            assignMapToColumnModelMapTables(
                    handler.getBuilding().getFloors(), columnModelMapTables, curtailmentsAfterEachNumOfFloors
            );

            int floorNum = Integer.parseInt(uIHandler.getModelOutputValuesFrame().getjFloorTableNum().getText());

            if (floorNum <= 1) {
                floorNum = 1;
                uIHandler.getModelOutputValuesFrame().getjFloorTableNum().setText(Integer.toString(floorNum));
                setButtonsEnabled(uIHandler.getModelOutputValuesFrame(), Direction.BACKWARD, false);
            }

            if (floorNum >= modelOutputTablesData.size()) {
                floorNum = modelOutputTablesData.size();
                uIHandler.getModelOutputValuesFrame().getjFloorTableNum().setText(Integer.toString(floorNum));
                setButtonsEnabled(uIHandler.getModelOutputValuesFrame(), Direction.FORWARD, false);
            } else {
                setButtonsEnabled(uIHandler.getModelOutputValuesFrame(), Direction.FORWARD, true);
            }

            updateTableValues(
                    modelOutputTablesData.get(floorNum - 1), uIHandler.getModelOutputValuesFrame().getTable()
            );
            updateTableValues(
                    columnModelMapTables.get(floorNum - 1),
                    uIHandler.getModelOutputValuesFrame().getColumnModelMapTable()
            );

            refreshFloorFromToModelOutput();
        }
    }

    /**
     * Class that sets Next Floor Input Values Table Listener
     *
     */
    public class NextFloorInputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getInputValuesFrame(),
                    uIHandler.getInputValuesFrame().getTable(),
                    uIHandler.getInputTablesData(),
                    Navigation.NEXT
            );
        }
    }

    /**
     * Class that sets Previous Floor Input Values Table Listener
     *
     */
    public class PreviousFloorInputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getInputValuesFrame(),
                    uIHandler.getInputValuesFrame().getTable(),
                    uIHandler.getInputTablesData(),
                    Navigation.PREVIOUS
            );
        }
    }

    /**
     * Class that sets Last Floor Input Values Table Listener
     *
     */
    public class LastFloorInputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getInputValuesFrame(),
                    uIHandler.getInputValuesFrame().getTable(),
                    uIHandler.getInputTablesData(),
                    Navigation.LAST
            );
        }
    }

    /**
     * Class that sets Last Floor Input Values Table Listener
     *
     */
    public class FirstFloorInputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getInputValuesFrame(),
                    uIHandler.getInputValuesFrame().getTable(),
                    uIHandler.getInputTablesData(),
                    Navigation.FIRST
            );
        }
    }

    /**
     * Class that sets Next Floor Output Values Table Listener
     *
     */
    public class NextFloorOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getOutputValuesFrame(),
                    uIHandler.getOutputValuesFrame().getTable(),
                    uIHandler.getOutputTablesData(),
                    Navigation.NEXT
            );
        }
    }

    /**
     * Class that sets Previous Floor Output Values Table Listener
     *
     */
    public class PreviousFloorOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getOutputValuesFrame(),
                    uIHandler.getOutputValuesFrame().getTable(),
                    uIHandler.getOutputTablesData(),
                    Navigation.PREVIOUS
            );
        }
    }

    /**
     * Class that sets Last Floor Output Values Table Listener
     *
     */
    public class LastFloorOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getOutputValuesFrame(),
                    uIHandler.getOutputValuesFrame().getTable(),
                    uIHandler.getOutputTablesData(),
                    Navigation.LAST
            );
        }
    }

    /**
     * Class that sets First Floor Output Values Table Listener
     *
     */
    public class FirstFloorOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getOutputValuesFrame(),
                    uIHandler.getOutputValuesFrame().getTable(),
                    uIHandler.getOutputTablesData(),
                    Navigation.FIRST
            );
        }
    }

    /**
     * Class that sets Next Floor Model Output Values Table Listener
     *
     */
    public class NextFloorModelOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getTable(),
                    uIHandler.getModelOutputTablesData(),
                    Navigation.NEXT
            );
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getColumnModelMapTable(),
                    uIHandler.getColumnModelMapTables(),
                    Navigation.NEXT,
                    true
            );

            refreshFloorFromToModelOutput();
        }
    }

    /**
     * Class that sets Previous Floor Model Output Values Table Listener
     *
     */
    public class PreviousFloorModelOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event Instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getTable(),
                    uIHandler.getModelOutputTablesData(),
                    Navigation.PREVIOUS
            );
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getColumnModelMapTable(),
                    uIHandler.getColumnModelMapTables(),
                    Navigation.PREVIOUS,
                    true
            );

            refreshFloorFromToModelOutput();
        }
    }

    /**
     * Class that sets Last Floor Model Output Values Table Listener
     *
     */
    public class LastFloorModelOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event Instance
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getTable(),
                    uIHandler.getModelOutputTablesData(),
                    Navigation.LAST
            );
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getColumnModelMapTable(),
                    uIHandler.getColumnModelMapTables(),
                    Navigation.LAST,
                    true
            );

            refreshFloorFromToModelOutput();
        }
    }

    /**
     * Class that sets First Floor Model Output Values Table Listener
     *
     */
    public class FirstFloorModelOutputValuesTableListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event Instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getTable(),
                    uIHandler.getModelOutputTablesData(),
                    Navigation.FIRST
            );
            navigateTo(
                    uIHandler.getModelOutputValuesFrame(),
                    uIHandler.getModelOutputValuesFrame().getColumnModelMapTable(),
                    uIHandler.getColumnModelMapTables(),
                    Navigation.FIRST,
                    true
            );

            refreshFloorFromToModelOutput();
        }
    }

    /**
     * Class that sets Used Long Diameter Listener
     *
     */
    public class UsedLongDiameterListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event Instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            uIHandler.showFrame(uIHandler.getUsedLongDiameter());
        }
    }

    /**
     * Class that sets Used Stirrup Diameter Listener
     *
     */
    public class UsedStirDiameterListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            uIHandler.showFrame(uIHandler.getUsedStirDiameter());
        }
    }

    /**
     * Class that sets Adding Diameter Long Listener
     */
    public class AddDiameterLongListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel dtm = (DefaultTableModel) uIHandler.getUsedLongDiameter().getjDiameterTable().getModel();

            dtm.addRow(new String[1]);

            uIHandler.getUsedLongDiameter().getjDiameterTable().setModel(dtm);
        }
    }

    /**
     * Class that Sets Remove Selected Long Listeners
     *
     */
    public class RemoveSelectedLongListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] selectedRows = uIHandler.getUsedLongDiameter().getjDiameterTable().getSelectedRows();
            DefaultTableModel dtm = (DefaultTableModel) uIHandler.getUsedLongDiameter().getjDiameterTable().getModel();

            for (int rowNum = selectedRows.length - 1; rowNum >= 0; rowNum--) {
                dtm.removeRow(selectedRows[rowNum]);
            }

            uIHandler.getUsedLongDiameter().getjDiameterTable().setModel(dtm);
        }
    }

    /**
     * Class that Reset Defaults Long Listeners
     *
     */
    public class ResetDefaultsLongListener implements ActionListener {

        /**
         * Method that Sets Action Preformed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            uIHandler.getUsedLongDiameter().resetTableDefaultValues();
        }
    }

    /**
     * Class that Sets Add Diameter Stirrup Listener
     *
     */
    public class AddDiameterStirListener implements ActionListener {

        /**
         * Method that Sets Action Performed
         *
         * @param e Event instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel dtm = (DefaultTableModel) uIHandler.getUsedStirDiameter().getjDiameterTable().getModel();

            dtm.addRow(new String[1]);

            uIHandler.getUsedStirDiameter().getjDiameterTable().setModel(dtm);
        }
    }

    /**
     * Class that Sets Remove Selected Stirrup Listener
     *
     */
    public class RemoveSelectedStirListener implements ActionListener {

        /**
         * Method that Sets Action Preformed
         *
         * @param e Event Instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] selectedRows = uIHandler.getUsedStirDiameter().getjDiameterTable().getSelectedRows();
            DefaultTableModel dtm = (DefaultTableModel) uIHandler.getUsedStirDiameter().getjDiameterTable().getModel();

            for (int rowNum = selectedRows.length - 1; rowNum >= 0; rowNum--) {
                dtm.removeRow(selectedRows[rowNum]);
            }

            uIHandler.getUsedStirDiameter().getjDiameterTable().setModel(dtm);
        }
    }

    /**
     * Class that Sets Reset Defaults Stirrup Listener
     *
     */
    public class ResetDefaultsStirListener implements ActionListener {

        /**
         * Method that Sets Action Preformed
         *
         * @param e Event Instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            uIHandler.getUsedStirDiameter().resetTableDefaultValues();
        }
    }

    /**
     * Class that Sets Export Output Data Listener
     *
     */
    public class ExportOutputDataListener implements ActionListener {

        /**
         * Method that Sets Action Preformed
         *
         * @param e Event Instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            exportHandler.exportPdf(handler.getBuilding().getFloors());
        }
    }

    /**
     * Class that Sets Export Output DXF Listener
     *
     */
    public class ExportOutputDxfListener implements ActionListener {

        /**
         * Method that Sets Action Preformed
         *
         * @param e Event Instance
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            // Demonstrate "Save" dialog:
            int rVal = chooser.showSaveDialog(uIHandler.getOutputValuesFrame());
            if (rVal == JFileChooser.APPROVE_OPTION) {
                String message = exportHandler.exportDxf(
                        handler.getBuilding().getFloors(),
                        chooser.getCurrentDirectory().toString(),
                        chooser.getSelectedFile().getName()
                );

                JOptionPane.showMessageDialog(
                        uIHandler.getOutputValuesFrame(),
                        message,
                        "Inforamtion",
                        JOptionPane.INFORMATION_MESSAGE
                );

                System.out.println(chooser.getSelectedFile().getName());
                System.out.println(chooser.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                System.out.println("You pressed cancel");
            }
        }
    }

}
