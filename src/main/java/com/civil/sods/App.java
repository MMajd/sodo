package com.civil.sods;

import com.civil.sods.control.MainController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The only main function that will be called to initiate the program
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */


public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    /**
     * Main Method
     *
     * @param args Arguments
     *
     */
    public static void main(String[] args) {
//        PropertyConfigurator.configure("log4j.properties");
        LOGGER.traceEntry();
        LOGGER.info("The program started");
        java.awt.EventQueue.invokeLater(new MainControllerRunnableImpl());
    }

    private static class MainControllerRunnableImpl implements Runnable {

        @Override
        public void run() {
            MainController.getMainControllerInstanceUsingDoubleLocking();
        }
    }
}
