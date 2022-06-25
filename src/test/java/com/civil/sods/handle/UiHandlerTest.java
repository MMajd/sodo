/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.handle;

import com.civil.sods.gui.InputValuesFrame;
import com.civil.sods.gui.MainFrame;
import com.civil.sods.gui.ModelOutputValuesFrame;
import com.civil.sods.gui.OutputValuesFrame;
import com.civil.sods.gui.UsedLongDiametersFrame;
import com.civil.sods.gui.UsedStirDiametersFrame;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abdullah Salama
 */
public class UiHandlerTest {

    public UiHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInputTablesData method, of class UiHandler.
     */
    @Test
    public void testGetInputTablesData() {
        System.out.println("getInputTablesData");
        UiHandler instance = new UiHandler();
        ArrayList<ArrayList<String[]>> result = instance.getInputTablesData();
        assertTrue(result != null);
    }

    /**
     * Test of getOutputTablesData method, of class UiHandler.
     */
    @Test
    public void testGetOutputTablesData() {
        System.out.println("getOutputTablesData");
        UiHandler instance = new UiHandler();
        ArrayList<ArrayList<String[]>> result = instance.getOutputTablesData();
        assertTrue(result != null);
    }

    /**
     * Test of showFrame method, of class UiHandler.
     */
    @Test
    public void testShowFrame() {
        System.out.println("showFrame");
        JFrame jFrame = new JFrame();
        UiHandler instance = new UiHandler();
        // JFrame default visibility is false
        instance.showFrame(jFrame);
        assertTrue(jFrame.isVisible());
    }

    /**
     * Test of hideFrame method, of class UiHandler.
     */
    @Test
    public void testHideFrame() {
        System.out.println("hideFrame");
        JFrame jFrame = new JFrame();
        UiHandler instance = new UiHandler();
        jFrame.setVisible(true);
        instance.hideFrame(jFrame);
        assertTrue(!jFrame.isVisible());
    }

    /**
     * Test of getMainFrame method, of class UiHandler.
     */
    @Test
    public void testGetMainFrame() {
        System.out.println("getMainFrame");
        UiHandler instance = new UiHandler();
        MainFrame result = instance.getMainFrame();
        assertTrue(result != null);
    }

    /**
     * Test of getUsedLongDiameter method, of class UiHandler.
     */
    @Test
    public void testGetUsedLongDiameter() {
        System.out.println("getUsedLongDiameter");
        UiHandler instance = new UiHandler();
        UsedLongDiametersFrame result = instance.getUsedLongDiameter();
        assertTrue(result != null);
    }

    /**
     * Test of getUsedStirDiameter method, of class UiHandler.
     */
    @Test
    public void testGetUsedStirDiameter() {
        System.out.println("getUsedStirDiameter");
        UiHandler instance = new UiHandler();
        UsedStirDiametersFrame result = instance.getUsedStirDiameter();
        assertTrue(result != null);
    }

    /**
     * Test of getInputValuesFrame method, of class UiHandler.
     */
    @Test
    public void testGetInputValuesFrame() {
        System.out.println("getInputValuesFrame");
        UiHandler instance = new UiHandler();
        InputValuesFrame result = instance.getInputValuesFrame();
        assertTrue(result != null);
    }

    /**
     * Test of getOutputValuesFrame method, of class UiHandler.
     */
    @Test
    public void testGetOutputValuesFrame() {
        System.out.println("getOutputValuesFrame");
        UiHandler instance = new UiHandler();
        OutputValuesFrame result = instance.getOutputValuesFrame();
        assertTrue(result != null);
    }

    /**
     * Test of getModelOutputTablesData method, of class UiHandler.
     */
    @Test
    public void testGetModelOutputTablesData() {
        System.out.println("getModelOutputTablesData");
        UiHandler instance = new UiHandler();
        ArrayList<ArrayList<String[]>> result = instance.getModelOutputTablesData();
        assertTrue(result != null);
    }

    /**
     * Test of getColumnModelMapTables method, of class UiHandler.
     */
    @Test
    public void testGetColumnModelMapTables() {
        System.out.println("getColumnModelMapTables");
        UiHandler instance = new UiHandler();
        ArrayList<ArrayList<String[]>> result = instance.getColumnModelMapTables();
        assertTrue(result != null);
    }

    /**
     * Test of getModelOutputValuesFrame method, of class UiHandler.
     */
    @Test
    public void testGetModelOutputValuesFrame() {
        System.out.println("getModelOutputValuesFrame");
        UiHandler instance = new UiHandler();
        ModelOutputValuesFrame result = instance.getModelOutputValuesFrame();
        assertTrue(result != null);
    }

}
