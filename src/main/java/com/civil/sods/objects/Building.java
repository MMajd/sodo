package com.civil.sods.objects;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */
public class Building {

    private static final Logger LOG = Logger.getLogger(Building.class.getName());

    private ArrayList<Floor> floors;

    /**
     * Constructor for Building Class
     *
     */
    public Building() {
        this.floors = new ArrayList<>();
    }

    /**
     * Method that Gets Floors instances
     *
     * @return Floors instances
     */
    public ArrayList<Floor> getFloors() {
        return this.floors;
    }

    /**
     * Method that Sets Floors instances
     *
     * @param floors Floors instances to be set
     */
    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    /**
     * Method to Add column instance To Floor instance
     *
     * @param floor Floor instance
     * @param column Column instance to be add to the Floor instance
     */
    public void addColumnToFloor(Floor floor, Column column) {
        this.floors.get(this.floors.indexOf(floor)).addColumn(column);
    }

    /**
     * Method that Add Columns instances To Floor instance
     *
     * @param floor Floor instance
     * @param columns Columns instances to be add to the Floor instance
     */
    public void addColumnsToFloor(Floor floor, ArrayList<Column> columns) {
        for (Column column : columns) {
            this.floors.get(this.floors.indexOf(floor)).addColumn(column);
        }
    }

    /**
     * Method that Add Floor to the Building instance
     *
     * @param floor Floor instance to be Added
     */
    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    /**
     * Method that Remove Floor to the Building instance
     *
     */
    public void removeAllFloors() {
        for (int floorIndex = this.floors.size() - 1; floorIndex >= 0; floorIndex--) {
            this.floors.remove(floorIndex);
        }
    }
}
