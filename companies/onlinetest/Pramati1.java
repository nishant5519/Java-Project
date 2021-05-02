package companies.onlinetest;


public final class Pramati1 {
	class Inner{
		void test(){
			if(Pramati1.this.flag){
				sample();
			}
		}
	}
	private boolean flag=true;
	public void sample(){
		System.out.println("sample");
	}
	public Pramati1(){
		(new Inner()).test();
	}
	public static void main(String[] args) {		
		Pramati1 t=new Pramati1();
		int[] a={1};
		t.increment(a);
		System.out.println(a[a.length-1]);
	
		
	}
	void increment(int[] i){
		i[i.length-1]++;
	}

}

/*class B1{
	int b;
	public B1(int x){b=x;}	
};


class A1{
	int a;
	public A1(int x):a(x){}
		};
*/

