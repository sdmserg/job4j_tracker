package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperations(int n) {
        return sum(n) + multiply(n) + minus(n) + divide(n);
    }

    public static int minus(int k) {
        return k - x;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static void main(String[] args) {
        int minusResult = minus(7);
        int sumResult = sum(10);
        Calculator calculator = new Calculator();
        int multiplyResult = calculator.multiply(5);
        int divideResult = calculator.divide(20);
        int resultSumAllOperations = calculator.sumAllOperations(30);
        System.out.println("minusResult: " + minusResult);
        System.out.println("sumResult: " + sumResult);
        System.out.println("multiplyResult: " + multiplyResult);
        System.out.println("divideResult: " + divideResult);
        System.out.println("resultSumAllOperations: " + resultSumAllOperations);
    }
}
