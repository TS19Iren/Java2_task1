package com.company;

public class WrongColumnException extends  Exception {
    public WrongColumnException(){
        super("Количество столбцов не равно 4");
    }

}
