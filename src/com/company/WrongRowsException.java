package com.company;

public class WrongRowsException extends Exception {
    public WrongRowsException(){
        super("Количество строк не равно 4");
    }
}
