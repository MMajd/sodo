/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.objects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Abdullah Salama
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.civil.sods.objects.CostsTest.class, com.civil.sods.objects.SingleStirrupsTest.class,
    com.civil.sods.objects.RectangularStirrupsTest.class, com.civil.sods.objects.StirrupsTest.class,
    com.civil.sods.objects.optimum.OptimumSuite.class, com.civil.sods.objects.TrapezoidalStirrupsTest.class,
    com.civil.sods.objects.FloorTest.class, com.civil.sods.objects.ColumnTest.class,
    com.civil.sods.objects.BuildingTest.class})
public class ObjectsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
