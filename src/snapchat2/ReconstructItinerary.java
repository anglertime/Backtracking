package snapchat2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
	List<String> ret;
	public List<String> findItinerary(String[][] tickets) {
        // build graph
		Map<String, GraphNode> map = new HashMap<>();
		for (int i = 0 ; i < tickets.length ; i ++) {
			GraphNode from = buildGraph(tickets[i][0], map);
			GraphNode to = buildGraph(tickets[i][1], map);
			from.children.put(tickets[i][1], to);
		}
		// walk graph lexically and return the first result
		ret = new ArrayList<>();
		Map<String, GraphNode> rootChil = map.get("JFK").children;
		
		List<String> rootChilList = new ArrayList<>();
		rootChilList.addAll(rootChil.keySet());
		Collections.sort(rootChilList);
		
		for (String str : rootChilList) {
			GraphNode cur = rootChil.get(str);
			rootChil.remove(str);
			List<String> tmp = new ArrayList<>();
			tmp.add("JFK");
			if (backtracking(cur, 1, tickets.length, tmp)) {
				for (int i = 0 ; i < ret.size(); i ++) {
					System.out.println(ret.get(i));
				}
				return ret;
			} else {
				rootChil.put(str, cur);
			}
		}
		for (int i = 0 ; i < ret.size(); i ++) {
			System.out.println(ret.get(i));
		}
		return ret;
    }
	private boolean backtracking(GraphNode from, int edgesSoFar, int totalEdges, List<String> stringSoFar) {
		if (edgesSoFar == totalEdges) {
			List<String> list = new ArrayList<>(stringSoFar);
			list.add(from.key);
			ret = list;
			return true;
		}
		Map<String, GraphNode> chil = from.children;
		if (chil.size() == 0) {
			return false;
		}
		List<String> children = new ArrayList<>();
		children.addAll(chil.keySet());
		Collections.sort(children);
		for (String str : children) {
			GraphNode cur = chil.get(str);
			List<String> list = new ArrayList<>(stringSoFar);
			list.add(from.key);
			chil.remove(str);
			if (backtracking(cur, edgesSoFar + 1, totalEdges, list)) {
				return true;
			} else {
				chil.put(str, cur);
				return false;
			}
		}
		return false;
	}
	private GraphNode buildGraph(String str, Map<String, GraphNode> map) {
		if (map.containsKey(str)) {
			return map.get(str);
		} else {
			GraphNode ret = new GraphNode(str);
			map.put(str, ret);
			return ret;
		}
	}
	private class GraphNode {
		String key;
		Map<String, GraphNode> children;
		public GraphNode (String newKey) {
			key = newKey;
			children = new HashMap<>();
		}
	}
}
//	List<String> ret;
//	public List<String> findItinerary(String[][] tickets) {
//        // build graph
//		Map<String, GraphNode> map = new HashMap<>();
//		for (int i = 0 ; i < tickets.length ; i ++) {
//			GraphNode from = buildGraph(tickets[i][0], map);
//			GraphNode to = buildGraph(tickets[i][1], map);
//			from.children.put(tickets[i][1], to);
//		}
//		// walk graph lexically and return the first result
//		ret = new ArrayList<>();
//		Map<String, GraphNode> rootChil = map.get("JFK").children;
//		
//		List<String> rootChilList = new ArrayList<>();
//		rootChilList.addAll(rootChil.keySet());
//		Collections.sort(rootChilList);
//		
//		for (String str : rootChilList) {
//			GraphNode cur = rootChil.get(str);
//			rootChil.remove(str);
//			List<String> tmp = new ArrayList<>();
//			tmp.add("JFK");
//			if (backtracking(cur, 1, tickets.length, tmp)) {
//				for (int i = 0 ; i < ret.size(); i ++) {
//					System.out.println(ret.get(i));
//				}
//				return ret;
//			} else {
//				rootChil.put(str, cur);
//			}
//		}
//		for (int i = 0 ; i < ret.size(); i ++) {
//			System.out.println(ret.get(i));
//		}
//		return ret;
//    }
//	private boolean backtracking(GraphNode from, int edgesSoFar, int totalEdges, List<String> stringSoFar) {
//		if (edgesSoFar == totalEdges) {
//			List<String> list = new ArrayList<>(stringSoFar);
//			list.add(from.key);
//			ret = list;
//			return true;
//		}
//		Map<String, GraphNode> chil = from.children;
//		if (chil.size() == 0) {
//			return false;
//		}
//		List<String> children = new ArrayList<>();
//		children.addAll(chil.keySet());
//		Collections.sort(children);
//		for (String str : children) {
//			GraphNode cur = chil.get(str);
//			List<String> list = new ArrayList<>(stringSoFar);
//			list.add(from.key);
//			chil.remove(str);
//			if (backtracking(cur, edgesSoFar + 1, totalEdges, list)) {
//				return true;
//			} else {
//				chil.put(str, cur);
//				return false;
//			}
//		}
//		return false;
//	}
//	private GraphNode buildGraph(String str, Map<String, GraphNode> map) {
//		if (map.containsKey(str)) {
//			return map.get(str);
//		} else {
//			GraphNode ret = new GraphNode(str);
//			map.put(str, ret);
//			return ret;
//		}
//	}
//	private class GraphNode {
//		String key;
//		Map<String, GraphNode> children;
//		public GraphNode (String newKey) {
//			key = newKey;
//			children = new HashMap<>();
//		}
//	}
//}


	//	List<String> ret;
//	public List<String> findItinerary(String[][] tickets) {
//        // build graph
//		Map<String, GraphNode> map = new HashMap<>();
//		Map<String, Boolean> edges = new HashMap<>();
//		for (int i = 0 ; i < tickets.length ; i ++) {
//			String edge = new String(tickets[i][0] + tickets[i][1]);
//			edges.put(edge, false);
//			GraphNode from = new GraphNode(tickets[i][0]);
//			GraphNode to = new GraphNode(tickets[i][1]);
//			if (map.containsKey(tickets[i][0])) {
//				from = map.get(tickets[i][0]);
//			} else {
//				map.put(tickets[i][0], from);
//			}
//			if (map.containsKey(tickets[i][1])) {
//				to = map.get(tickets[i][1]);
//			} else {
//				map.put(tickets[i][1], to);
//			}
//			from.children.put(tickets[i][1], to);
//		}
//		// walk graph lexically and return the first result
//		ret = new ArrayList<>();
//		
//		Map<String, GraphNode> rootChil = map.get("JFK").children;
//		List<String> rootChilList = new ArrayList<>();
//		rootChilList.addAll(rootChil.keySet());
//		Collections.sort(rootChilList);
//		for (String str : rootChilList) {
//			GraphNode cur = rootChil.get(str);
//			String fromTo = new String("JFK" + str);
//			edges.put(fromTo, true);
//			List<String> tmp = new ArrayList<>();
//			tmp.add("JFK");
//			backtracking(cur, 1, tickets.length, tmp, edges);
//			if (ret.size() > 0) {
//				return ret;
//			} else {
//				edges.put(fromTo, false);
//			}
//		}
//		return ret;
//    }
//	private void backtracking(GraphNode from, int edgesSoFar, int totalEdges, List<String> stringSoFar, Map<String, Boolean> edges) {
//		if (edgesSoFar == totalEdges) {
//			List<String> list = new ArrayList<>(stringSoFar);
//			list.add(from.key);
//			ret = list;
//			return;
//		}
//		Map<String, GraphNode> chil = from.children;
//		if (chil.size() == 0) {
//			return;
//		}
//		List<String> children = new ArrayList<>();
//		children.addAll(chil.keySet());
//		Collections.sort(children);
//		for (String str : children) {
//			GraphNode cur = chil.get(str);
//			String fromTo = new String(from.key + str);
//			if (!edges.get(fromTo)) {
//				List<String> list = new ArrayList<>(stringSoFar);
//				list.add(from.key);
//				backtracking(cur, edgesSoFar + 1, totalEdges, list, edges);
//				if (ret.size() > 0) {
//					return;
//				} else {
//					edges.put(fromTo, false);
//				}
//			}
//		}
//	}
//	private class GraphNode {
//		String key;
//		Map<String, GraphNode> children;
//		public GraphNode (String newKey) {
//			key = newKey;
//			children = new HashMap<>();
//		}
//	}
//}


	//	List<String> ret;
//	public List<String> findItinerary(String[][] tickets) {
//        // build graph
//		Map<String, GraphNode> map = new HashMap<>();
//		for (int i = 0 ; i < tickets.length ; i ++) {
//			GraphNode from = new GraphNode(tickets[i][0]);
//			GraphNode to = new GraphNode(tickets[i][1]);
//			if (map.containsKey(tickets[i][0])) {
//				from = map.get(tickets[i][0]);
//			} else {
//				map.put(tickets[i][0], from);
//			}
//			if (map.containsKey(tickets[i][1])) {
//				to = map.get(tickets[i][1]);
//			} else {
//				map.put(tickets[i][1], to);
//			}
//			from.children.put(tickets[i][1], to);
//		}
//		// walk graph lexically and return the first result
//		List<String> tmp = new ArrayList<>();
//		ret = new ArrayList<>();
//		backtracking(map.get("JFK"), 0, tickets.length, tmp);
//		return ret;
//    }
//	private void backtracking(GraphNode from, int edgesSoFar, int totalEdges, List<String> stringSoFar) {
//		if (edgesSoFar == totalEdges) {
//			stringSoFar.add(from.key);
//			ret = stringSoFar;
//			return;
//		}
//		Map<String, GraphNode> chil = from.children;
//		List<String> children = new ArrayList<>();
//		children.addAll(chil.keySet());
//		Collections.sort(children);
//		for (String str : children) {
//			GraphNode cur = chil.get(str);
//			chil.remove(str);
//			List<String> list = new ArrayList<>(stringSoFar);
//			list.add(from.key);
//			backtracking(cur, edgesSoFar + 1, totalEdges, list);
//			if (ret.size() > 0) {
//				return;
//			}
//			chil.put(str, cur);
//		}
//	}
//	private class GraphNode {
//		String key;
//		Map<String, GraphNode> children;
//		public GraphNode (String newKey) {
//			key = newKey;
//			children = new HashMap<>();
//		}
//	}
//}
