package com.scarino.littlelang;

import java.io.IOException;
import java.util.*;

/**
 * Created by Santo on 2014-04-17.
 */
public class Function {

    private String name;
    private List<String> args;
    private List<String> steps;

    private final String START = "{";
    private final String END = "}";

    public Function(StringTokenizer st){
        args = new ArrayList<String>();
        steps = new ArrayList<String>();

        name = st.nextToken();

        String next;
        while(st.hasMoreTokens() && !(next = st.nextToken()).equals(START)){
            args.add(next);
        }

        while(st.hasMoreTokens() && !(next = st.nextToken()).equals(END)){
            steps.add(next);
        }
    }

    public String getName(){ return name; }

    public void eval(Stack<Number> stack, Program program){

        List<Number> argVals = new ArrayList<Number>(args.size());

        for(int i = 0; i < args.size(); i++){
            argVals.add(stack.pop());
        }

        String step;
        int i = 0;
        while(i < steps.size()){
            step = steps.get(i);
            if(step.equals("+")){
                Number first = stack.pop();
                Number second = stack.pop();
                stack.push((Integer)first + (Integer)second);
            }
            else if(step.equals("-")){
                Number first = stack.pop();
                Number second = stack.pop();
                stack.push((Integer)second - (Integer)first);
            }
            else if(step.equals("*")){
                Number first = stack.pop();
                Number second = stack.pop();
                stack.push((Integer)first * (Integer)second);
            }
            else if(step.equals("/")){
                Number first = stack.pop();
                Number second = stack.pop();
                stack.push((Integer)second / (Integer)first);
            }
            else if(step.equals("print")){
                System.out.println(stack.pop());
            }
            else if(step.equals("zero?")){
                Number top = stack.pop();
                if((Integer)top != 0){
                    while(!steps.get(i).equals("done")){i++;}
                }
            }
            else if(step.equals("nonzero?")){
                Number top = stack.pop();
                if((Integer)top == 0){
                    while(!steps.get(i).equals("done")){i++;}
                }
            }
            else if(step.equals("read")){
                Scanner scanner = new Scanner(System.in);
                try{
                    System.out.print(">");
                    stack.push(scanner.nextInt());
                    //scanner.close();
                }
                catch(NumberFormatException e){
                    System.out.println("Only Integers allowed.");
                    System.exit(0);
                }
            }
            else if(step.equals("done")){
                //do nothing
            }
            else{
                try {
                    Integer val = Integer.parseInt(step);
                    stack.push(val);
                }
                catch(NumberFormatException ex){
                    int argPos = isArg(step);
                    if(argPos != -1){
                        stack.push(argVals.get(argPos));
                    }
                    else{
                        Function func = program.find(step);
                        if(func != null){
                            func.eval(stack, program);
                        }
                        else{
                            System.out.println("Unknown value " + step);
                            System.exit(0);
                        }
                    }
                }
            }
            i++;
        }
    }

    private int isArg(String step){
        for(int i = 0; i < args.size(); i++){
            if(step.equals(args.get(i))){
                return i;
            }
        }

        return -1;
    }
}
