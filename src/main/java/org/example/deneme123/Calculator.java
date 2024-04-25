package org.example.deneme123;

public class Calculator {
    public static float divide(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException("Illegal Argument Exception2.");
        }
        float result = a / b;
        return result;

    }
}
