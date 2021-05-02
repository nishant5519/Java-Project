package companies.onlinetest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'isSimilar' function below.
	 *
	 * The function is expected to return a BOOLEAN. The function accepts following
	 * parameters: 1. STRING_ARRAY sentence_1 2. STRING_ARRAY sentence_2 3.
	 * 2D_STRING_ARRAY similarity_matrix
	 */

	public static boolean isSimilar(List<String> sentence_1, List<String> sentence_2,
			List<List<String>> similarity_matrix) {
		// Write your code here

		Map<String, String> map = prepareMap(similarity_matrix);
		for (int i = 0; i < sentence_1.size(); i++) {
			if (!findSimilarity(sentence_1.get(i), sentence_2.get(i), map))
				return false;
		}
		return true;
	}

	private static Map<String, String> prepareMap(List<List<String>> similarity_matrix) {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < similarity_matrix.size(); i++) {
			List<String> list = similarity_matrix.get(i);
			if (!map.containsKey(list.get(0)))
				map.put(list.get(0), list.get(1));
		}
		return map;
	}

	private static boolean findSimilarity(String str1, String str2, Map<String, String> map) {

		if (map.get(str1).equals(str2) || map.get(str2).equals(str1))
			return true;

		else {
			String value = str1;
			for (Map.Entry<String, String> entry : map.entrySet()) {

				if (entry.getKey().equals(value)) {
					value = map.get(value);
					if (map.get(value).equals(str2))
						return true;
				}
			}
			return false;
		}
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int sentence_1Count = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> sentence_1 = IntStream.range(0, sentence_1Count).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int sentence_2Count = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> sentence_2 = IntStream.range(0, sentence_2Count).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int similarity_matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
		int similarity_matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> similarity_matrix = new ArrayList<>();

		IntStream.range(0, similarity_matrixRows).forEach(i -> {
			try {
				similarity_matrix
						.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		boolean result = Result.isSimilar(sentence_1, sentence_2, similarity_matrix);

		bufferedWriter.write(String.valueOf(result ? 1 : 0));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
