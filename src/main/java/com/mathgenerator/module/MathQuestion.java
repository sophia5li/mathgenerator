package com.mathgenerator.module;

import java.util.function.Function;

public class MathQuestion {
    private int num1;
    private int num2;
    private String operator;
    private int id;

    public MathQuestion(int num1, int num2, String operator){
        this(0,num1,num2,operator);
    }

    public MathQuestion(int id, int num1, int num2, String operator){
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public int getId(){
        return id;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

    public Function<Object, Object> bgColor(){
        return (Object obj) ->{
          int index = Integer.parseInt(obj.toString());
          return index % 2 == 0 ? "white" : "lightgrey";
        };
    }
}
