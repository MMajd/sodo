package com.civil.sods.export;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

/**
 * Class that is Responsible of the Report Writer for PDF Format
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class ReportWriter {

    //tables set up 
    /**
     * Number Of Tables
     */
    private final static int NO_OF_TABLES = 5;
    /**
     * Column Table Headers Number
     */
    public final static int COLUMS_TABLE_HEADERS_NO = 8;
    /**
     * Main Stirrups Table Headers Number
     */
    public final static int MAIN_STIRRUPS_TABLE_HEADERS_NO = 6;
    /**
     * Rectangular Stirrups Table Headers Number
     */
    public final static int RECT_STIRRUPS_TABLE_HEADERS_NO = 8;
    /**
     * Single Stirrups Table Headers Number
     */
    public final static int SINGLE_STIRRUPS_TABLE_HEADERS_NO = 7;
    /**
     * Trapezoidal Stirrups Table Headers Number
     */
    public final static int TRAP_STIRRUPS_TABLE_HEADERS_NO = 9;

    String[] tables = {"Optimal Columns Table", "Main Stirrup Table", "Rectangular Stirrups Along Length and Width Table",
        "Single Stirrups Along Length and Width Table", "Trapezoidal Stirrups Along Length Table"};

    /**
     * this array contains number of columns in each table order of tables is: columns, main stirrups, rectangle
     * stirrups, single stirrups, trapezoidal stirrups e.g: columns table have 8 headers/columns per one row
     */
    int[] columnsNo = {
        COLUMS_TABLE_HEADERS_NO, MAIN_STIRRUPS_TABLE_HEADERS_NO, RECT_STIRRUPS_TABLE_HEADERS_NO,
        SINGLE_STIRRUPS_TABLE_HEADERS_NO, TRAP_STIRRUPS_TABLE_HEADERS_NO
    };

    String[] columnsTable = {"Column No.", "Width(mm)", "Length(mm)", "Compressive Capacity(N)", "Cost($)",
        "Reinforcement Ratio(%)", "Longitudinal Bars(mm)", "Stirrups(mm)"};

    String[] mainStirrupTable = {"Column No.", "Cost", "Length", "Diameter",
        "Dim. Normal To Direction", "Dim. Along Direction"};

    String[] recStirrupsTable = {"Column No.", "No. Of Stirrups", "Cost", "Length", "Diameter",
        "Dim. Normal To Direction", "Dim. Along Direction", "Along"};

    String[] singleStirrupsTable = {"Column No.", "No. Of Stirrups", "Cost", "Length", "Diameter",
        "Dim. Normal To Direction", "Along"};

    String[] trapStirrupsTable = {"Column No.", "No. Of Stirrups", "Cost", "Length", "Diameter",
        "Nominal Dim. Along Direction", "Short Dim. Normal to Direction", "Long Dim. Normal to Direction",
        "Inclined Direction"};

    // Columns title in each table
    String[][] initialTables = {
        columnsTable, mainStirrupTable, recStirrupsTable, singleStirrupsTable, trapStirrupsTable
    };

    // arrays of data
    String columns[][];
    String rectStirrups[][];
    String singleStirrups[][];
    String trapStirrups[][];
    String mainStirrups[][];

    Object allArrays[][][];

    /**
     * Constructor For Report Writer
     *
     */
    public ReportWriter() {

        columns = new String[0][0];
        rectStirrups = new String[0][0];
        singleStirrups = new String[0][0];
        trapStirrups = new String[0][0];
        mainStirrups = new String[0][0];
        allArrays = new Object[0][0][0];
    }

    /**
     * Method that Shows the Display Of PDF
     *
     */
    public void show() {
        Object all[][][] = {columns, mainStirrups, rectStirrups, singleStirrups, trapStirrups};
        allArrays = all;
        build();
    }

    /**
     * Method that Sets Build in PDF Report
     *
     */
    private void build() {
        SubreportBuilder subreport = cmp.subreport(new SubreportExpression())
                .setDataSource(new SubreportDataSourceExpression());

        try {
            report()
                    .title(Templates.createTitleComponent(""))
                    .detail(
                            subreport,
                            cmp.verticalGap(20))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show(false);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class that Sets Sub Report Expression
     *
     */
    private class SubreportExpression extends AbstractSimpleExpression<JasperReportBuilder> {

        private static final long serialVersionUID = 1L;

        /**
         * Method that sets Evaluate
         *
         * @param reportParameters Report Parameters instance
         *
         * @return Report instance
         */
        @Override
        public JasperReportBuilder evaluate(ReportParameters reportParameters) {
            // masterRowNumber from range of 1 to number of tables
            int masterRowNumber = reportParameters.getReportRowNumber();

            JasperReportBuilder report = report();
            report
                    .setTemplate(Templates.reportTemplate)
                    .title(cmp.text(tables[masterRowNumber - 1]).setStyle(Templates.bold12CenteredStyle));

            for (int i = 0; i < columnsNo[masterRowNumber - 1]; i++) {
                report.addColumn(col.column(initialTables[masterRowNumber - 1][i], "column" + i, type.stringType()));
            }

            return report;
        }
    }

    /**
     * Class that Sets SubReport Data Source Expression
     *
     */
    private class SubreportDataSourceExpression extends AbstractSimpleExpression<JRDataSource> {

        private static final long serialVersionUID = 1L;

        /**
         * Method that Sets Evaluate
         *
         * @param reportParameters Report Parameters instance
         *
         * @return Data Source instance
         */
        @Override
        public JRDataSource evaluate(ReportParameters reportParameters) {
            //this number equal the number of tables we work one, equals NO_OF_TABLES 
            int masterRowNumber = reportParameters.getReportRowNumber();
            //String array to contain columns names 
            String[] columns = new String[columnsNo[masterRowNumber - 1]];

            for (int i = 0; i < columnsNo[masterRowNumber - 1]; i++) {
                columns[i] = "column" + i;
            }
            // names of columns of each table 
            DRDataSource dataSource = new DRDataSource(columns);

            // i for takes no of rows to be prinited
            // j for takes each column value to fill one row
            for (Object[] allArray : allArrays[masterRowNumber - 1]) {
                Object[] values = new Object[columnsNo[masterRowNumber - 1]];
                System.arraycopy(allArray, 0, values, 0, columnsNo[masterRowNumber - 1]);
                dataSource.add(values);
            }

            return dataSource;
        }
    }

    /**
     * Method that Creates Data Source
     *
     * @return Number Of Tables
     */
    private JRDataSource createDataSource() {
        return new JREmptyDataSource(NO_OF_TABLES);
    }

    /**
     * Method that Sets Column Array
     *
     * @param columns Columns Array Of String
     *
     */
    public void setColumnsArray(String[][] columns) {
        this.columns = columns;
    }

    /**
     * Method that Sets Rectangular Stirrups Array
     *
     * @param rectStirrups Rectangular Stirrups Array Of String
     *
     */
    public void setRectangularStirrupsArray(String[][] rectStirrups) {
        this.rectStirrups = rectStirrups;
    }

    /**
     * Method that Sets Trapezoidal Stirrups Array
     *
     * @param trapStirrups Trapezoidal Stirrups Array Of String
     *
     */
    public void setTrapezoidalStirrypsArray(String[][] trapStirrups) {
        this.trapStirrups = trapStirrups;
    }

    /**
     * Method that Sets Single Stirrups Array
     *
     * @param singleStirrups Single Stirrups Array Of String
     *
     */
    public void setSingleStirrupsArray(String[][] singleStirrups) {
        this.singleStirrups = singleStirrups;
    }

    /**
     * Method that Sets Main Stirrups Array
     *
     * @param mainStirrups Main Stirrups Array Of String
     *
     */
    public void setMainStirrupArray(String[][] mainStirrups) {
        this.mainStirrups = mainStirrups;
    }
}
