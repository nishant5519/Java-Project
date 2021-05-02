package companies.onlinetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Pramati2 {

	public static void main(String[] args) {
		
		List<String> votes=new ArrayList();
		Map<String,Integer> hm=new HashMap<>();
		votes.add("Gulab-Jamun");
		votes.add("Laddu");
		votes.add("Jalebi");
		votes.add("Barfi");
		votes.add("Laddu");
		votes.add("Gulab-Jamun");
		votes.add("Gulab-Jamun");
		votes.add("Jalebi");
		votes.add("Gajar-Halwa");
		votes.add("Gajar-Halwa");
		votes.add("Barfi");
		votes.add("Gajar-Halwa");
		for(String s:votes){
			if(!hm.containsKey(s))
				hm.put(s, 1);
			else
				hm.put(s, hm.get(s)+1);
		}
		Set<Entry<String, Integer>> set = hm.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(
				set);
		
		//Sorting a HashMap based on Value then key
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				 if((o2.getValue()).compareTo(o1.getValue())==0){
					 return o2.getKey().compareTo(o1.getKey());
				 }
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
		System.out.println(hm);
		
	}

}
