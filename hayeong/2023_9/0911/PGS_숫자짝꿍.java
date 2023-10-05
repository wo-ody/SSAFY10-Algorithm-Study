import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String solution(String X, String Y) {
		String answer = "";
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < X.length(); i++) {
			map1.put(X.charAt(i), map1.getOrDefault(X.charAt(i), 0) + 1);
		}

		for (int i = 0; i < Y.length(); i++) {
			map2.put(Y.charAt(i), map2.getOrDefault(Y.charAt(i), 0) + 1);
		}

		for(Character c : map1.keySet()) {
			if(!map2.containsKey(c)) continue;
			int cnt = Math.min(map1.get(c), map2.get(c));
			for(int i = 0; i<cnt; i++) {
				list.add(c);
			}
		}

		Collections.sort(list, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		if (sb.length() == 0) {
			answer = "-1";
			return answer;
		} else if(sb.toString().charAt(0) == '0') {
			answer = "0";
			return answer;
		}
		answer = sb.toString();

		return answer;
	}
}
