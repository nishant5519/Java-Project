package string;

public class TestImmutabilityOfStringAndCharArray {

	public static void main(String[] args) {
		String s = "abc";
		System.out.println("Before : " + s);
		char[] ch = s.toCharArray();
		
		
		for(int i = 0 ; i < ch.length ; i++) {
			ch[i] = 'z';
		}
		System.out.println("After : " + s);
		
		System.out.println((char)ch[0]-'1');	
		
		int number = 65;
		char c = (char)number;
		System.out.println(c);

	}
	
	 public String solve(String A) {
	        String reversed = reverse(A.toCharArray() , 0 , A.length()-1);
	        char[] chArray = reversed.toCharArray();
	        int p1=0;
	        int p2=0;
	        
	        while(p2 < A.length() || p1 < A.length()){
	            chArray = reversed.toCharArray();
	            while(p2< chArray.length && chArray[p2]!= ' '){
	                p2++;
	            }
	             reversed = reverse(reversed , p1 , p2-1);
	             p1 = p2+1;
	        }
	        
	        return new String(chArray);
	    }
	    
	    public String reverse(char[] result , int start ,int end) {
	       while(start < end){
	            char temp = result[start];
	            result[start] = result[end];
	            result[end] = temp;
	            start++;
	            end--;
	        }
	        return new String(result);
	    }

}
