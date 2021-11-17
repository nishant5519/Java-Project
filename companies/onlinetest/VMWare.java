package companies.onlinetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

 class Result {
	/*
	 * Complete the 'numberOfTokens' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER expiryLimit 2. 2D_INTEGER_ARRAY commands
	 */

	public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
		// Write your code here
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < commands.size(); i++) {
			List<Integer> command = commands.get(i);
			// create
			if (command.get(0) == 0) {
				map.put(command.get(1), expiryLimit + command.get(2));
			} else {// reset
				if (map.containsKey(command.get(1))) {
					if (command.get(2) <= map.get(command.get(1)))
						map.put(command.get(1), expiryLimit + command.get(2));
				}
			}
		}

		int totalCommands = commands.size();
		int lastTime = commands.get(totalCommands - 1).get(2);

		for (Integer key : map.keySet()) {
			if (map.get(key) > lastTime)
				count++;
		}

		return count;

	}

}

public class VMWare {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int expiryLimit = Integer.parseInt(bufferedReader.readLine().trim());

		int commandsRows = Integer.parseInt(bufferedReader.readLine().trim());
		int commandsColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> commands = new ArrayList<>();

		IntStream.range(0, commandsRows).forEach(i -> {
			try {
				commands.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.numberOfTokens(expiryLimit, commands);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
