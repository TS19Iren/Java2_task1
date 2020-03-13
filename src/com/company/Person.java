package com.company;



import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<String> phone;
    private List<String> e_mail;

    public Person (List<String> phone, List<String> e_mail){

        this.phone=phone;
        this.e_mail=e_mail;
    }
    public Person (List<String> phone){
        this.phone=phone;
        this.e_mail=new ArrayList<>(0);
    }
    public Person (String phone){
        this.phone = new ArrayList<>(1);
        this.phone.add(phone);
        this.e_mail=new ArrayList<>(0);
}
    public  List<String>  getPhone(){
        return  this.phone;
    }
    public  List<String> getE_mail(){
        return this.e_mail;
    }
}
