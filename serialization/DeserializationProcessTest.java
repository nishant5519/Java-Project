package com.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

class DeserializationProcessTest
{
    public static void main(String[] args)
    {
    	studentinfo si=null ;
        try
        {
            FileInputStream fis = new FileInputStream("student.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            si = (studentinfo)ois.readObject();
            ois.close();
        }
        catch (Exception e)
        {
            e.printStackTrace(); }
            System.out.println(si.name);
            System.out. println(si.rid);
            System.out.println(si.contact);
            System.out.println(si.trans);
        }
}