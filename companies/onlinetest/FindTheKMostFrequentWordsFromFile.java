package companies.onlinetest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class FindTheKMostFrequentWordsFromFile {

	public static void main(String[] args) {
		TopNWordsCounter counter=new TopNWordsCounter(new Scanner(System.in));
		System.out.println(counter.getTopTenWords());
	}

}

class TopNWordsCounter {

	public static class WordCount {
		String word;
		int count;

		public WordCount(String word) {
			this.word = word;
			this.count = 1;
		}
	}

	private PriorityQueue<WordCount> pq;
	private Map<String, WordCount> dict;

	public TopNWordsCounter(Scanner scanner) {
		pq = new PriorityQueue<>(10, new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o2.count - o1.count;
			}
		});
		dict = new HashMap<>();

		while (scanner.hasNext()) {
			String word = scanner.next();

			WordCount wc = dict.get(word);
			if (wc == null) {
				wc = new WordCount(word);
				dict.put(word, wc);
			}

			if (pq.contains(wc)) {
				pq.remove(wc);
				wc.count++;
				pq.add(wc);
			} else {
				wc.count++;
				if (pq.size() < 10 || wc.count >= pq.peek().count) {
					pq.add(wc);
				}
			}

			if (pq.size() > 10) {
				pq.poll();
			}
		}
	}

	public List<String> getTopTenWords() {
		Stack<String> topTen = new Stack<>();
		while (!pq.isEmpty()) {
			topTen.add(pq.poll().word);
		}
		return topTen;
	}

}