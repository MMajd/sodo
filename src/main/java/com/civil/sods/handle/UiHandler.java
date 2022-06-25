package com.civil.sods.handle;

import com.civil.sods.gui.InputValuesFrame;
import com.civil.sods.gui.MainFrame;
import com.civil.sods.gui.ModelOutputValuesFrame;
import com.civil.sods.gui.OutputValuesFrame;
import com.civil.sods.gui.UsedLongDiametersFrame;
import com.civil.sods.gui.UsedStirDiametersFrame;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class UiHandler {

    private MainFrame mainFrame;
    private UsedLongDiametersFrame usedLongDiameter;
    private UsedStirDiametersFrame usedStirDiameter;
    private InputValuesFrame inputValuesFrame;
    private OutputValuesFrame outputValuesFrame;
    private ModelOutputValuesFrame modelOutputValuesFrame;
    private ArrayList<ArrayList<String[]>> inputTablesData;
    private ArrayList<ArrayList<String[]>> outputTablesData;
    private ArrayList<ArrayList<String[]>> modelOutputTablesData;
    private ArrayList<ArrayList<String[]>> columnModelMapTables;

    /**
     * Constructor for UIHandler Class
     *
     */
    public UiHandler() {
        lookAndFeelView();
    }

    /**
     * Method that Gets Input Table Data
     *
     * @return The input Data entered in the Table
     */
    public ArrayList<ArrayList<String[]>> getInputTablesData() {
        if (this.inputTablesData == null) {
            this.inputTablesData = new ArrayList<>();
        }
        return this.inputTablesData;
    }

    /**
     * Method that Gets Output Table Data
     *
     * @return Output Table Data
     */
    public ArrayList<ArrayList<String[]>> getOutputTablesData() {
        if (this.outputTablesData == null) {
            this.outputTablesData = new ArrayList<>();
        }
        return this.outputTablesData;
    }

    /**
     * Method to get Model Output Data Table
     *
     * @return Model Output Data Table
     */
    public ArrayList<ArrayList<String[]>> getModelOutputTablesData() {
        if (this.modelOutputTablesData == null) {
            this.modelOutputTablesData = new ArrayList<>();
        }
        return this.modelOutputTablesData;
    }

    /**
     * Method that Get Column Model Map Tables
     *
     * @return Column Model Map Tables
     */
    public ArrayList<ArrayList<String[]>> getColumnModelMapTables() {
        if (this.columnModelMapTables == null) {
            this.columnModelMapTables = new ArrayList<>();
        }
        return this.columnModelMapTables;
    }

    /**
     * Method that Show Java Frame
     *
     * @param jFrame Java Frame to be set Visible
     *
     */
    public void showFrame(JFrame jFrame) {
        jFrame.setVisible(true);
    }

    /**
     * Method that Hide Java Frame
     *
     * @param jFrame Java Frame to be Hide
     *
     */
    public void hideFrame(JFrame jFrame) {
        jFrame.setVisible(false);
    }

    /**
     * Method to get Main Frame for the Application
     *
     * @return Main Frame of the Application
     */
    public MainFrame getMainFrame() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }

    /**
     * Method that Gets Used Longitudinal Diameter Frame
     *
     * @return Used Longitudinal Diameter Frame
     */
    public UsedLongDiametersFrame getUsedLongDiameter() {
        if (this.usedLongDiameter == null) {
            this.usedLongDiameter = new UsedLongDiametersFrame();
            this.usedLongDiameter.resetTableDefaultValues();
        }
        return this.usedLongDiameter;
    }

    /**
     * Method that Gets Used Stirrup Diameter Frame
     *
     * @return Used Stirrup Diameter Frame
     */
    public UsedStirDiametersFrame getUsedStirDiameter() {
        if (this.usedStirDiameter == null) {
            this.usedStirDiameter = new UsedStirDiametersFrame();
            this.usedStirDiameter.resetTableDefaultValues();
        }
        return this.usedStirDiameter;
    }

    /**
     * Method that gets Input Values Frame
     *
     * @return Input Values Frame
     */
    public InputValuesFrame getInputValuesFrame() {
        if (inputValuesFrame == null) {
            inputValuesFrame = new InputValuesFrame();
        }
        return inputValuesFrame;
    }

    /**
     * Method that Gets Output Values Frame
     *
     * @return Output Values Frame
     */
    public OutputValuesFrame getOutputValuesFrame() {
        if (outputValuesFrame == null) {
            outputValuesFrame = new OutputValuesFrame();
        }
        return outputValuesFrame;
    }

    /**
     * Method that Gets Model Output Values Frame
     *
     * @return Model Output Values Frame
     */
    public ModelOutputValuesFrame getModelOutputValuesFrame() {
        if (modelOutputValuesFrame == null) {
            modelOutputValuesFrame = new ModelOutputValuesFrame();
        }
        return modelOutputValuesFrame;
    }

    /**
     * Method that Checks the Input Table Data is Not Null
     *
     * @return True if the Input Data Table is Not Null
     */
    public boolean checkInputTablesDataNotNull() {
        for (ArrayList<String[]> table : inputTablesData) {
            for (String[] row : table) {
                for (int col = row.length - 1; col >= 0; col--) {
                    if (row[col] == null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Method that Check Input Table Minimum is Greater than minimum value which is 200
     *
     * @param min Minimum value that all minimum inputs must be greater than
     *
     * @return True if all minimum inputs in the input table is Greater than 200
     */
    public boolean checkInputTablesMinGreaterThan(double min) {
        for (ArrayList<String[]> table : inputTablesData) {
            for (String[] row : table) {
                if (Double.parseDouble(row[2]) < min || Double.parseDouble(row[4]) < min) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Method that Checks Maximum inputs is Greater than Minimum inputs in the input table
     *
     * @return True if the Maximum inputs is Greater than Minimum inputs in the input table
     */
    public boolean checkInputTablesMaxGreaterThanMin() {
        for (ArrayList<String[]> table : inputTablesData) {
            for (String[] row : table) {
                if (Double.parseDouble(row[3]) < Double.parseDouble(row[2])
                        || Double.parseDouble(row[4]) < Double.parseDouble(row[4])) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Method that Set the Numbers Look and Feel
     *
     */
    private void lookAndFeelView() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//                String nativeLF = UIManager.getSystemLookAndFeelClassName(); 
//                UIManager.setLookAndFeel(nativeLF);
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if (info.getName().startsWith("Nimbus")) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

}
