package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoyandProfilePicture {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line1=br.readLine();
		String line2=br.readLine();
		int L=Integer.parseInt(line1);
		int N=Integer.parseInt(line2);
		for(int i=0;i < N ; i++)
		{
			String input=br.readLine();
			String[] widthAndHeigth=input.split("  ");
			int W=Integer.parseInt(widthAndHeigth[0]);
			int H=Integer.parseInt(widthAndHeigth[1]);
			
			if(W < L  ||  H < L)
				System.out.println("UPLOAD ANOTHER");
			else if(W==H && W< L && H <L)
				System.out.println("ACCEPTED");
			else
				System.out.println("CROP");
		}
	}

}
