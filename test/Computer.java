package test;

public interface Computer extends PC ,Server {

}

interface PC{
	void run();
}

interface Server{
	void run1();
}

abstract class DellPC implements Computer,PC,Server{
	
}
class Laptop extends DellPC implements PC,Server{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run1() {
		// TODO Auto-generated method stub
		
	}
	
}