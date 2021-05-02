package Exception;

import java.io.IOException;

public class Tester {

	public static void main(String[] args) {
		try{
			new AirJet();
		}catch(IOException e){
			System.out.println("IOException is thrown in Tester");
		}
	}

}

class AirPlane{
	public AirPlane() throws IOException{
		System.out.println("AirPlane");
		throw new IOException();
	}
}

class AirJet extends AirPlane{
	/*public AirJet() throws IOException{
		try{
			super();
		}
		catch(IOException e){
			System.out.println("IOexception is thrown in AirJet");
		}
	}*/
	public AirJet() throws IOException{
			super();
	}
}
