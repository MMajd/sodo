package com.civil.sods.objects.optimum;

import com.civil.sods.utility.Utilities;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Class that Obtain the Optimum Floor
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat 
 */

public class OptimumFloor {

    private double columnsCost;
    private int[] columnToColumnModelIndicesMap;
    private int[] modelToColumnIndicesMap;
    private int[] columnToModelIndicesMap;

    /**
     * Method that Gets Column Cost
     *
     * @return Column Cost
     */
    public double getColumnsCost() {
        return columnsCost;
    }

    /**
     * Method that sets Column Cost
     *
     * @param columnsCost Column Cost to be set
     *
     */
    public void setColumnsCost(double columnsCost) {
        this.columnsCost = columnsCost;
    }

    /**
     * Method that Gets Column To Column Model Indices Map
     *
     * @return Array of Column To Column Model Indices Map
     */
    public int[] getColumnToColumnModelIndicesMap() {
        return columnToColumnModelIndicesMap;
    }

    /**
     * Method that Sets Column To Column Model Indices Map
     *
     * @param columnToColumnModelIndicesMap Array Column To Column Model Indices Map to be set
     *
     */
    public void setColumnToColumnModelIndicesMap(int[] columnToColumnModelIndicesMap) {
        this.columnToColumnModelIndicesMap = columnToColumnModelIndicesMap;

        assignModelToColumnIndicesMap();
        assignColumnToModelIndicesMap();
    }

    /**
     * Method that Gets Model To Column Indices Map
     *
     * @return Array Model To Column Indices Map
     */
    public int[] getModelToColumnIndicesMap() {
        return modelToColumnIndicesMap;
    }

    /**
     * Method that Gets Model To Column Indices Map
     *
     * @return columnToModelIndicesMap
     */
    public int[] getColumnToModelIndicesMap() {
        return columnToModelIndicesMap;
    }

    /**
     * Method that Assign Model To Column Indices Map
     *
     */
    private void assignModelToColumnIndicesMap() {
        ArrayList<Integer> modelToColumnIndices = new ArrayList<>();
        for (int i = 0; i < columnToColumnModelIndicesMap.length; i++) {
            if (!modelToColumnIndices.contains(columnToColumnModelIndicesMap[i])) {
                modelToColumnIndices.add(columnToColumnModelIndicesMap[i]);
            }
        }

        // Copy the array list elements to the array
        this.modelToColumnIndicesMap = modelToColumnIndices.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Method that Assign Column To Model Indices Map
     *
     */
    private void assignColumnToModelIndicesMap() {
        int n = columnToColumnModelIndicesMap.length;
        columnToModelIndicesMap = new int[n];

        for (int i = 0; i < n; i++) {
            columnToModelIndicesMap[i] = Utilities.indexOfElementInArray(
                    modelToColumnIndicesMap, columnToColumnModelIndicesMap[i]
            );
        }
    }
}
