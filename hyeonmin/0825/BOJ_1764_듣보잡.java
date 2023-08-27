package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)) {
				list.add(tmp);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (String s : list) {
			System.out.println(s);
			
		}
	}

}
