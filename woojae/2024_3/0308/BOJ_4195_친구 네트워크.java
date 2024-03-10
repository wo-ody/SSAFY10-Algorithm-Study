package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_4195 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t;
	static int f;
	static HashMap<String, String> parents;
	static HashMap<String, Integer> child;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			f = Integer.parseInt(br.readLine());
			parents = new HashMap<>();
			child = new HashMap<>();
			
			for(int j = 0; j < f; j++) {
				st = new StringTokenizer(br.readLine());
				String friend1 = st.nextToken();
				String friend2 = st.nextToken();
				
				if(!parents.containsKey(friend1)) {
					parents.put(friend1, friend1);  // 부모를 자기 자신으로 초기화
					child.put(friend1, 1);  // 해당 노드의 자신은 자기 자신
				}
				
				if(!parents.containsKey(friend2)) {
					parents.put(friend2, friend2);
					child.put(friend2, 1);
				}
				sb.append(union(friend1, friend2)).append("\n");  //  속도 향상을 위해 Stringbuilder 사용
			}
		}
		System.out.println(sb);
	}
	
	static String find(String x) {
		if(parents.get(x).equals(x))  // 들어온 데이터의 부모가 자기 자신일 때
			return x;  // 더 이상 압축할 필요 없음
		parents.put(x, find(parents.get(x)));  // 그게 아니라면 압축 수행
		return parents.get(x);  // 압축 수행 결과 반환
	}
	
	static int union(String x, String y) {
		x = find(x);  // 부모 탐색
		y = find(y);
		
		if(x.equals(y))  // 두 부모가 같다면
			return child.get(y);  // y의 친구  수
		
		parents.put(y, x);  // 같지 않다면 압축 결과 반영 -> y의 부모를 x로 변경
		child.put(x, child.get(x) + child.get(y));  // x는 y라는 자식(친구)를 가졌으므로 x에 y의 친구수를 붙여줌
		return child.get(x);  // 최종적으로 압축된 결과 반환
	}
}
