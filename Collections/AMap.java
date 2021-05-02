package Collections;

import java.util.HashMap;
import java.util.Map;

public class AMap {

	int x;

	public AMap(int x) {
		this.x = x;
	}

	public int hashCode() {
		return (int) (Math.random() * 1000);
	}

	public boolean equals(Object obj) {
		AMap other = (AMap) obj;
		if (x != other.x)
			return false;
		return true;
	}

	public String toString() {
		return "" + x;
	}

	public static void main(String[] args) {
		Map<AMap, Integer> map = new HashMap<AMap, Integer>();
		AMap a = new AMap(10);
		map.put(a, 1);
		System.out.println(map.get(a));
	}

}
