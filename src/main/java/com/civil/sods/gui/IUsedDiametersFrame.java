package com.civil.sods.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public interface IUsedDiametersFrame {

    /**
     * Method that Gets Selected Diameters
     *
     * @return
     */
    public ArrayList<Double> getSelectedDiameters();

    /**
     * Method that Resets Table Default Values
     */
    public void resetTableDefaultValues();

    /**
     * Method that Sets Add Diameter Action Listener
     *
     * @param listener Listeners Instance
     *
     */
    public void setAddDiameterActionListener(ActionListener listener);

    /**
     * Method that Sets Remove Selected Action Listeners
     *
     * @param listener Listener Instance
     *
     */
    public void setRemoveSelectedActionListener(ActionListener listener);

    /**
     * Method that Sets Reset Defaults Action Listener
     *
     * @param listener Listener Instance
     */
    public void setResetDefaultsActionListener(ActionListener listener);

    /**
     * Method that Gets Diameter Table
     *
     * @return
     */
    public JTable getjDiameterTable();
}
