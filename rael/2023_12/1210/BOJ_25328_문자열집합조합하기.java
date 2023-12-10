import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static int k;
	static Map<String, Integer>map = new HashMap<String, Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String X = sc.nextLine();
		String Y = sc.nextLine();
		String Z = sc.nextLine();
		k = sc.nextInt();
		
		// X, Y, Z에 대한 부분문자열 생성하고 빈도 검사
		combi(X.toCharArray(), new char[k], 0, 0);
		combi(Y.toCharArray(), new char[k], 0, 0);
		combi(Z.toCharArray(), new char[k], 0, 0);
		
		// map의 String에 대해 오름차순 정렬
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((e1, e2)->e1.getKey().compareTo(e2.getKey()));
		
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (Map.Entry<String, Integer> e : list) {
			if(e.getValue() >= 2) { 
				sb.append(e.getKey()).append('\n');
				flag = true;
			}
		}
		if(flag) System.out.print(sb);
		else System.out.println(-1);
	}
	
	static void combi(char[] cards, char[] result, int idx, int start) {
		// 기저조건: 부분문자열 생성 완료
		if(idx == k) {
			String res = String.valueOf(result); //완성된 부분문자열을 string으로 변경
			map.putIfAbsent(res, 0); //처음 나온 부분문자열이면 빈도 1
			map.put(res, map.get(res)+1); //더 나왔을 때 빈도 늘리기
			
			return;
		}
		for (int i = start; i < cards.length; i++) {
			result[idx] = cards[i];
			combi(cards, result, idx+1, i+1);
		}
	}

}
