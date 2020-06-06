package com.cybertek.tests.day14_properties_driver_tests;

public class Singleton {

    // singleton class will have private constructor
    //it means other classes cannot create object of this class

    private Singleton () {

    }


    private static String str; //in our case we need to use web driver as a type


    public static String getInstance() {
         // if str has no value, initialize and return it
        if(str==null){
            System.out.println("str is null. Assigning value to it");
            str="some value";
        }else {
            System.out.println("it has value just return it");
        }

        return  str;

    }

}
