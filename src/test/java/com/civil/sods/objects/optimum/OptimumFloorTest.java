/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.objects.optimum;

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
public class OptimumFloorTest {

    public OptimumFloorTest() {
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
     * Test of getColumnsCost method, of class OptimumFloor.
     */
    @Test
    public void testGetColumnsCost() {
        System.out.println("getColumnsCost");
        OptimumFloor instance = new OptimumFloor();
        instance.setColumnsCost(100.0);
        double expResult = 100.0;
        double result = instance.getColumnsCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setColumnsCost method, of class OptimumFloor.
     */
    @Test
    public void testSetColumnsCost() {
        System.out.println("setColumnsCost");
        double columnsCost = 100.0;
        OptimumFloor instance = new OptimumFloor();
        instance.setColumnsCost(columnsCost);
        double expResult = 100.0;
        assertEquals(expResult, instance.getColumnsCost(), 0.0);
    }

    /**
     * Test of getColumnToColumnModelIndicesMap method, of class OptimumFloor.
     */
    @Test
    public void testGetColumnToColumnModelIndicesMap() {
        System.out.println("getColumnToColumnModelIndicesMap");
        OptimumFloor instance = new OptimumFloor();
        int[] expResult = new int[]{2, 0, 0, 2};
        instance.setColumnToColumnModelIndicesMap(expResult);
        int[] result = instance.getColumnToColumnModelIndicesMap();
        assertArrayEquals(expResult, result);

        expResult = new int[]{1, 1, 1};
        instance.setColumnToColumnModelIndicesMap(expResult);
        result = instance.getColumnToColumnModelIndicesMap();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setColumnToColumnModelIndicesMap method, of class OptimumFloor.
     */
    @Test
    public void testSetColumnToColumnModelIndicesMap() {
        System.out.println("setColumnToColumnModelIndicesMap");
        int[] indicesOfModels = new int[]{2, 0, 0, 2};
        OptimumFloor instance = new OptimumFloor();
        int[] expResult = indicesOfModels;
        instance.setColumnToColumnModelIndicesMap(indicesOfModels);
        int[] result = instance.getColumnToColumnModelIndicesMap();
        assertArrayEquals(expResult, result);

        indicesOfModels = new int[]{1, 1, 1};
        expResult = indicesOfModels;
        instance.setColumnToColumnModelIndicesMap(indicesOfModels);
        result = instance.getColumnToColumnModelIndicesMap();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getModelToColumnIndicesMap method, of class OptimumFloor.
     */
    @Test
    public void testGetModelToColumnIndicesMap() {
        System.out.println("getModelToColumnIndicesMap");
        OptimumFloor instance = new OptimumFloor();
        instance.setColumnToColumnModelIndicesMap(new int[]{1, 1, 1});
        int[] expResult = new int[]{1};
        int[] result = instance.getModelToColumnIndicesMap();
        assertArrayEquals(expResult, result);

        instance.setColumnToColumnModelIndicesMap(new int[]{0, 1, 2});
        expResult = new int[]{0, 1, 2};
        result = instance.getModelToColumnIndicesMap();
        assertArrayEquals(expResult, result);

        instance.setColumnToColumnModelIndicesMap(new int[]{2, 1, 2});
        expResult = new int[]{2, 1};
        result = instance.getModelToColumnIndicesMap();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getColumnToModelIndicesMap method, of class OptimumFloor.
     */
    @Test
    public void testGetColumnToModelIndicesMap() {
        System.out.println("getColumnToModelIndicesMap");
        OptimumFloor instance = new OptimumFloor();
        instance.setColumnToColumnModelIndicesMap(new int[]{1, 1, 1});
        int[] expResult = new int[]{0, 0, 0};
        int[] result = instance.getColumnToModelIndicesMap();
        assertArrayEquals(expResult, result);

        instance.setColumnToColumnModelIndicesMap(new int[]{0, 1, 2});
        expResult = new int[]{0, 1, 2};
        result = instance.getColumnToModelIndicesMap();
        assertArrayEquals(expResult, result);

        instance.setColumnToColumnModelIndicesMap(new int[]{2, 1, 2});
        expResult = new int[]{0, 1, 0};
        result = instance.getColumnToModelIndicesMap();
        assertArrayEquals(expResult, result);

        instance.setColumnToColumnModelIndicesMap(new int[]{0, 1, 1});
        expResult = new int[]{0, 1, 1};
        result = instance.getColumnToModelIndicesMap();
        assertArrayEquals(expResult, result);
    }

}
