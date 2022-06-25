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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Abdullah Salama
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.civil.sods.objects.optimum.OptimumFloorTest.class, com.civil.sods.objects.optimum.OptimumStirrupsTest.class, com.civil.sods.objects.optimum.OptimumLongitudinalBarsTest.class, com.civil.sods.objects.optimum.OptimumRectangularStirrupsTest.class, com.civil.sods.objects.optimum.OptimumColumnTest.class, com.civil.sods.objects.optimum.OptimumSingleStirrupsTest.class, com.civil.sods.objects.optimum.OptimumTrapezoidalStirrupsTest.class})
public class OptimumSuite {

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
