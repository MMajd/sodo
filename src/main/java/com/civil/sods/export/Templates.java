package com.civil.sods.export;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;
import java.util.*;
import java.text.*;

import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class Templates {

    /**
     * Root Style Builder
     */
    public static final StyleBuilder rootStyle;
    /**
     * Bold Style Builder
     */
    public static final StyleBuilder boldStyle;
    /**
     * Italic Style Builder
     */
    public static final StyleBuilder italicStyle;
    /**
     * Bold Centered Style Builder
     */
    public static final StyleBuilder boldCenteredStyle;
    /**
     * Bold 2 Centered Style Builder
     */
    public static final StyleBuilder bold12CenteredStyle;
    /**
     * Bold 8 Centered Style Builder
     */
    public static final StyleBuilder bold18CenteredStyle;
    /**
     * Bold 2 Centered Style Builder
     */
    public static final StyleBuilder bold22CenteredStyle;
    /**
     * Column Style Builder
     */
    public static final StyleBuilder columnStyle;
    /**
     * Column Title Style Builder
     */
    public static final StyleBuilder columnTitleStyle;
    /**
     * Group Style Builder
     */
    public static final StyleBuilder groupStyle;
    /**
     * Subtotal Style Builder
     */
    public static final StyleBuilder subtotalStyle;

    /**
     * Report Template Builder
     */
    public static final ReportTemplateBuilder reportTemplate;
    /**
     * Currency Type
     */
    public static final CurrencyType currencyType;
    /**
     * Dynamic Reports Components
     */
    public static final ComponentBuilder<?, ?> dynamicReportsComponent;
    /**
     * Footer Component
     */
    public static final ComponentBuilder<?, ?> footerComponent;

    static {
        rootStyle = stl.style().setPadding(2);
        boldStyle = stl.style(rootStyle).bold();
        italicStyle = stl.style(rootStyle).italic();
        boldCenteredStyle = stl.style(boldStyle)
                .setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
        bold12CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(12);
        bold18CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(18);
        bold22CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(22);
        columnStyle = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE);
        columnTitleStyle = stl.style(columnStyle)
                .setBorder(stl.pen1Point())
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setBackgroundColor(Color.LIGHT_GRAY)
                .bold()
                .setFontSize(8);
        groupStyle = stl.style(boldStyle)
                .setHorizontalAlignment(HorizontalAlignment.LEFT);
        subtotalStyle = stl.style(boldStyle)
                .setTopBorder(stl.pen1Point());

        StyleBuilder crosstabGroupStyle = stl.style(columnTitleStyle);
        StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(170, 170, 170));
        StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(140, 140, 140));
        StyleBuilder crosstabCellStyle = stl.style(columnStyle)
                .setBorder(stl.pen1Point());

        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer()
                .setHeadingStyle(0, stl.style(rootStyle).bold());

        reportTemplate = template()
                .setLocale(Locale.ENGLISH)
                .setColumnStyle(columnStyle)
                .setColumnTitleStyle(columnTitleStyle)
                .setGroupStyle(groupStyle)
                .setGroupTitleStyle(groupStyle)
                .setSubtotalStyle(subtotalStyle)
                .highlightDetailEvenRows()
                .crosstabHighlightEvenRows()
                .setCrosstabGroupStyle(crosstabGroupStyle)
                .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
                .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
                .setCrosstabCellStyle(crosstabCellStyle)
                .setTableOfContentsCustomizer(tableOfContentsCustomizer);

        currencyType = new CurrencyType();
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E dd/MM/yyyy 'at' hh:mm:ss a");
        //HyperLinkBuilder link = hyperLink("");
        dynamicReportsComponent
                = cmp.horizontalList(
                        cmp.image(Templates.class.getResource("images/dynamicreports.png")).setFixedDimension(60, 60),
                        cmp.verticalList(
                                cmp.text("SODS Final Report").setStyle(bold22CenteredStyle).setHorizontalAlignment(HorizontalAlignment.LEFT),
                                cmp.text("Date: " + ft.format(dNow)).setStyle(italicStyle)));

        footerComponent = cmp.pageXofY()
                .setStyle(
                        stl.style(boldCenteredStyle)
                        .setTopBorder(stl.pen1Point()));
    }
    /**
     * Creates custom component which is possible to add to any report band component
     * 
     * @param label Label instance
     * 
     * @return custom component which is possible to add to any report band component
     */
    public static ComponentBuilder<?, ?> createTitleComponent(String label) {
        return cmp.horizontalList()
                .add(
                        dynamicReportsComponent,
                        cmp.text(label).setStyle(bold18CenteredStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT))
                .newRow()
                .add(cmp.line())
                .newRow()
                .add(cmp.verticalGap(10));
    }

    /**
     * Method that sets Create Currency Value Formatter
     *
     * @param label Label instance
     *
     * @return Label instance
     */
    public static CurrencyValueFormatter createCurrencyValueFormatter(String label) {
        return new CurrencyValueFormatter(label);
    }

    /**
     * Class that Sets Currency Type
     *
     */
    public static class CurrencyType extends BigDecimalType {

        /**
         * Serial Version UID
         */
        private static final long serialVersionUID = 1L;

        /**
         * Method that Gets Pattern
         *
         * @return Pattern
         */
        @Override
        public String getPattern() {
            return "$ #,###.00";
        }
    }

    /**
     * Class that Sets Currency Value Formatter
     *
     */
    private static class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {

        /**
         * Serial Version UID
         */
        private static final long serialVersionUID = 1L;

        private String label;

        /**
         * Constructor For Currency Value Formatter with parameter
         *
         * @param label Label instance
         *
         */
        public CurrencyValueFormatter(String label) {
            this.label = label;
        }

        /**
         * Method That sets Format
         *
         * @param value Value instance
         * @param reportParameters Report Parameters instances
         *
         * @return the Format
         */
        @Override
        public String format(Number value, ReportParameters reportParameters) {
            return label + currencyType.valueToString(value, reportParameters.getLocale());
        }
    }
}
