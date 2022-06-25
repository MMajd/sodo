/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods;

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
@Suite.SuiteClasses({com.civil.sods.optimize.OptimizeSuite.class, com.civil.sods.objects.ObjectsSuite.class, com.civil.sods.control.ControlSuite.class, com.civil.sods.handle.HandleSuite.class, com.civil.sods.gui.GuiSuite.class, com.civil.sods.AppTest.class})
public class SodsSuite {

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
