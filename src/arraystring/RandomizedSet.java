package arraystring;

import java.util.*;

public class RandomizedSet {
	private List<Integer> list;
	private Map<Integer, Integer> map;
	private Random random;

	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (map.containsValue(val)) {
			return false;
		}

		list.add(val);
		System.out.println(list.size());
		map.put(val, list.size() - 1);
		System.out.println(map);

		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);// value ka index nikala
		int lastValue = list.get(list.size() - 1); // last index nikal

		list.set(index, lastValue);// exchange kr diya. beech me se
		// delete karenge to shift hogi isiliye last me dala h
		map.put(lastValue, index);

		list.remove(list.size() - 1);// last wala remove kr diya no shifting
		map.remove(val);// map se bhi remove kr diya.

		return true;
	}

	public int getRandom() {
		int index = random.nextInt(list.size());
		return list.get(index);
	}

	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();
//		rs.insert(10);
//		rs.insert(20);
//		rs.insert(30);
//		rs.remove(10);
		System.out.println(rs.insert(10));
//		System.out.println(rs.insert(20));
//		System.out.println(rs.insert(30));
//		System.out.println(rs.remove(10));
//		System.out.println(rs.getRandom());

	}

}
