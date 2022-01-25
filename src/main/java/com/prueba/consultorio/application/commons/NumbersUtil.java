package com.prueba.consultorio.application.commons;

public class NumbersUtil {

    public static Integer toInteger(String value){
        try {
            return Integer.parseInt(value);
        }catch (RuntimeException e){
            throw new IllegalArgumentException("Parameter is not number "+value);
        }
    }

    public static Double toDouble(String value){
        try {
            return Double.parseDouble(value);
        } catch (RuntimeException e){
            throw new IllegalArgumentException("Parameter is not number"+value);
        }
    }
}
