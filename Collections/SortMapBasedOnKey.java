package Collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class SortMapBasedOnKey {

	public static void main(String[] args) {
		Map<String, String> unsortMap = new HashMap<String, String>();
        unsortMap.put("Z", "z");
        unsortMap.put("B", "b");
        unsortMap.put("A", "a");
        unsortMap.put("C", "c");
        unsortMap.put("D", "d");
        unsortMap.put("E", "e");
        unsortMap.put("Y", "y");
        unsortMap.put("N", "n");
        unsortMap.put("J", "j");
        unsortMap.put("M", "m");
        unsortMap.put("F", "f");
        Map<String, String> treeMap=new TreeMap<String, String>(unsortMap);
        for(Map.Entry<String, String> entry:treeMap.entrySet()){
        	System.out.println("Key : " + entry.getKey() 
    				+ " Value : " + entry.getValue());
        }
	}

}
