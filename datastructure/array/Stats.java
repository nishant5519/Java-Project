package array;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
	
	//input 1,IBM 22.22,AAPL 33.33,IBM 44.44,AAPL 55.55,IBM 66.66
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		Map<String,Double> newprice=new HashMap<String,Double>();
		Map<String,Integer> symbolcount=new HashMap<String,Integer>();
		
		@Override
		public void putNewPrice(String symbol, double price) {
			// YOUR CODE HERE
			int count = 0;
			if (newprice.containsKey(symbol)) {
				newprice.put(symbol, price + newprice.get(symbol));
				int x = symbolcount.get(symbol);
				++x;
				symbolcount.put(symbol, x);
			} else {
				newprice.put(symbol, price);
				symbolcount.put(symbol, ++count);
			}

		}

		
		@Override
		public double getAveragePrice(String symbol) {
		// YOUR CODE HERE
			double avgprice= newprice.get(symbol)/symbolcount.get(symbol);
			return avgprice;
		}

		@Override
		public int getTickCount(String symbol) {
		// YOUR CODE HERE
			return symbolcount.get(symbol);
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}