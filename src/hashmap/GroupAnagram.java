package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> groupAnagrams = groupAnagrams(strs);
		System.out.println(groupAnagrams);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();

			Arrays.sort(chars);

			String key = new String(chars);

			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(str);

		}
		return new ArrayList<>(map.values());
	}
}
