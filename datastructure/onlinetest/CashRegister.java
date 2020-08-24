package com.onlinetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

//https://github.com/GregBilodeau/CodEval/blob/master/CashRegister.java
public class CashRegister {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {

			if (!line.equalsIgnoreCase("")) {
				String elements[] = line.split(";");
				float price = Float.parseFloat(elements[0]);
				float cash = Float.parseFloat(elements[1]);

				double change = cash - price;

				if (change < 0) {
					System.out.println("ERROR");
				} else if (change == 0) {
					System.out.println("ZERO");
				} else {
					System.out.println(findChange2(change));
				}
			}

		}
		reader.close();
		in.close();

	}

	private static String findChange(double change) {

		String textChange = "";

		DecimalFormat df = new DecimalFormat("########.##");
		int intChange = (int) (Double.valueOf(df.format(change)) * 100);

		while (intChange >= 0.01) {
			if (intChange >= 10000) {
				textChange += "ONE HUNDRED,";
				intChange -= 10000;
			} else if (intChange >= 5000) {
				textChange += "FIFTY,";
				intChange -= 5000;
			} else if (intChange >= 2000) {
				textChange += "TWENTY,";
				intChange -= 2000;
			} else if (intChange >= 1000) {
				textChange += "TEN,";
				intChange -= 1000;
			} else if (intChange >= 500) {
				textChange += "FIVE,";
				intChange -= 500;
			} else if (intChange >= 200) {
				textChange += "TWO,";
				intChange -= 200;
			} else if (intChange >= 100) {
				textChange += "ONE,";
				intChange -= 100;
			} else if (intChange >= 50) {
				textChange += "HALF DOLLAR,";
				intChange -= 50;
			} else if (intChange >= 25) {
				textChange += "QUARTER,";
				intChange -= 25;
			} else if (intChange >= 10) {
				textChange += "DIME,";
				intChange -= 10;
			} else if (intChange >= 5) {
				textChange += "NICKEL,";
				intChange -= 5;
			} else if (intChange >= 1) {
				textChange += "PENNY,";
				intChange -= 1;
			}
		}
		return textChange.substring(0, textChange.length() - 1);
	}

	private static String findChange2(double cashBack) {
		StringBuilder change = new StringBuilder();
		for (Denomination d : Denomination.values()) {
			while (cashBack >= d.getValue()) {
				cashBack -= d.getValue();
				change.append(d).append(',');
			}
		}

		return change.replace(change.length()-1, change.length(), "").toString();
	}
	enum Denomination {
	    ONE_HUNDRED(100.00f),
	          FIFTY( 50.00f),
	         TWENTY( 20.00f),
	            TEN( 10.00f),
	           FIVE(  5.00f),
	            TWO(  2.00f),
	            ONE(  1.00f),
	    HALF_DOLLAR(  0.50f),
	        QUARTER(  0.25f),
	           DIME(  0.10f),
	         NICKEL(  0.05f),
	          PENNY(  0.01f);

	    private final float value;
	    private final String description;

	    Denomination(float value) {
	        this.value = value;
	        this.description = this.name().replace("_", " ");
	    }

	    public float getValue() {
	        return this.value;
	    }

	    @Override
	    public String toString() {
	        return this.description;
	    }
	}
}
