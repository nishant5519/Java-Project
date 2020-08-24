package com.memory.jvm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadHugeFileWithLimitedJVMMemory {

	public static void main(String[] args) {

		// (1)Loading Whole File Into Memory.The problem with the above approach
		// is that, with a sufficiently
		// large file, you end up with an OutOfMemoryError.
		List<Object> add = null;
		add.add(1);
		add.add("a");
		List a=null;
		a.add("a");
		a.add(1);

		Path path = Paths.get("C:\\NOTES");
		try {
			String str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// (2)Loading a Binary File in Chunks

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\NOTES"))) {
			byte[] bbuf = new byte[4096];
			int len;
			while ((len = in.read(bbuf)) != -1) {
				// process data here: bbuf[0] thru bbuf[len - 1]
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// (3) Reading a Text File Line By Line
		try(BufferedReader in = new BufferedReader(new FileReader("C:\\NOTES"))) {
		    String line;
		    while ((line = in.readLine()) != null) {
		        // process line here.
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//(4) Using a Scanner.If you need to read line-by-line, I recommend the method above using 
		//BufferedReader since the Scanner method is slow as molasses.
		try(Scanner scanner = new Scanner(new File("C:\\NOTES"))) {
		    while ( scanner.hasNextLine() ) {
		        String line = scanner.nextLine();
		        System.out.println(line);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		/*(5) With Java 8 Streams.Java 8 provides the streams facility which are useful in wide variety of 
		cases. Here we can use the Files.lines() method to create a stream of lines from a file, apply any 
		filters and do any processing we want. In the following example, we are selecting lines that contain 
		the string abc and collect the results into a List.*/
		
		try {
			List<String> alist = Files.lines(path)
				    .filter(line -> line.contains("abc"))
				    .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// (6) Java 7 way of reading file
		 try
	        {
	            Path file = Paths.get("c:/temp/my-large-file.csv");
	       
	            List<String> readAllLines = Files.readAllLines(file, StandardCharsets.UTF_8);
	            
	            for (String string : readAllLines) {
	            System.out.println(string);
	        }
	           
	        } catch (IOException ioe){
	            ioe.printStackTrace();
	        }
	 
	}
}
