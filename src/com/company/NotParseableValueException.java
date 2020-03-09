package com.company;

public class NotParseableValueException extends Exception  {
    public  NotParseableValueException (String cellValue){
        super("Невозможно преобразовать " + cellValue + " в число!");
    }
}
