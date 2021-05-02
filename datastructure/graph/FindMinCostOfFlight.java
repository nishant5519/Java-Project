package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://aaronice.gitbooks.io/lintcode/graph_search/cheapest-flights-within-k-stops.html

public class FindMinCostOfFlight {

	public static void main(String[] args) {
		Flight flight1 = new Flight("Chennai", "Banglore", 100);
		Flight flight2 = new Flight("Chennai", "Mumbai", 300);
		Flight flight3 = new Flight("Chennai", "Delhi", 600);
		Flight flight4 = new Flight("Banglore", "Mumbai", 100);
		Flight flight5 = new Flight("Banglore", "Delhi", 400);
		Flight flight6 = new Flight("Mumbai", "Delhi", 200);

		Flight[] flight = new Flight[6];
		flight[0] = flight1;
		flight[1] = flight2;
		flight[2] = flight3;
		flight[3] = flight4;
		flight[4] = flight5;
		flight[5] = flight6;
		
		System.out.println(minCost(flight,"Chennai","Delhi",0));
	}

	static int minCost(Flight[] flights, String from, String to, int maxAllowedTransfers) {
		Map<String, ArrayList<Flight>> map = new HashMap<>();

		for (Flight flight : flights) {
			if (!map.containsKey(flight.getFromCity())) {
				map.put(flight.getFromCity(), new ArrayList<Flight>());
			}
			map.get(flight.getFromCity()).add(flight);
		}

		Comparator<Stop> cmp = new Comparator<Stop>() {
			public int compare(Stop s1, Stop s2) {
				return s1.cost - s2.cost; // inserts Stop in queue in order of increasing cost.
			}
		};
		PriorityQueue<Stop> q = new PriorityQueue<Stop>(cmp);

		q.offer(new Stop(from, 0, maxAllowedTransfers)); //insert the source in queue
		while (q != null && !q.isEmpty()) {
			Stop cur = q.poll();
			if (cur.getStop().equals(to)) {
				return cur.getCost();
			}

			if (cur.getCount() >= 0) {
				List<Flight> list = map.get(cur.getStop());
				if (list == null) {
					continue;
				}
				for (Flight f : list) {
					q.offer(new Stop(f.getToCity(), f.getCost() + cur.getCost(), cur.getCount() - 1));
				}
			}
		}

		return -1;
	}
}

class Flight {

	String fromCity;

	String toCity;

	int cost;

	public Flight(String fromCity, String toCity, int cost) {
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.cost = cost;
	}

	public String getFromCity() {
		return fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public int getCost() {
		return cost;
	}

}

class Stop {
	String stop;
	int cost;
	int count;

	Stop(String id, int cost, int count) {
		this.stop = id;
		this.cost = cost;
		this.count = count;
	}

	public String getStop() {
		return stop;
	}

	public int getCost() {
		return cost;
	}

	public int getCount() {
		return count;
	}
	
	
}