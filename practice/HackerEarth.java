package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerEarth {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String[] input=s.split(" ");
		int N=Integer.parseInt(input[0]);//total number
		int K=Integer.parseInt(input[1]);//special number
		int X=Integer.parseInt(input[2]);//first person to hold gun
		int[] person=new int[N];
		for(int i=0;i<N;i++)
			person[i]=i+1;
		
		for(int i=0;i<N;i++)
 {
			int a = X % K;
			for (int j = 0; j < a;) {
				if (person[X] != 0) {
					person[X] = 0;
					j++;
				}
				X++;
				if (X == (N - 1))
					X = 0;
			}

			X = person[X];

			for (int p = 0; p < N; p++) {

			}
		}
	}

}
