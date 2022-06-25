package com.civil.sods.export;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that Generate DXF
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class DxfGenerator {

    /**
     * This function run the Drawing python file and sent to it the directory of generated file generated file contain
     * the optimization structure information
     *
     * @param info Information String
     * @param dir Directory Of The File Of Generated DXF File
     * @param fileName File Name Of the Generated DXF File
     *
     * @return SavingDirecotory
     */
    public static String draw(String info, String dir, String fileName) {
        try {

//            absolute path of Drawig.py 
//            String pyPath = new File("src/main/resources/python/Drawing.py").getAbsolutePath();
            ProcessBuilder pb = new ProcessBuilder(
                    "python", "src/main/resources/python/Drawing.py", info, dir, fileName
            );
            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String savingdir = in.readLine();
            System.out.println(savingdir);
            if (savingdir == null) {
                throw new IOException();
            }
            return savingdir;
        } catch (IOException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "Error, file is not saved!";
    }

    /**
     * Constructor for DXF Generator
     *
     */
    private DxfGenerator() {
    }
}

