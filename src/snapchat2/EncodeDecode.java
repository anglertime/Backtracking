package snapchat2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EncodeDecode {
	public String encode(String input) {
		// nr of distinct characters
		Set<Character> set = new HashSet<>();
		for (int i = 0 ; i < input.length() ; i ++) {
			set.add(input.charAt(i));
		}
		int number = set.size();
		// map of freq and map of index
		Map<Character, Integer> freqMap = new HashMap<>();
		Map<Character, Integer> firstIDMap = new HashMap<>();
		for (int i = 0 ; i < input.length(); i ++) {
			char cur = input.charAt(i);
			int freq = 1;
			if (freqMap.containsKey(cur)) {
				freq += freqMap.get(cur);
			}
			freqMap.put(cur, freq);
			if (!firstIDMap.containsKey(cur)) {
				firstIDMap.put(cur, i);
			}
		}
		// int[][], each row : char, freq, firstIndex
		int[][] ordered = new int[number][2];
		int index = 0;
		for (Character cur : set) {
			ordered[index][0] = firstIDMap.get(cur);
			ordered[index][1] = freqMap.get(cur);
			index ++;
		}
		Arrays.sort(ordered, new Comparator<int[]> () {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1] != b[1]) {
					return b[1] - a[1];
				} else {
					return a[0] - b[0];
				}
			}
		});
		// obtain sorted string with distinct char
		StringBuilder sb = new StringBuilder();
		sb.append(number);
		for (int i = 0 ; i < number ; i ++) {
			sb.append(input.charAt(ordered[i][0]));
		}
		// build mathcing map
		Map<Character, String> matching = new HashMap<>();
		for (int i = 0 ; i < number ; i ++) {
			StringBuilder cur = new StringBuilder();
			cur.append(0);
			for (int count = 1 ; count <= i + 1 ; count ++) {
				cur.append(1);
			}
			matching.put(input.charAt(ordered[i][0]), cur.toString());
		}
		// go through input
		for (int i = 0 ; i < input.length(); i ++) {
			sb.append(matching.get(input.charAt(i)));
		}
		String encodedStr = sb.toString();
		System.out.println(encodedStr);
		return encodedStr;
	}
	public String decode(String input) {
		int number = Character.getNumericValue(input.charAt(0));
		String str = input.substring(1, 1 + (number - 1) + 1);
		// build matching
		Map<String, Character> matching = new HashMap<>();
		for (int i = 0 ; i < number ; i ++) {
			StringBuilder cur = new StringBuilder();
			cur.append(0);
			for (int count = 1 ; count <= i + 1 ; count ++) {
				cur.append(1);
			}
			matching.put(cur.toString(), str.charAt(i));
		}
		String decodedStr = input.substring(1 + number, input.length());
		StringBuilder sb = new StringBuilder();
		int back = decodedStr.length();
		int front = decodedStr.lastIndexOf('0', back);
		while (back > 0) {
			sb.append(matching.get(decodedStr.substring(front, back)));
			back = front;
			if (back == 0) {
				break;
			}
			front = decodedStr.lastIndexOf('0', back - 1);
		}
		sb.reverse();
		System.out.println(sb.toString());
		return sb.toString();
	}
}
