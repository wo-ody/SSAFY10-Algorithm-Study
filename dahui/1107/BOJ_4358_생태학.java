package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//100만개의 나무를 10000개중에 있는지 찾아보고 집어넣으려면 최악의 경우 대략 
//100만 * 1만 -> 10,000,000,000 -> 10억.....?
//HashMap -> containsKey O(1), get O(1) 이라서 100만으로 가능 
public class BOJ_4358_생태학 {
	static HashMap<String, Double> map = new HashMap<>();
	static double all; //총 개수
	static StringBuilder sb = new StringBuilder();
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			str = br.readLine();
			 if (str == null) {
			        break; // 빈 라인을 읽으면 루프를 종료
			  }
			all++; //총 개수 올리기 
			if(map.containsKey(str)) {
				double cnt = map.get(str); // 해당 나무의 원래 개수
				map.put(str, ++cnt); // 개수 변경
			}else {
				map.put(str, 1.0000);
			}
		}
		
		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for(String key : keyList) {
			sb.append(key).append(" ").append(String.format("%.4f", map.get(key)/all*100)).append("\n");
		}

		System.out.println(sb);
	}
}
