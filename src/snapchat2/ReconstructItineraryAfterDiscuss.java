package snapchat2;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItineraryAfterDiscuss {
	public List<String> reconstructItineraryAfterDiscuss(String[][] edges) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0 ; i < edges.length ; i ++) {
			String from = edges[i][0];
			String to = edges[i][1];
			List<String> list = new LinkedList<>();
			if (map.containsKey(from)) {
				list = map.get(from);
			} else {
				map.put(from, list);
			}
			list.add(to);
		}
		for (List<String> list : map.values()) {
			Collections.sort(list);
		}
		List<String> ret = new LinkedList<>();
		depthFirstSearch("JFK", map, ret);
		return ret;
	}
	private void depthFirstSearch(String from, Map<String, List<String>> map, List<String> ret) {
		List<String> chil = map.get(from);
		while (chil != null && chil.size() > 0) {
			String next = chil.get(0);
			chil.remove(0);
			depthFirstSearch(next, map, ret);
		}
		ret.add(0, from);
	}
}
		//		Map<String, List<String>> map = new HashMap<>();
//		for (int i = 0 ; i < edges.length ; i ++) {
//			String from = edges[i][0];
//			String to = edges[i][1];
//			List<String> list = new LinkedList<>();
//			if (map.containsKey(from)) {
//				list = map.get(from);
//			} else {
//				map.put(from, list);
//			}
//			list.add(to);
//		}
//		for (List<String> list : map.values()) {
//			Collections.sort(list);
//		}
//		List<String> ret = new LinkedList<>();
//		depthFirstSearch("JFK", map, ret);
//		return ret;
//	}
//	private void depthFirstSearch(String from, Map<String, List<String>> map, List<String> ret) {
//		List<String> chil = map.get(from);
//		if (chil == null) {
//			ret.add(0, from);
//			return;
//		}
//		while (chil != null && chil.size() > 0) {
//			String next = chil.get(0);
//			chil.remove(0);
//			depthFirstSearch(next, map, ret);
//		}
//		ret.add(0, from);
//	}
//}
