package com.scarino.littlelang;

import java.util.Stack;
import java.util.StringTokenizer;
import com.scarino.littlelang.FileTokenizer;

/**
 * Created by Santo on 2014-04-17.
 */
public class LittleLang {

    private static void usage(){
        System.out.println("Usage: java LittleLang <program>");
    }

    public static void main(String[] args){
        if(args.length == 0){
            usage();
            System.exit(0);
        }

        StringTokenizer st = FileTokenizer.getTokenizer(args[0]);

        if(st != null) {
            Program program = new Program(st);
            Function mainFunction = program.find("main");
            Stack<Number> stack = new Stack<Number>();

            if(mainFunction != null) {
                mainFunction.eval(stack, program);
            }
            else
                System.out.println("Could not find MAIN function.");
        }
    }
}
