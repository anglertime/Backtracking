package snapchat2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingDNASeq {
	public List<String> repeatingDNASeq (String s) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0 ; i <= s.length() - 10 ; i ++) {
			String cur = s.substring(i, (i + 9) + 1);
			if (map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
			} else {
				map.put(cur, 1);
			}
		}
		List<String> res = new ArrayList<>();
		for (String str : map.keySet()) {
			if (map.get(str) > 1) {
				System.out.println(str);
				res.add(str);
			}
		}
		return res;
	}
}
