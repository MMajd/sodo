/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.handle;

import com.civil.sods.objects.Building;
import com.civil.sods.objects.Column;
import com.civil.sods.objects.Costs;
import com.civil.sods.objects.Floor;
import com.civil.sods.optimize.Optimizer;
import java.util.ArrayList;
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
public class HandlerTest {

    public HandlerTest() {
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
     * Test of getMaxAreaOfSteelRatio method, of class Handler.
     */
    @Test
    public void testGetMaxAreaOfSteelRatio() {
        System.out.println("getMaxAreaOfSteelRatio");
        String columnLocation = "Interior";
        Handler instance = new Handler();
        double expResult = 0.04;
        double result = instance.getMaxAreaOfSteelRatio(columnLocation);
        assertEquals(expResult, result, 0.0);

        columnLocation = "Exterior";
        expResult = 0.05;
        result = instance.getMaxAreaOfSteelRatio(columnLocation);
        assertEquals(expResult, result, 0.0);

        columnLocation = "Corner";
        expResult = 0.06;
        result = instance.getMaxAreaOfSteelRatio(columnLocation);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getBuilding method, of class Handler.
     */
    @Test
    public void testGetBuilding() {
        System.out.println("getBuilding");
        Handler instance = new Handler();
        Building expResult = new Building();
        instance.setBuilding(expResult);
        Building result = instance.getBuilding();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBuilding method, of class Handler.
     */
    @Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        Building building = new Building();
        Handler instance = new Handler();
        instance.setBuilding(building);
        assertEquals(building, instance.getBuilding());
    }

    /**
     * Test of assignModelsInFloor method, of class Handler.
     */
    @Test
    public void testAssignModelsInFloor() {
        System.out.println("assignModelsInFloor");

        Floor floor = new Floor();
        floor.getOptFloor().setColumnsCost(Double.MAX_VALUE);

        floor.addColumn(new Column());
        floor.getColumns().get(0).getOptColumn().setCost(100);
        floor.addColumn(new Column());
        floor.getColumns().get(1).getOptColumn().setCost(200);
        floor.addColumn(new Column());
        floor.getColumns().get(2).getOptColumn().setCost(300);
        floor.addColumn(new Column());
        floor.getColumns().get(3).getOptColumn().setCost(400);
        floor.addColumn(new Column());
        floor.getColumns().get(4).getOptColumn().setCost(500);

        int numOfmodels = 3;
        Handler instance = new Handler();
        instance.assignModelsInFloor(floor, numOfmodels);

        int[] expResult = new int[]{0, 2, 2, 4, 4};
        int[] result = floor.getOptFloor().getColumnToColumnModelIndicesMap();
        assertArrayEquals(expResult, result);
        assertEquals(1700, floor.getOptFloor().getColumnsCost(), 0);
        assertArrayEquals(new int[]{0, 2, 4}, floor.getOptFloor().getModelToColumnIndicesMap());
        assertArrayEquals(new int[]{0, 1, 1, 2, 2}, floor.getOptFloor().getColumnToModelIndicesMap());

        // another test case
        floor = new Floor();
        floor.getOptFloor().setColumnsCost(Double.MAX_VALUE);

        floor.addColumn(new Column());
        floor.getColumns().get(0).getOptColumn().setCost(626);
        floor.addColumn(new Column());
        floor.getColumns().get(1).getOptColumn().setCost(1990);
        floor.addColumn(new Column());
        floor.getColumns().get(2).getOptColumn().setCost(1442);

        numOfmodels = 1;
        instance.assignModelsInFloor(floor, numOfmodels);

        expResult = new int[]{1, 1, 1};
        result = floor.getOptFloor().getColumnToColumnModelIndicesMap();
        assertArrayEquals(expResult, result);
        assertEquals(5970, floor.getOptFloor().getColumnsCost(), 0);
        assertArrayEquals(new int[]{1}, floor.getOptFloor().getModelToColumnIndicesMap());
        assertArrayEquals(new int[]{0, 0, 0}, floor.getOptFloor().getColumnToModelIndicesMap());

        // another test case
        floor = new Floor();
        floor.getOptFloor().setColumnsCost(Double.MAX_VALUE);

        floor.addColumn(new Column());
        floor.getColumns().get(0).getOptColumn().setCost(626);
        floor.addColumn(new Column());
        floor.getColumns().get(1).getOptColumn().setCost(1990);
        floor.addColumn(new Column());
        floor.getColumns().get(2).getOptColumn().setCost(1442);

        numOfmodels = 2;
        instance.assignModelsInFloor(floor, numOfmodels);

        expResult = new int[]{0, 1, 1};
        result = floor.getOptFloor().getColumnToColumnModelIndicesMap();
        assertArrayEquals(expResult, result);
        assertEquals(4606, floor.getOptFloor().getColumnsCost(), 0);
        assertArrayEquals(new int[]{0, 1}, floor.getOptFloor().getModelToColumnIndicesMap());
        assertArrayEquals(new int[]{0, 1, 1}, floor.getOptFloor().getColumnToModelIndicesMap());
    }

    /**
     * Test of resortGivenIndices method, of class Handler.
     */
    @Test
    public void testResortGivenIndices() {
        System.out.println("resortGivenIndices");
        int[] arr = new int[]{1, 2, 2};
        int[] switchedIndices = new int[]{2, 1, 0};
        Handler instance = new Handler();
        int[] expResult = new int[]{2, 2, 1};
        int[] result = instance.resortGivenIndices(arr, switchedIndices);
        assertArrayEquals(expResult, result);

        arr = new int[]{1, 1, 1};
        switchedIndices = new int[]{2, 1, 0};
        expResult = new int[]{1, 1, 1};
        result = instance.resortGivenIndices(arr, switchedIndices);
        assertArrayEquals(expResult, result);
    }
}
