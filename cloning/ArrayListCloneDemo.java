package com.cloning;

import java.util.ArrayList;

//****************************************************************
//* Copyright (c) 2018 Ford Motor Company. All Rights Reserved.
//****************************************************************

/**
 * Place class description here.
 * https://stackoverflow.com/questions/4592478/clone-arraylist-clone-i-thought-does-a-shallow-copy 
 */
public class ArrayListCloneDemo {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("S1");
        StringBuilder s2 = new StringBuilder("S2");
        StringBuilder s3 = new StringBuilder("S3");
        
        ArrayList<StringBuilder> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        
        System.out.println(list1);
        ArrayList<StringBuilder> list2 = (ArrayList<StringBuilder>)list1.clone();
        
        System.out.println("Hashcode of list1:" + list1.hashCode() + ";" + "Hashcode for list2:" + list2.clone());
        list1.add(s3);
        
        System.out.println("list1 : "+list1);
        System.out.println("list2 : "+list2);
        
        s1.append("-1");
        s2.append("-2");
        
        System.out.println("list1 : "+list1);
        System.out.println("list2 : "+list2);
    }

}


