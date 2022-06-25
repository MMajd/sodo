package com.civil.sods.objects;

import com.civil.sods.objects.optimum.OptimumFloor;
import java.util.ArrayList;

/**
 * Class that is responsible of Floor
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class Floor {

    private double heightOfFloor;

    private OptimumFloor optFloor;
    ArrayList<Column> columns = new ArrayList<>();

    /**
     * Constructor for Floor instance
     *
     */
    public Floor() {
    }

    /**
     * Constructor for Floor instance with parameters
     *
     * @param heightOfFloor High Of Floor to be set
     */
    public Floor(double heightOfFloor) {
        this.heightOfFloor = heightOfFloor;
    }

    /**
     * Method to Gets Height Of Floor
     *
     * @return Height of Floor
     */
    public double getHeightOfFloor() {
        return heightOfFloor;
    }

    /**
     * Method that Sets Height Of Floor
     *
     * @param heightOfFloor Height Of Floor to be set
     *
     */
    public void setHeightOfFloor(double heightOfFloor) {
        this.heightOfFloor = heightOfFloor;
    }

    /**
     * Method that Gets Optimum Floor
     *
     * @return Optimum Floor
     */
    public OptimumFloor getOptFloor() {
        if (optFloor == null) {
            optFloor = new OptimumFloor();
        }
        return optFloor;
    }

    /**
     * Method that Gets Column instance
     *
     * @return Column instance
     */
    public ArrayList<Column> getColumns() {
        return columns;
    }

    /**
     * Method that Adds Column instance to Floor
     *
     * @param column Column instance to add for Floor
     */
    public void addColumn(Column column) {
        columns.add(column);
    }

}
