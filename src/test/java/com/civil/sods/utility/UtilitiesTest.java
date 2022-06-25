/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.utility;

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
public class UtilitiesTest {

    public UtilitiesTest() {
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
     * Test of quickSortWithIndices method, of class Utilities.
     */
    @Test
    public void testQuickSortWithIndices() {
        System.out.println("selectionSortAndReturnSwitchedIndices");
        double[] arr = {100, 200, 300, 400, 500};
        int[] indices = new int[]{0, 1, 2, 3, 4};
        int[] expResult = {0, 1, 2, 3, 4};
        Utilities.quickSortWithIndices(arr, indices);
        assertArrayEquals(expResult, indices);
        double[] expArrResult = new double[]{100, 200, 300, 400, 500};
        assertArrayEquals(expArrResult, arr, 0);

        arr = new double[]{100.0, 500.0, 300.0, 400.5, 200.2};
        indices = new int[]{0, 1, 2, 3, 4};
        expResult = new int[]{0, 4, 2, 3, 1};
        Utilities.quickSortWithIndices(arr, indices);
        assertArrayEquals(expResult, indices);
        expArrResult = new double[]{100.0, 200.2, 300.0, 400.5, 500.0};
        assertArrayEquals(expArrResult, arr, 0);

        arr = new double[]{5000, 4000, 3000, 2000, 1000};
        indices = new int[]{0, 1, 2, 3, 4};
        expResult = new int[]{4, 3, 2, 1, 0};
        Utilities.quickSortWithIndices(arr, indices);
        assertArrayEquals(expResult, indices);
        expArrResult = new double[]{1000, 2000, 3000, 4000, 5000};
        assertArrayEquals(expArrResult, arr, 0);

        arr = new double[]{10, 20, 40, 70, 80, 50, 30};
        indices = new int[]{0, 1, 2, 3, 4, 5, 6};
        expResult = new int[]{0, 1, 6, 2, 5, 3, 4};
        Utilities.quickSortWithIndices(arr, indices);
        assertArrayEquals(expResult, indices);
        expArrResult = new double[]{10, 20, 30, 40, 50, 70, 80};
        assertArrayEquals(expArrResult, arr, 0);

        arr = new double[]{626, 1990, 1442};
        indices = new int[]{0, 1, 2};
        expResult = new int[]{0, 2, 1};
        Utilities.quickSortWithIndices(arr, indices);
        assertArrayEquals(expResult, indices);
        expArrResult = new double[]{626, 1442, 1990};
        assertArrayEquals(expArrResult, arr, 0);
    }

}
