package com.civil.sods.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
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
public class InputValuesFrameTest {

    public InputValuesFrameTest() {
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
     * Test of setNextFloorTableActionListener method, of class InputValuesFrame.
     */
    @Test
    public void testSetNextFloorTableActionListener() {
        System.out.println("setNextFloorTableActionListener");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new NullPointerException();
            }
        };
        InputValuesFrame instance = new InputValuesFrame();
        instance.setNextFloorTableActionListener(listener);
        try {
            instance.getjNextFloorTable().doClick();
        } catch (NullPointerException e) {
            assertTrue(true);
            return;
        }
        fail("Failed");
    }

    /**
     * Test of setPreviousFloorTableActionListener method, of class InputValuesFrame.
     */
    @Test
    public void testSetPreviousFloorTableActionListener() {
        System.out.println("setPreviousFloorTableActionListener");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new NullPointerException();
            }
        };
        InputValuesFrame instance = new InputValuesFrame();
        instance.setPreviousFloorTableActionListener(listener);
        try {
            instance.getjPreviousFloorTable().doClick();
        } catch (NullPointerException e) {
            assertTrue(true);
            return;
        }
        fail("Failed");
    }

    /**
     * Test of setLastFloorTableActionListener method, of class InputValuesFrame.
     */
    @Test
    public void testSetLastFloorTableActionListener() {
        System.out.println("setLastFloorTableActionListener");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new NullPointerException();
            }
        };
        InputValuesFrame instance = new InputValuesFrame();
        instance.setLastFloorTableActionListener(listener);
        try {
            instance.getjLastFloorTable().doClick();
        } catch (NullPointerException e) {
            assertTrue(true);
            return;
        }
        fail("Failed");
    }

    /**
     * Test of setFirstFloorTableActionListener method, of class InputValuesFrame.
     */
    @Test
    public void testSetFirstFloorTableActionListener() {
        System.out.println("setFirstFloorTableActionListener");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new NullPointerException();
            }
        };
        InputValuesFrame instance = new InputValuesFrame();
        instance.setFirstFloorTableActionListener(listener);
        try {
            instance.getjFirstFloorTable().doClick();
        } catch (NullPointerException e) {
            assertTrue(true);
            return;
        }
        fail("Failed");
    }

    /**
     * Test of getjFloorTableNum method, of class InputValuesFrame.
     */
    @Test
    public void testGetjFloorTableNum() {
        System.out.println("getjFloorTableNum");
        InputValuesFrame instance = new InputValuesFrame();
        String expResult = "1";
        String result = instance.getjFloorTableNum().getText();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTable method, of class InputValuesFrame.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");
        InputValuesFrame instance = new InputValuesFrame();
        JTable result = instance.getTable();
        assertTrue(result != null);
    }

    /**
     * Test of getjFirstFloorTable method, of class InputValuesFrame.
     */
    @Test
    public void testGetjFirstFloorTable() {
        System.out.println("getjFirstFloorTable");
        InputValuesFrame instance = new InputValuesFrame();
        JButton result = instance.getjFirstFloorTable();
        assertTrue(result != null);
    }

    /**
     * Test of getjLastFloorTable method, of class InputValuesFrame.
     */
    @Test
    public void testGetjLastFloorTable() {
        System.out.println("getjLastFloorTable");
        InputValuesFrame instance = new InputValuesFrame();
        JButton result = instance.getjLastFloorTable();
        assertTrue(result != null);
    }

    /**
     * Test of getjNextFloorTable method, of class InputValuesFrame.
     */
    @Test
    public void testGetjNextFloorTable() {
        System.out.println("getjNextFloorTable");
        InputValuesFrame instance = new InputValuesFrame();
        JButton result = instance.getjNextFloorTable();
        assertTrue(result != null);
    }

    /**
     * Test of getjPreviousFloorTable method, of class InputValuesFrame.
     */
    @Test
    public void testGetjPreviousFloorTable() {
        System.out.println("getjPreviousFloorTable");
        InputValuesFrame instance = new InputValuesFrame();
        JButton result = instance.getjPreviousFloorTable();
        assertTrue(result != null);
    }

}
