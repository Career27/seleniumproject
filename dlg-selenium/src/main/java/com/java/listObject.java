package com.java;

import java.util.ArrayList;
import java.util.List;

public class listObject {
    List<String> a =  new ArrayList<>();

    public static void main(String[] args) throws Exception{


        String name2 = ("Suraj" == "Kumar") ? "Yes" : "No";

        System.out.println(name2);

        for (String d : listObject.listReturn()) {
            System.out.println(d);
        }

        List<String> output = listObject.listReturn();

        for(String b : output){
            System.out.println(b);
        }

        System.out.println(output);

    }


    public static List<String> listReturn(){

        listObject obj = new listObject();
        obj.a.add("one");
        obj.a.add("two");
        obj.addList();

        return obj.a;
    }

    public void addList(){
        a.add("Three");
        a.add("Four");
    }
}
