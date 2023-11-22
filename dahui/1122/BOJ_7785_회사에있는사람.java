package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_7785_회사에있는사람 {
	static HashSet<String> set = new HashSet<>();
	static int N;
	static StringBuilder sb = new StringBuilder();
	static String name;
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			name = st.nextToken();
			str = st.nextToken();
			
			if(str.equals("enter")) {
				set.add(name);
			}else {
				set.remove(name);
			}
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
		
		for (String str : list) {
			sb.append(str).append("\n");
		}
		System.out.println(sb);
  }
}
