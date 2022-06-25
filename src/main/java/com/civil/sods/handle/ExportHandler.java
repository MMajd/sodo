package com.civil.sods.handle;

import com.civil.sods.export.DxfGenerator;
import com.civil.sods.export.ReportWriter;
import com.civil.sods.objects.Column;
import com.civil.sods.objects.Floor;
import static com.civil.sods.utility.Utilities.fixedTo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class that responsible of Handling the Exporting
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 *
 */
public class ExportHandler {

    /**
     * Method that export the Column Details in DXF Data File Format
     *
     * @param floors Array of Floors
     * @param dir Directory of the export file
     * @param fileName File Name of the exported file
     *
     * @return file name and directory
     */
    public String exportDxf(ArrayList<Floor> floors, String dir, String fileName) {
        try {
            FileWriter fw = new FileWriter("info.txt");
            PrintWriter pw = new PrintWriter(fw);

            double[] offset;
            int indexOfStir;
            int numOfStir;
            double dimension;

            pw.println(floors.size());

            for (Floor floor : floors) {
                ArrayList<Column> columns = floor.getColumns();
                pw.println(columns.size());

                for (Column column : columns) {
                    pw.println("w " + column.getOptColumn().getWidth());
                    pw.println("l " + column.getOptColumn().getLength());
                    pw.println("msw " + column.getOptMainStirLen().getDimensionNormalToDirection());
                    pw.println("msl " + column.getOptMainStirLen().getDimensionAlongDirection());
                    pw.println("d " + column.getOptLongBars().getDiameter());
                    pw.println("bw " + column.getOptLongBars().getNumberOfLongitudinalBarsAlongWidth());
                    pw.println("bl " + column.getOptLongBars().getNumberOfLongitudinalBarsAlongLength());

                    if (!column.optSnglStirLenIsNull()) {
                        numOfStir = column.getOptSnglStirLen().getNumberOfStirrups();
                        pw.print("ssl " + numOfStir);
                        offset = column.getOptSnglStirLen().getOffset();
                        if (numOfStir > 0) {
                            for (indexOfStir = 0; indexOfStir < offset.length; indexOfStir++) {
                                pw.print(" " + offset[indexOfStir]);
                            }
                        }
                        pw.println();
                    } else {
                        pw.println("ssl 0");
                    }

                    if (!column.optRectStirLenIsNull()) {
                        numOfStir = column.getOptRectStirLen().getNumberOfStirrups();
                        pw.print("rsl " + numOfStir);
                        offset = column.getOptRectStirLen().getOffset();
                        if (numOfStir > 0) {
                            for (indexOfStir = 0; indexOfStir < offset.length; indexOfStir++) {
                                pw.print(" " + offset[indexOfStir]);
                            }
                        }
                        pw.println();

                        numOfStir = column.getOptRectStirLen().getNumberOfStirrups();
                        pw.print("rl ");
                        dimension = column.getOptRectStirLen().getDimensionAlongDirection();
                        for (indexOfStir = 0; indexOfStir < numOfStir; indexOfStir++) {
                            pw.print(" " + dimension);
                        }
                        pw.println();
                    } else {
                        pw.println("rsl 0");
                    }

                    if (!column.optSnglStirWidIsNull()) {
                        numOfStir = column.getOptSnglStirWid().getNumberOfStirrups();
                        pw.print("ssw " + numOfStir);
                        offset = column.getOptSnglStirWid().getOffset();
                        if (numOfStir > 0) {
                            for (indexOfStir = 0; indexOfStir < offset.length; indexOfStir++) {
                                pw.print(" " + offset[indexOfStir]);
                            }
                        }
                        pw.println();
                    } else {
                        pw.println("ssw 0");
                    }

                    if (!column.optRectStirWidIsNull()) {
                        numOfStir = column.getOptRectStirWid().getNumberOfStirrups();
                        pw.print("rsw " + numOfStir);
                        offset = column.getOptRectStirWid().getOffset();
                        if (numOfStir > 0) {
                            for (indexOfStir = 0; indexOfStir < offset.length; indexOfStir++) {
                                pw.print(" " + offset[indexOfStir]);
                            }
                        }
                        pw.println();

                        numOfStir = column.getOptRectStirWid().getNumberOfStirrups();
                        pw.print("rw ");
                        dimension = column.getOptRectStirWid().getDimensionAlongDirection();
                        for (indexOfStir = 0; indexOfStir < numOfStir; indexOfStir++) {
                            pw.print(" " + dimension);
                        }
                        pw.println();
                    } else {
                        pw.println("rsw 0");
                    }

                    pw.println("t " + column.getOptTrapStirLen().getNumberOfStirrups());
                    pw.println(",");
                }
            }

            pw.close();

            return DxfGenerator.draw("info.txt", dir, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error has encountered during saving process";
        }
    }

    /**
     * Method that Make File Hidden
     *
     * @param file File instance
     */
    public void makeFileHidden(String file) {
        try {
            Path path = Paths.get("", file);
            Boolean hidden = (Boolean) Files.getAttribute(path, "dos:hidden", LinkOption.NOFOLLOW_LINKS);
            if (hidden != null && !hidden) {
                Files.setAttribute(path, "dos:hidden", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
                System.out.println("File is now hidden!");
            }
        } catch (IOException ex) {
            System.err.println("Things went wrong: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Method that Export the Floors Details format
     *
     * @param floors Floors instances
     */
    public void exportPdf(ArrayList<Floor> floors) {
        ReportWriter reportWriter = new ReportWriter();

        int numOfCols = floors.get(0).getColumns().size();
        String[][] columnsTable = new String[floors.size() * numOfCols][ReportWriter.COLUMS_TABLE_HEADERS_NO];
        String[][] mainStirrupTable = new String[floors.size() * numOfCols][ReportWriter.MAIN_STIRRUPS_TABLE_HEADERS_NO];
        String[][] recStirrupsTable = new String[floors.size() * numOfCols * 2][ReportWriter.RECT_STIRRUPS_TABLE_HEADERS_NO];
        String[][] singleStirrupsTable = new String[floors.size() * numOfCols * 2][ReportWriter.SINGLE_STIRRUPS_TABLE_HEADERS_NO];
        String[][] trapStirrupsTable = new String[floors.size() * numOfCols][ReportWriter.TRAP_STIRRUPS_TABLE_HEADERS_NO];

        int floorNum = 0;
        int row = 0;
        int rowLen;
        int rowWid;
        int colNum;

        for (Floor floor : floors) {
            ArrayList<Column> columns = floor.getColumns();
            colNum = 0;

            for (Column column : columns) {
                columnsTable[row][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                columnsTable[row][1] = fixedTo(column.getOptColumn().getWidth(), 2);
                columnsTable[row][2] = fixedTo(column.getOptColumn().getLength(), 2);
                columnsTable[row][3] = fixedTo(column.getOptColumn().getCompressiveCapacity(), 2);
                columnsTable[row][4] = fixedTo(column.getOptColumn().getCost(), 2);
                columnsTable[row][5] = fixedTo(column.getOptColumn().getReinforcementRatio() * 100, 2);
                columnsTable[row][6] = column.getOptLongBars().getNumberOfLongitudinalBars()
                        + " Ø " + fixedTo(column.getOptLongBars().getDiameter(), 2);
                columnsTable[row][7] = column.getOptColumn().getNumOfStirrups()
                        + " Ø " + fixedTo(column.getOptMainStirLen().getDiameter(), 2)
                        + " @ " + fixedTo(column.getOptColumn().getSpacingBetweenStirrups(), 2);

                mainStirrupTable[row][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                // TODO mainStirrupTable[row][1] = Utilities.fixedTo(column.getOptMainStirLen().getCost());
                mainStirrupTable[row][1] = "";
                mainStirrupTable[row][2] = fixedTo(column.getOptMainStirLen().getLength(), 2);
                mainStirrupTable[row][3] = fixedTo(column.getOptMainStirLen().getDiameter(), 2);
                mainStirrupTable[row][4] = fixedTo(column.getOptMainStirLen().getDimensionNormalToDirection(), 2);
                mainStirrupTable[row][5] = fixedTo(column.getOptMainStirLen().getDimensionAlongDirection(), 2);

                rowLen = row * 2;
                rowWid = row * 2 + 1;

                if (column.getOptRectStirLen().getNumberOfStirrups() == 0) {
                    recStirrupsTable[rowLen][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    recStirrupsTable[rowLen][1] = Integer.toString(column.getOptRectStirLen().getNumberOfStirrups());
                    recStirrupsTable[rowLen][2] = "";
                    recStirrupsTable[rowLen][3] = "";
                    recStirrupsTable[rowLen][4] = "";
                    recStirrupsTable[rowLen][5] = "";
                    recStirrupsTable[rowLen][6] = "";
                    recStirrupsTable[rowLen][7] = "Length";
                } else {
                    recStirrupsTable[rowLen][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    recStirrupsTable[rowLen][1] = Integer.toString(column.getOptRectStirLen().getNumberOfStirrups());
                    // TODO recStirrupsTable[rowLen][2] = Utilities.fixedTo(column.getOptRectStirLen().getCost());
                    recStirrupsTable[rowLen][2] = "";
                    recStirrupsTable[rowLen][3] = fixedTo(column.getOptRectStirLen().getLength(), 2);
                    recStirrupsTable[rowLen][4] = fixedTo(column.getOptRectStirLen().getDiameter(), 2);
                    recStirrupsTable[rowLen][5] = fixedTo(column.getOptRectStirLen().getDimensionNormalToDirection(), 2);
                    recStirrupsTable[rowLen][6] = fixedTo(column.getOptRectStirLen().getDimensionAlongDirection(), 2);
                    recStirrupsTable[rowLen][7] = "Length";
                }

                if (column.getOptRectStirWid().getNumberOfStirrups() == 0) {
                    recStirrupsTable[rowWid][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    recStirrupsTable[rowWid][1] = Integer.toString(column.getOptRectStirWid().getNumberOfStirrups());
                    recStirrupsTable[rowWid][2] = "";
                    recStirrupsTable[rowWid][3] = "";
                    recStirrupsTable[rowWid][4] = "";
                    recStirrupsTable[rowWid][5] = "";
                    recStirrupsTable[rowWid][6] = "";
                    recStirrupsTable[rowWid][7] = "Width";
                } else {
                    recStirrupsTable[rowWid][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    recStirrupsTable[rowWid][1] = Integer.toString(column.getOptRectStirWid().getNumberOfStirrups());
                    // TODO recStirrupsTable[rowWid][2] = Utilities.fixedTo(column.getOptRectStirWid().getCost());
                    recStirrupsTable[rowWid][2] = "";
                    recStirrupsTable[rowWid][3] = fixedTo(column.getOptRectStirWid().getLength(), 2);
                    recStirrupsTable[rowWid][4] = fixedTo(column.getOptRectStirWid().getDiameter(), 2);
                    recStirrupsTable[rowWid][5] = fixedTo(column.getOptRectStirWid().getDimensionNormalToDirection(), 2);
                    recStirrupsTable[rowWid][6] = fixedTo(column.getOptRectStirWid().getDimensionAlongDirection(), 2);
                    recStirrupsTable[rowWid][7] = "Width";
                }

                if (column.getOptSnglStirLen().getNumberOfStirrups() == 0) {
                    singleStirrupsTable[rowLen][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    singleStirrupsTable[rowLen][1] = Integer.toString(column.getOptSnglStirLen().getNumberOfStirrups());
                    singleStirrupsTable[rowLen][2] = "";
                    singleStirrupsTable[rowLen][3] = "";
                    singleStirrupsTable[rowLen][4] = "";
                    singleStirrupsTable[rowLen][5] = "";
                    singleStirrupsTable[rowLen][6] = "Length";
                } else {
                    singleStirrupsTable[rowLen][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    singleStirrupsTable[rowLen][1] = Integer.toString(column.getOptSnglStirLen().getNumberOfStirrups());
                    // TODO singleStirrupsTable[rowLen][2] = Utilities.fixedTo(column.getOptSnglStirLen().getCost());
                    singleStirrupsTable[rowLen][2] = "";
                    singleStirrupsTable[rowLen][3] = fixedTo(column.getOptSnglStirLen().getLength(), 2);
                    singleStirrupsTable[rowLen][4] = fixedTo(column.getOptSnglStirLen().getDiameter(), 2);
                    singleStirrupsTable[rowLen][5] = fixedTo(column.getOptSnglStirLen().getDimensionNormalToDirection(), 2);
                    singleStirrupsTable[rowLen][6] = "Length";
                }

                if (column.getOptSnglStirWid().getNumberOfStirrups() == 0) {
                    singleStirrupsTable[rowWid][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    singleStirrupsTable[rowWid][1] = Integer.toString(column.getOptSnglStirWid().getNumberOfStirrups());
                    singleStirrupsTable[rowWid][2] = "";
                    singleStirrupsTable[rowWid][3] = "";
                    singleStirrupsTable[rowWid][4] = "";
                    singleStirrupsTable[rowWid][5] = "";
                    singleStirrupsTable[rowWid][6] = "Width";
                } else {
                    singleStirrupsTable[rowWid][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    singleStirrupsTable[rowWid][1] = Integer.toString(column.getOptSnglStirWid().getNumberOfStirrups());
                    // TODO singleStirrupsTable[rowWid][2] = Utilities.fixedTo(column.getOptSnglStirWid().getCost());
                    singleStirrupsTable[rowWid][2] = "";
                    singleStirrupsTable[rowWid][3] = fixedTo(column.getOptSnglStirWid().getLength(), 2);
                    singleStirrupsTable[rowWid][4] = fixedTo(column.getOptSnglStirWid().getDiameter(), 2);
                    singleStirrupsTable[rowWid][5] = fixedTo(column.getOptSnglStirWid().getDimensionNormalToDirection(), 2);
                    singleStirrupsTable[rowWid][6] = "Width";
                }

                if (column.getOptTrapStirLen().getNumberOfStirrups() == 0) {
                    trapStirrupsTable[row][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    trapStirrupsTable[row][1] = Integer.toString(column.getOptTrapStirLen().getNumberOfStirrups());
                    trapStirrupsTable[row][2] = "";
                    trapStirrupsTable[row][3] = "";
                    trapStirrupsTable[row][4] = "";
                    trapStirrupsTable[row][5] = "";
                    trapStirrupsTable[row][6] = "";
                    trapStirrupsTable[row][7] = "";
                    trapStirrupsTable[row][8] = "";
                } else {
                    trapStirrupsTable[row][0] = "C" + (colNum + 1) + " F" + (floorNum + 1);
                    trapStirrupsTable[row][1] = Integer.toString(column.getOptTrapStirLen().getNumberOfStirrups());
                    // TODO trapStirrupsTable[row][2] = Utilities.fixedTo(column.getOptTrapStirLen().getCost());
                    trapStirrupsTable[row][2] = "";
                    trapStirrupsTable[row][3] = fixedTo(column.getOptTrapStirLen().getLength(), 2);
                    trapStirrupsTable[row][4] = fixedTo(column.getOptTrapStirLen().getDiameter(), 2);
                    trapStirrupsTable[row][5] = fixedTo(column.getOptTrapStirLen().getNominalDimensionAlongDirection(), 2);
                    trapStirrupsTable[row][6] = fixedTo(column.getOptTrapStirLen().getShortDimensionNormalToDirection(), 2);
                    trapStirrupsTable[row][7] = fixedTo(column.getOptTrapStirLen().getLongDimensionNormalToDirection(), 2);
                    trapStirrupsTable[row][8] = fixedTo(column.getOptTrapStirLen().getInclinedDirection(), 2);
                }

                ++row;
                ++colNum;
            }

            ++floorNum;
        }

        reportWriter.setColumnsArray(columnsTable);
        reportWriter.setMainStirrupArray(mainStirrupTable);
        reportWriter.setRectangularStirrupsArray(recStirrupsTable);
        reportWriter.setSingleStirrupsArray(singleStirrupsTable);
        reportWriter.setTrapezoidalStirrypsArray(trapStirrupsTable);

        reportWriter.show();
    }

}
