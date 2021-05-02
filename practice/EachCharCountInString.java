package practice;

import java.util.HashMap;
import java.util.Map;

public class EachCharCountInString {
	static void characterCount(String input) {

        HashMap<Character, Integer> instanceCharCountMap = new HashMap<Character, Integer>();  
        String result="";
        if(input==" " || input.equals(" ")){
          System.out.println("Empty string");
        }
        else{
        char[] strArray = input.toCharArray();
      
        for (char c : strArray)
        {
            if(instanceCharCountMap.containsKey(c))
            {            
                instanceCharCountMap.put(c, instanceCharCountMap.get(c)+1);
            }
            else
            {
               instanceCharCountMap.put(c, 1);
            }
        }
        
         System.out.println(instanceCharCountMap);
            for ( Map.Entry<Character, Integer> entry : instanceCharCountMap.entrySet()) {
                         Character character = entry.getKey();
                    String instance = entry.getValue().toString();
                 result= result + instance + character ;
   
}
            System.out.println(result);
        
        }
	}

	public static void main(String[] args) {
		characterCount("Java J2EE Java JSP J2EE");

		characterCount("All Is Well");

		characterCount("Done And Gone");
		String input="2112";
		 char stringArray[]=input.toCharArray(); 
	        int count=0;
	        char combination;
	        for(int index=0;index < (stringArray.length-1);index++)
	            if(stringArray[index]!=0){
	                  combination= (char) (stringArray[index] + stringArray[index+1]);	                  
	                 if(combination<26){
	                	 index++;
	                	 count++;
	                 }
	                     
	                     
	        }
	        System.out.println("Final result " + count);
	}

}
