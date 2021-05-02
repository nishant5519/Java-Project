package Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class IterateHashMap {

	public static void main(String[] args) {
		Map<String, String> gfg = new HashMap<String, String>();

		gfg.put("GFG", "geeksforgeeks.org");
		gfg.put("Practice", "practice.geeksforgeeks.org");
		gfg.put("Code", "code.geeksforgeeks.org");
		gfg.put("Quiz", "quiz.geeksforgeeks.org");

		// first way
		for (Entry<String, String> entry : gfg.entrySet()) {
			System.out.println("Key :" + entry.getKey() + ", Value :" + entry.getValue());
		}

		// second way
		for (String name : gfg.keySet())
			System.out.println("key: " + name);

		for (String url : gfg.values())
			System.out.println("value: " + url);
		
		
		//using iterators
		Iterator<Entry<String,String>> itr=gfg.entrySet().iterator();
		while(itr.hasNext()){
			Entry<String,String> entry=itr.next();
			System.out.println("Key = " + entry.getKey() +  
                    ", Value = " + entry.getValue()); 
		}
	}

}
