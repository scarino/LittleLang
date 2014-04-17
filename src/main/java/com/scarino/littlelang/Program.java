package com.scarino.littlelang;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Santo on 2014-04-17.
 */
public class Program {

    private final String MAIN = "main";

    List<Function> functionList;

    public Program(StringTokenizer st){
        functionList = new ArrayList<Function>();

        while(st.hasMoreTokens()){
            functionList.add(new Function(st));
        }
    }

    public Function find(String name){
        for(Function function : functionList){
            if(function.getName().equals(name)){
                return function;
            }
        }

        return null;
    }

}
