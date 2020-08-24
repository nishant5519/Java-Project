package com.memory.jvm;

import java.util.WeakHashMap;

public class WeakHashMapTest {

    public static void main(String[] args) throws InterruptedException {        
        WeakHashMap<Data, String> map = new WeakHashMap<Data, String>(); // -- Fill a weak hash map with one entry
        Data someDataObject = new Data("foo");
        map.put(someDataObject, someDataObject.value);
        System.out.println("map contains someDataObject ? " + map.containsKey(someDataObject));

        
        someDataObject = null; // Now make someDataObject eligible for garbage collection.Weakref will be GCed in next cycle and map will be empty.
        Thread.sleep(100000);
        for (int i = 0; i < 100000; i++) {
            if (map.size() != 0) {
                System.out.println("At iteration " + i + " the map still holds the reference on someDataObject");
            } else {
                System.out.println("somDataObject has finally been garbage collected at iteration " + i + ", hence the map is now empty");
                break;
            }
        }
    }

    static class Data {
        String value;
        Data(String value) {
            this.value = value;
        }
    }
}