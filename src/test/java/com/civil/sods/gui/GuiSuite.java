/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civil.sods.gui;

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
@Suite.SuiteClasses({com.civil.sods.gui.OutputValuesFrameTest.class, com.civil.sods.gui.ModelOutputValuesFrameTest.class, com.civil.sods.gui.UsedLongDiametersFrameTest.class, com.civil.sods.gui.MainFrameTest.class, com.civil.sods.gui.UsedStirDiametersFrameTest.class, com.civil.sods.gui.InputValuesFrameTest.class})
public class GuiSuite {

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

