import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int k;
	static String str;
	
	public static void main(String[] args) throws IOException{
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			k = Integer.parseInt(br.readLine());
			str = br.readLine();
			sb.append("#").append(t).append(" ");
			solve();
		}
		System.out.println(sb);
	}
	
	static void solve() {  // trie는 모르겠고 그냥 문제에서 주어진대로 해결함
		List<String> suffix = new ArrayList<>();
		for(int i = 0; i < str.length(); i++)  // 순차적으로 접미어 구해서 리스트에 저장
			suffix.add(str.substring(i));
		Collections.sort(suffix);  // 사전적으로 정렬
		try {
			sb.append(suffix.get(k-1)).append("\n");  // 사전적으로 정렬 됐을 때 k번 째(인덱스 상 k-1) 저장
		} catch(Exception e) {
			sb.append("none").append("\n");  // 문자열이 존재하지 않는다면 -> 하지만 tc에는 그런 케이스는 존재하지 않음 -> 해당 예외 처리하지 않아도 정답
		}
	}
}
