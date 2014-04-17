package com.scarino.littlelang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Santo on 2014-04-17.
 */
public class FileTokenizer {

    public static StringTokenizer getTokenizer(String file){

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String ret = "";
            while((line = reader.readLine()) != null){
                ret += line + " ";
            }

            reader.close();
            return new StringTokenizer(ret);
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot locate file " + file);
            System.exit(0);
        }
        catch (IOException e){}

        return null;
    }
}
