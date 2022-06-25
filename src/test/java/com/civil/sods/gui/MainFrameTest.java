/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
public class MainFrameTest {

    public MainFrameTest() {
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
     * Test of getjConcreteCover method, of class MainFrame.
     */
    @Test
    public void testGetjConcreteCover() {
        System.out.println("getjConcreteCover");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjConcreteCover();
        assertTrue(result != null);
    }

    /**
     * Test of setjConcreteCover method, of class MainFrame.
     */
    @Test
    public void testSetjConcreteCover() {
        System.out.println("setjConcreteCover");
        JTextField jConcreteCover = new JTextField();
        MainFrame instance = new MainFrame();
        instance.setjConcreteCover(jConcreteCover);
        assertTrue(instance.getjConcreteCover() != null);
    }

    /**
     * Test of getjCharacteristicStrengthOfConcrete method, of class MainFrame.
     */
    @Test
    public void testGetjCharacteristicStrengthOfConcrete() {
        System.out.println("getjCharacteristicStrengthOfConcrete");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjCharacteristicStrengthOfConcrete();
        assertTrue(result != null);

    }

    /**
     * Test of setjCharacteristicStrengthOfConcrete method, of class MainFrame.
     */
    @Test
    public void testSetjCharacteristicStrengthOfConcrete() {
        System.out.println("setjCharacteristicStrengthOfConcrete");
        JTextField jCharacteristicStrengthOfConcrete = new JTextField();
        MainFrame instance = new MainFrame();
        instance.setjCharacteristicStrengthOfConcrete(jCharacteristicStrengthOfConcrete);
        assertTrue(instance.getjCharacteristicStrengthOfConcrete() != null);
    }

    /**
     * Test of getjHeightOfFloor method, of class MainFrame.
     */
    @Test
    public void testGetjHeightOfFloor() {
        System.out.println("getjHeightOfFloor");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjHeightOfFloor();
        assertTrue(result != null);
    }

    /**
     * Test of setjHeightOfFloor method, of class MainFrame.
     */
    @Test
    public void testSetjHeightOfFloor() {
        System.out.println("setjHeightOfFloor");
        JTextField jHeightOfFloor = new JTextField();
        MainFrame instance = new MainFrame();
        instance.setjHeightOfFloor(jHeightOfFloor);
        assertTrue(instance.getjHeightOfFloor() != null);
    }

    /**
     * Test of getjOneSpliceCost method, of class MainFrame.
     */
    @Test
    public void testGetjOneSpliceCost() {
        System.out.println("getjOneSpliceCost");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjOneSpliceCost();
        assertTrue(result != null);
    }

    /**
     * Test of setjOneSpliceCost method, of class MainFrame.
     */
    @Test
    public void testSetjOneSpliceCost() {
        System.out.println("setjOneSpliceCost");
        JTextField jOneSpliceCost = new JTextField();
        MainFrame instance = new MainFrame();
        instance.setjOneSpliceCost(jOneSpliceCost);
        assertTrue(instance.getjOneSpliceCost() != null);
    }

    /**
     * Test of getjConcreteCostPerTon method, of class MainFrame.
     */
    @Test
    public void testGetjConcreteCostPerTon() {
        System.out.println("getjConcreteCostPerTon");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjConcreteCostPerTon();
        assertTrue(result != null);
    }

    /**
     * Test of setjConcreteCostPerTon method, of class MainFrame.
     */
    @Test
    public void testSetjConcreteCostPerTon() {
        System.out.println("setjConcreteCostPerTon");
        JTextField jConcreteCostPerTon = new JTextField();
        MainFrame instance = new MainFrame();
        instance.setjConcreteCostPerTon(jConcreteCostPerTon);
        assertTrue(instance.getjConcreteCostPerTon() != null);
    }

    /**
     * Test of getjLongitudinalBarCostPerTon method, of class MainFrame.
     */
    @Test
    public void testGetjLongitudinalBarCostPerTon() {
        System.out.println("getjLongitudinalBarCostPerTon");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjLongitudinalBarCostPerTon();
        assertTrue(result != null);
    }

    /**
     * Test of setjLongitudinalBarCostPerTon method, of class MainFrame.
     */
    @Test
    public void testSetjLongitudinalBarCostPerTon() {
        System.out.println("setjLongitudinalBarCostPerTon");
        JTextField jLongitudinalBarCostPerTon = new JTextField();
        MainFrame instance = new MainFrame();
        instance.setjLongitudinalBarCostPerTon(jLongitudinalBarCostPerTon);
        assertTrue(instance.getjLongitudinalBarCostPerTon() != null);
    }

    /**
     * Test of getjStirrupCostPerTon method, of class MainFrame.
     */
    @Test
    public void testGetjStirrupCostPerTon() {
        System.out.println("getjStirrupCostPerTon");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjStirrupCostPerTon();
        assertTrue(result != null);
    }

    /**
     * Test of setjStirrupCostPerTon method, of class MainFrame.
     */
    @Test
    public void testSetjStirrupCostPerTon() {
        System.out.println("setjStirrupCostPerTon");
        JTextField jStirrupCostPerTon = new JTextField();
        MainFrame instance = new MainFrame();
        instance.setjStirrupCostPerTon(jStirrupCostPerTon);
        assertTrue(instance.getjStirrupCostPerTon() != null);
    }

    /**
     * Test of getjYieldStrengthOfSteel method, of class MainFrame.
     */
    @Test
    public void testGetjYieldStrengthOfSteel() {
        System.out.println("getjYieldStrengthOfSteel");
        MainFrame instance = new MainFrame();
        JComboBox result = instance.getjYieldStrengthOfSteel();
        assertTrue(result != null);
    }

    /**
     * Test of setjYieldStrengthOfSteel method, of class MainFrame.
     */
    @Test
    public void testSetjYieldStrengthOfSteel() {
        System.out.println("setjYieldStrengthOfSteel");
        JComboBox jYieldStrengthOfSteel = new JComboBox();
        MainFrame instance = new MainFrame();
        instance.setjYieldStrengthOfSteel(jYieldStrengthOfSteel);
        assertTrue(instance.getjYieldStrengthOfSteel() != null);
    }

    /**
     * Test of getjCharacteristicStrengthOfConcreteUnit method, of class MainFrame.
     */
    @Test
    public void testGetjCharacteristicStrengthOfConcreteUnit() {
        System.out.println("getjCharacteristicStrengthOfConcreteUnit");
        MainFrame instance = new MainFrame();
        JLabel result = instance.getjCharacteristicStrengthOfConcreteUnit();
        assertTrue(result != null);
    }

    /**
     * Test of setjCharacteristicStrengthOfConcreteUnit method, of class MainFrame.
     */
    @Test
    public void testSetjCharacteristicStrengthOfConcreteUnit() {
        System.out.println("setjCharacteristicStrengthOfConcreteUnit");
        JLabel jCharacteristicStrengthOfConcreteUnit = new JLabel();
        MainFrame instance = new MainFrame();
        instance.setjCharacteristicStrengthOfConcreteUnit(jCharacteristicStrengthOfConcreteUnit);
        assertTrue(instance.getjCharacteristicStrengthOfConcreteUnit() != null);
    }

    /**
     * Test of getjConcreteCostPerTonUnit method, of class MainFrame.
     */
    @Test
    public void testGetjConcreteCostPerTonUnit() {
        System.out.println("getjConcreteCostPerTonUnit");
        MainFrame instance = new MainFrame();
        JLabel result = instance.getjConcreteCostPerTonUnit();
        assertTrue(result != null);
    }

    /**
     * Test of setjConcreteCostPerTonUnit method, of class MainFrame.
     */
    @Test
    public void testSetjConcreteCostPerTonUnit() {
        System.out.println("setjConcreteCostPerTonUnit");
        JLabel jConcreteCostPerTonUnit = new JLabel();
        MainFrame instance = new MainFrame();
        instance.setjConcreteCostPerTonUnit(jConcreteCostPerTonUnit);
        assertTrue(instance.getjConcreteCostPerTonUnit() != null);
    }

    /**
     * Test of getjConcreteCoverUnit method, of class MainFrame.
     */
    @Test
    public void testGetjConcreteCoverUnit() {
        System.out.println("getjConcreteCoverUnit");
        MainFrame instance = new MainFrame();
        JLabel result = instance.getjConcreteCoverUnit();
        assertTrue(result != null);
    }

    /**
     * Test of setjConcreteCoverUnit method, of class MainFrame.
     */
    @Test
    public void testSetjConcreteCoverUnit() {
        System.out.println("setjConcreteCoverUnit");
        JLabel jConcreteCoverUnit = new JLabel();
        MainFrame instance = new MainFrame();
        instance.setjConcreteCoverUnit(jConcreteCoverUnit);
        assertTrue(instance.getjConcreteCoverUnit() != null);
    }

    /**
     * Test of getjHeightOfFloorUnit method, of class MainFrame.
     */
    @Test
    public void testGetjHeightOfFloorUnit() {
        System.out.println("getjHeightOfFloorUnit");
        MainFrame instance = new MainFrame();
        JLabel result = instance.getjHeightOfFloorUnit();
        assertTrue(result != null);
    }

    /**
     * Test of setjHeightOfFloorUnit method, of class MainFrame.
     */
    @Test
    public void testSetjHeightOfFloorUnit() {
        System.out.println("setjHeightOfFloorUnit");
        JLabel jHeightOfFloorUnit = new JLabel();
        MainFrame instance = new MainFrame();
        instance.setjHeightOfFloorUnit(jHeightOfFloorUnit);
        assertTrue(instance.getjHeightOfFloorUnit() != null);
    }

    /**
     * Test of getjYieldStrengthOfSteelUnit method, of class MainFrame.
     */
    @Test
    public void testGetjYieldStrengthOfSteelUnit() {
        System.out.println("getjYieldStrengthOfSteelUnit");
        MainFrame instance = new MainFrame();
        JLabel result = instance.getjYieldStrengthOfSteelUnit();
        assertTrue(result != null);
    }

    /**
     * Test of setjYieldStrengthOfSteelUnit method, of class MainFrame.
     */
    @Test
    public void testSetjYieldStrengthOfSteelUnit() {
        System.out.println("setjYieldStrengthOfSteelUnit");
        JLabel jYieldStrengthOfSteelUnit = new JLabel();
        MainFrame instance = new MainFrame();
        instance.setjYieldStrengthOfSteelUnit(jYieldStrengthOfSteelUnit);
        assertTrue(instance.getjYieldStrengthOfSteelUnit() != null);
    }

    /**
     * Test of getjForceUnit method, of class MainFrame.
     */
    @Test
    public void testGetjForceUnit() {
        System.out.println("getjForceUnit");
        MainFrame instance = new MainFrame();
        JComboBox result = instance.getjForceUnit();
        assertTrue(result != null);
    }

    /**
     * Test of getjLengthUnit method, of class MainFrame.
     */
    @Test
    public void testGetjLengthUnit() {
        System.out.println("getjLengthUnit");
        MainFrame instance = new MainFrame();
        JComboBox result = instance.getjLengthUnit();
        assertTrue(result != null);
    }

    /**
     * Test of getjNumOfColumns method, of class MainFrame.
     */
    @Test
    public void testGetjNumOfColumns() {
        System.out.println("getjNumOfColumns");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjNumOfColumns();
        assertTrue(result != null);
    }

    /**
     * Test of getjNumOfFloors method, of class MainFrame.
     */
    @Test
    public void testGetjNumOfFloors() {
        System.out.println("getjNumOfFloors");
        MainFrame instance = new MainFrame();
        JTextField result = instance.getjNumOfFloors();
        assertTrue(result != null);
    }

    /**
     * Test of getjSpliceType method, of class MainFrame.
     */
    @Test
    public void testGetjSpliceType() {
        System.out.println("getjSpliceType");
        MainFrame instance = new MainFrame();
        JComboBox result = instance.getjSpliceType();
        assertTrue(result != null);
    }

}
