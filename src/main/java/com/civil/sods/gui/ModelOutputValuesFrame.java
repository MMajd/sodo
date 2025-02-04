package com.civil.sods.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class ModelOutputValuesFrame extends javax.swing.JFrame implements IValuesFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form MainFrame
     */
    public ModelOutputValuesFrame() {
        initComponents();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - this.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - this.getHeight() / 2);
        this.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jFloorNumFrom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFloorNumTo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCurtailmentsAfterEachNumOfFloors = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNumOfModels = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jColumnModelMapTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLastFloorTable = new javax.swing.JButton();
        jNextFloorTable = new javax.swing.JButton();
        jFloorTableNum = new javax.swing.JTextField();
        jPreviousFloorTable = new javax.swing.JButton();
        jFirstFloorTable = new javax.swing.JButton();
        jModelSolve = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setTitle("Output Model Values");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(35, 86, 157));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ubuntu Condensed", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modeling Input and Output  ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 50));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 30, 590));

        jPanel5.setBackground(new java.awt.Color(35, 86, 157));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 950, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel4.setText("From Floor");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        jFloorNumFrom.setEditable(false);
        jFloorNumFrom.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jFloorNumFrom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFloorNumFrom.setText("1");
        jPanel4.add(jFloorNumFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 5, 50, 30));

        jLabel8.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel8.setText("To Floor");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 60, 40));

        jFloorNumTo.setEditable(false);
        jFloorNumTo.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jFloorNumTo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFloorNumTo.setText("1");
        jPanel4.add(jFloorNumTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 5, 50, 30));

        jLabel6.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel6.setText("Curtailments After Each");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 170, 40));

        jCurtailmentsAfterEachNumOfFloors.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jCurtailmentsAfterEachNumOfFloors.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jCurtailmentsAfterEachNumOfFloors.setText("1");
        jPanel4.add(jCurtailmentsAfterEachNumOfFloors, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 5, 50, 30));

        jLabel7.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel7.setText("  Floors/s");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 60, 40));

        jLabel5.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel5.setText("Number of Models");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 130, 40));

        jNumOfModels.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jNumOfModels.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jNumOfModels.setText("1");
        jPanel4.add(jNumOfModels, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 5, 50, 30));

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 790, 40));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Model No.", "Width(mm)", "Length(mm)", "Compressive Capacity (N)", "Cost", "Reinforce. Ratio(%)", "Longitudinal Bars(mm)", "Stirrups(mm)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 860, 180));

        jColumnModelMapTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Column No.", "Model No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jColumnModelMapTable);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 860, 180));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel3.setText("Floor");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 40, 30));

        jLastFloorTable.setText("»");
        jPanel7.add(jLastFloorTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 50, 30));

        jNextFloorTable.setText("›");
        jPanel7.add(jNextFloorTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 50, 30));

        jFloorTableNum.setEditable(false);
        jFloorTableNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFloorTableNum.setText("1");
        jPanel7.add(jFloorTableNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 30));

        jPreviousFloorTable.setText("‹");
        jPanel7.add(jPreviousFloorTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 50, 30));

        jFirstFloorTable.setText("«");
        jPanel7.add(jFirstFloorTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 30));

        jModelSolve.setText("Solve");
        jPanel7.add(jModelSolve, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 150, 30));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 790, 50));

        jPanel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Insert Each Model Details");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 20));

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 890, 20));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 880, 540));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method that Sets Next Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    @Override
    public void setNextFloorTableActionListener(ActionListener listener) {
        jNextFloorTable.addActionListener(listener);
    }

    /**
     * Method that Sets Previous Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    @Override
    public void setPreviousFloorTableActionListener(ActionListener listener) {
        jPreviousFloorTable.addActionListener(listener);
    }

    /**
     * Method that Sets Last Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    @Override
    public void setLastFloorTableActionListener(ActionListener listener) {
        jLastFloorTable.addActionListener(listener);
    }

    /**
     * Method that Sets First Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    @Override
    public void setFirstFloorTableActionListener(ActionListener listener) {
        jFirstFloorTable.addActionListener(listener);
    }

    /**
     * Method that Sets Model Solve Action Listener
     *
     * @param listener Listener Instance
     *
     */
    public void setModelSolveActionListener(ActionListener listener) {
        jModelSolve.addActionListener(listener);
    }

    /**
     * Method that Gets Floor Table Number
     *
     * @return Floor Table Number
     */
    @Override
    public JTextField getjFloorTableNum() {
        return jFloorTableNum;
    }

    /**
     * Method that Gets Table
     *
     * @return Table
     */
    @Override
    public JTable getTable() {
        return jTable2;
    }

    /**
     * Method that Gets First Floor Table
     *
     * @return First Floor Table
     */
    @Override
    public JButton getjFirstFloorTable() {
        return jFirstFloorTable;
    }

    /**
     * Method that Gets Last Floor Table
     *
     * @return Last Floor Table
     */
    @Override
    public JButton getjLastFloorTable() {
        return jLastFloorTable;
    }

    /**
     * Method that Gets Next Floor Table
     *
     * @return Next Floor Table
     */
    @Override
    public JButton getjNextFloorTable() {
        return jNextFloorTable;
    }

    /**
     * Method that Gets Previous Floor Table
     *
     * @return Previous Floor Table
     */
    @Override
    public JButton getjPreviousFloorTable() {
        return jPreviousFloorTable;
    }

    /**
     * Method that Gets Curtialments After Each Number Of Floors
     *
     * @return Curtialments After Each Number Of Floors
     */
    public JTextField getjCurtailmentsAfterEachNumOfFloors() {
        return jCurtailmentsAfterEachNumOfFloors;
    }

    /**
     * Method that Gets Number Of Models
     *
     * @return Number Of Models
     */
    public JTextField getjNumOfModels() {
        return jNumOfModels;
    }

    /**
     * Method that Gets Floor Number Form
     *
     * @return Floor Number Form
     */
    public JTextField getjFloorNumFrom() {
        return jFloorNumFrom;
    }

    /**
     * Method that Gets Floor Number To
     *
     * @return Floor Number To
     */
    public JTextField getjFloorNumTo() {
        return jFloorNumTo;
    }

    /**
     * Method that Gets Column Model Map Table
     *
     * @return Column Model Map Table
     */
    public JTable getColumnModelMapTable() {
        return jColumnModelMapTable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jColumnModelMapTable;
    private javax.swing.JTextField jCurtailmentsAfterEachNumOfFloors;
    private javax.swing.JButton jFirstFloorTable;
    private javax.swing.JTextField jFloorNumFrom;
    private javax.swing.JTextField jFloorNumTo;
    private javax.swing.JTextField jFloorTableNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLastFloorTable;
    private javax.swing.JButton jModelSolve;
    private javax.swing.JButton jNextFloorTable;
    private javax.swing.JTextField jNumOfModels;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jPreviousFloorTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}
