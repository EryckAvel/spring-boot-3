package com.eryckavel.spring_boot_3.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) throws IllegalArgumentException {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) throws IllegalArgumentException {
        return numberOne / numberTwo;
    }

    public Double average(Double numberOne, Double numberTwo) throws IllegalArgumentException{
        return ((numberOne + numberTwo)) / 2;
    }

    public Double squareRoot(Double number) throws IllegalArgumentException {
        return Math.sqrt(number);
    }

}
