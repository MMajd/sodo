package com.civil.sods.gui;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public interface IValuesFrame {

    /**
     * Method that Sets Next Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    public void setNextFloorTableActionListener(ActionListener listener);

    /**
     * Method that Set Previous Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    public void setPreviousFloorTableActionListener(ActionListener listener);

    /**
     * Method that Set Last Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    public void setLastFloorTableActionListener(ActionListener listener);

    /**
     * Method that Set First Floor Table Action Listener
     *
     * @param listener Listener Instance
     *
     */
    public void setFirstFloorTableActionListener(ActionListener listener);

    /**
     * Method that Gets First Floor Table
     *
     * @return
     */
    public JButton getjFirstFloorTable();

    /**
     * Method that Gets Last Floor Table
     *
     * @return
     */
    public JButton getjLastFloorTable();

    /**
     * Method that Gets Next Floor Table
     *
     * @return
     */
    public JButton getjNextFloorTable();

    /**
     * Method that Gets Previous Floor Table
     *
     * @return
     */
    public JButton getjPreviousFloorTable();

    /**
     * Method that Gets Floor Table Number
     *
     * @return
     */
    public JTextField getjFloorTableNum();

    /**
     * Method that Gets Table
     *
     * @return
     */
    public JTable getTable();
}
