package com.prueba.consultorio.application.commons;

import com.prueba.consultorio.application.errors.InputDataError;

import java.time.format.DateTimeParseException;

public class Validate {

    private final static String REQUIRED = "required";

    public static void notNull(Object value, String message){
        if (value == null){
            throw new NullPointerException(message);
        }
    }

    public static void isTrue(boolean condition, String message){
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    public static NonEmptyUUID nonEmptyUUID(String parameter, String value){
        try {
            return new NonEmptyUUID(value);
        }catch (NullPointerException e){
            throw new InputDataError("parameter can not be null",parameter,REQUIRED);
        }catch (IllegalArgumentException e){
            throw new InputDataError("value of parameter not allowed",parameter,value);
        }
    }

    public static NonEmptyString nonEmptyString(String parameter, String value){
        try {
            return new NonEmptyString(value);
        } catch (NullPointerException e){
            throw new InputDataError("Parameter can not be null", parameter, REQUIRED);
        } catch (IllegalArgumentException e){
            throw new InputDataError("Value of parameter not allowed", parameter, value);
        }
    }

    public static NonEmptyNumber nonEmptyNumber(String parameter, String value){
        try {
            return new NonEmptyNumber(value);
        }catch (NullPointerException e){
            throw new InputDataError("parameter can not be null",parameter,REQUIRED);
        }catch (IllegalArgumentException e){
            throw new InputDataError("value of parameter not allowed",parameter,value);
        }
    }

    public static NonEmptyLocalDate nonEmptyLocalDate(String parameter, String value){
        try {
            return new NonEmptyLocalDate(value);
        }catch (NullPointerException e){
            throw new InputDataError("parameter can not be null",parameter,REQUIRED);
        }catch (IllegalArgumentException e){
            throw new InputDataError("value of parameter not allowed",parameter,value);
        } catch (DateTimeParseException e){
            throw new InputDataError("value of parameter not allowed",parameter,value);
        }
    }

    public static NonEmptyLocalTime nonEmptyLocalTime(String parameter, String value){
        try {
            return new NonEmptyLocalTime(value);
        }catch (NullPointerException e){
            throw new InputDataError("parameter can not be null",parameter,REQUIRED);
        }catch (IllegalArgumentException e){
            throw new InputDataError("value of parameter not allowed",parameter,value);
        } catch (DateTimeParseException e){
            throw new InputDataError("value of parameter not allowed",parameter,value);
        }
    }
}
