/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.optimize;

import com.civil.sods.objects.RectangularStirrups;
import com.civil.sods.objects.SingleStirrups;
import com.civil.sods.objects.TrapezoidalStirrups;
import com.civil.sods.objects.optimum.OptimumFloor;
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
public class OptimizerTest {

    public OptimizerTest() {
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
     * Test of getOptimumColumnModelIndices method, of class Optimizer.
     */
    @Test
    public void testGetOptimumColumnModelIndices() {
        System.out.println("getOptimumColumnModelIndices");
        OptimumFloor optFloor = new OptimumFloor();
        optFloor.setColumnsCost(Double.MAX_VALUE);
        int numOfCols = 5;
        int numOfModels = 3;
        int[] reachedSol = new int[numOfCols];
        double[] colCost = new double[]{100, 200, 300, 400, 500};
        double reachedCost = 0.0;
        int[] optSol = new int[numOfCols];
        int[] expResult = new int[]{0, 2, 2, 4, 4};
        int[] result = Optimizer.getOptimumColumnModelIndices(
                optFloor, numOfCols, numOfModels, reachedSol, colCost, reachedCost, optSol
        );
        assertArrayEquals(expResult, result);
        assertEquals(1700, optFloor.getColumnsCost(), 0);

        optFloor.setColumnsCost(Double.MAX_VALUE);
        numOfCols = 3;
        numOfModels = 1;
        reachedSol = new int[numOfCols];
        colCost = new double[]{626, 1442, 1990};
        reachedCost = 0.0;
        optSol = new int[numOfCols];
        expResult = new int[]{2, 2, 2};
        result = Optimizer.getOptimumColumnModelIndices(
                optFloor, numOfCols, numOfModels, reachedSol, colCost, reachedCost, optSol
        );
        assertArrayEquals(expResult, result);
        assertEquals(5970, optFloor.getColumnsCost(), 0);

        optFloor.setColumnsCost(Double.MAX_VALUE);
        numOfCols = 3;
        numOfModels = 2;
        reachedSol = new int[numOfCols];
        colCost = new double[]{626, 1442, 1990};
        reachedCost = 0.0;
        optSol = new int[numOfCols];
        expResult = new int[]{0, 2, 2};
        result = Optimizer.getOptimumColumnModelIndices(
                optFloor, numOfCols, numOfModels, reachedSol, colCost, reachedCost, optSol
        );
        assertArrayEquals(expResult, result);
        assertEquals(4606, optFloor.getColumnsCost(), 0);

        optFloor.setColumnsCost(Double.MAX_VALUE);
        numOfCols = 3;
        numOfModels = 3;
        reachedSol = new int[numOfCols];
        colCost = new double[]{626, 1442, 1990};
        reachedCost = 0.0;
        optSol = new int[numOfCols];
        expResult = new int[]{0, 1, 2};
        result = Optimizer.getOptimumColumnModelIndices(
                optFloor, numOfCols, numOfModels, reachedSol, colCost, reachedCost, optSol
        );
        assertArrayEquals(expResult, result);
        assertEquals(4058, optFloor.getColumnsCost(), 0);
    }

}
