package practice;

public class ByteTest {

	
	public static void main(String[] args) {
		byte a[]={65,66,67,68,69,70};
		byte b[]={71,72,73,74,75,76};
		System.arraycopy(a, 2, b, 1, a.length-3);
		System.out.println(new String(a) + " " + new String(b));
		
		byte x=50;
		x=(byte) (x*50);//Need conversion from int to byte
		
		int p =1;
		int q =1;
		System.out.println(p&q);
	}

}
