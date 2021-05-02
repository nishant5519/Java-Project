package practice;

import java.util.Stack;

public class Result {

	public static void main(String[] args) {
		Tesla<String> t=new Tesla<String>();
		t.push("Hello");
		System.out.println(t.pop());
		
	}

}

class Tesla<String>{
	Stack<String> s=new Stack<String>();
	public void push(String ob){
		s.push(ob);
	}
	public String pop(){
		String ob=s.pop();
		return ob;
	}
}
