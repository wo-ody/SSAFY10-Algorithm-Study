package algorithm2024.mar.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_25192_인사성밝은곰곰이 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String chat = br.readLine();

			if(chat.equals("ENTER")){
				set = new HashSet<>();
			}else{
				if(!set.contains(chat)){
					ans ++;
				}
				set.add(chat);
			}
		}
		System.out.println(ans);
	}
}
