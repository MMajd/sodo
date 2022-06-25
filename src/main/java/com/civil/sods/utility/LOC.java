package com.civil.sods.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class LOC {

    /**
     * prevent instantiation of this class
     */
    private LOC() {
    }

    /**
     * This method returns the total number of lines of code in the project as string
     *
     * <p>
     * @return number of LOC in the project
     * @throws FileNotFoundException
     */
    public static String getLOC() throws FileNotFoundException {

        String folderPath = new File("").getAbsolutePath();

        long totalLineCount = 0;
        final List<File> folderList = new LinkedList<>();
        folderList.add(new File(folderPath));

        while (!folderList.isEmpty()) {
            File folder = folderList.remove(0);
            if (folder.isDirectory() && folder.exists()) {
                File[] fileList = folder.listFiles();

                for (final File file : fileList) {
                    if (file.isDirectory()) {
                        folderList.add(file);
                    } else if (file.getName().endsWith(".java")
                            || file.getName().endsWith(".py")) {
                        long lineCount = 0;
                        Scanner scanner = new Scanner(file);

                        while (scanner.hasNextLine()) {
                            scanner.nextLine();
                            lineCount++;
                        }
                        totalLineCount += lineCount;
                    }
                }
            }
        }

        return NumberFormat.getNumberInstance(Locale.US)
                .format(totalLineCount);
    }

    /**
     *
     * This method prints LOC in each file and total LOC in the whole project files examine of the file read is java or
     * python file if true file is taken into account if not file is ignored
     *
     * <p>
     * @throws FileNotFoundException
     */
    public static void getFullReportOnLOC() throws FileNotFoundException {
        long totalLineCount = 0;
        String folderPath = new File("").getAbsolutePath();

        final List<File> folderList = new LinkedList<>();
        folderList.add(new File(folderPath));

        while (!folderList.isEmpty()) {
            File folder = folderList.remove(0);

            if (folder.isDirectory() && folder.exists()) {
                System.out.println("Scanning " + folder.getName());
                File[] fileList = folder.listFiles();

                for (final File file : fileList) {
                    if (file.isDirectory()) {
                        folderList.add(file);
                    } else if (file.getName().endsWith(".java")
                            || file.getName().endsWith(".py")) {
                        long lineCount = 0;
                        Scanner scanner = new Scanner(file);

                        while (scanner.hasNextLine()) {
                            scanner.nextLine();
                            lineCount++;
                        }
                        totalLineCount += lineCount;
                        String lineCountString = NumberFormat.getNumberInstance(Locale.US).format(lineCount);

                        System.out.println(lineCountString + " lines in " + file.getName());
                    }
                }
            }
        }
        System.out.println("\n\n" + StdOuptDecorator.getEqualSigns(20));
        System.out.println("Scan Complete: " + NumberFormat.
                getNumberInstance(Locale.US).format(totalLineCount) + " lines total");
        System.out.println(StdOuptDecorator.getEqualSigns(20) + "\n\n");

    }

    /**
     * Main Method
     *
     * @param args
     *
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
//        LOC.getFullReportOnLOC();
        System.out.println("\n" + StdOuptDecorator.getEqualSigns(30));
        getFullReportOnLOC();
        System.out.println(StdOuptDecorator.getEqualSigns(30) + "\n");
    }
}
