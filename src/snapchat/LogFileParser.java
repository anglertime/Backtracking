package snapchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LogFileParser {
	public void logFileParser(String[][] input) {
		// each row: true/false, job name, time stamp from 0 to ...
		Map<String, List<Interval>> map = new HashMap<>();
		Stack<String> stack = new Stack<>();
		int prev = Integer.parseInt(input[0][2]);
		for (int i = 0 ; i < input.length ; i ++) {
			int cur = Integer.parseInt(input[i][2]);
			if (input[i][0].equals("true")) {
				if (!map.containsKey(input[i][1])) {
					map.put(input[i][1], new ArrayList<Interval>());
				}
				if (!stack.empty()) {
					Interval curInter = new Interval(prev, cur);
					List<Interval> curList = map.get(stack.peek());
					// check if same
					if (curList.size() > 0 && curInter.start == curList.get(curList.size() - 1).end) {
						// combine
						curList.get(curList.size() - 1).end = cur;
					} else {
						curList.add(curInter);
					}
				}
				stack.push(input[i][1]);
			}
			if (input[i][0].equals("false")) {
				if (stack.empty() || !stack.peek().equals(input[i][1])) {
					throw new IllegalArgumentException("Invalid input!");
				}
				Interval curInter = new Interval(prev, cur);
				List<Interval> curList = map.get(stack.peek());
				// check if same
				if (curList.size() > 0 && curInter.start == curList.get(curList.size() - 1).end) {
					// combine
					curList.get(curList.size() - 1).end = cur;
				} else {
					curList.add(curInter);
				}
				stack.pop();
			}
			prev = cur;
		}
		if (!stack.empty()) {
			throw new IllegalArgumentException("Invalid input!");
		}
		// print
		for (String str : map.keySet()) {
			List<Interval> curList = map.get(str);
			System.out.print(str + ":");
			for (int i = 0 ; i < curList.size(); i ++) {
				System.out.print("[" + curList.get(i).start + ", " + curList.get(i).end + "]" + " ");
			}
			System.out.println();
		}
	}
	
	private class Interval {
		int start;
		int end;
		public Interval (int newStart, int newEnd) {
			start = newStart;
			end = newEnd;
		}
	}
}

//public void logFileParser(String[][] input) {
//	// each row: true/false, job name, time stamp from 0 to ...
//	Map<String, List<Interval>> map = new HashMap<>();
//	Stack<String> stack = new Stack<>();
//	int prev = Integer.parseInt(input[0][2]);
//	for (int i = 0 ; i < input.length ; i ++) {
//		int cur = Integer.parseInt(input[i][2]);
//		if (input[i][0].equals("true")) {
//			if (!map.containsKey(input[i][1])) {
//				map.put(input[i][1], new ArrayList<Interval>());
//			}
//			if (!stack.empty()) {
//				Interval curInter = new Interval(prev, cur);
//				List<Interval> curList = map.get(stack.peek());
//				// check if same
//				if (curList.size() > 0 && curInter.start == curList.get(curList.size() - 1).end) {
//					// combine
//					curList.get(curList.size() - 1).end = cur;
//				} else {
//					curList.add(curInter);
//				}
//			}
//			stack.push(input[i][1]);
//		}
//		if (input[i][0].equals("false")) {
//			if (stack.empty() || !stack.peek().equals(input[i][1])) {
//				throw new IllegalArgumentException("Invalid input!");
//			}
//			Interval curInter = new Interval(prev, cur);
//			List<Interval> curList = map.get(stack.peek());
//			// check if same
//			if (curList.size() > 0 && curInter.start == curList.get(curList.size() - 1).end) {
//				// combine
//				curList.get(curList.size() - 1).end = cur;
//			} else {
//				curList.add(curInter);
//			}
//			stack.pop();
//		}
//		prev = cur;
//	}
//	if (!stack.empty()) {
//		throw new IllegalArgumentException("Invalid input!");
//	}
//	// print
//	for (String str : map.keySet()) {
//		List<Interval> curList = map.get(str);
//		System.out.print(str);
//		for (int i = 0 ; i < curList.size(); i ++) {
//			System.out.print("   " + curList.get(i).start + "->" + curList.get(i).end);
//		}
//		System.out.println();
//	}
//}
//
//private class Interval {
//	int start;
//	int end;
//	public Interval (int newStart, int newEnd) {
//		start = newStart;
//		end = newEnd;
//	}
//}
//}
