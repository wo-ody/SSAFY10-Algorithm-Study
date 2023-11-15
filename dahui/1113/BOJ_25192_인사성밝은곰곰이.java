package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_25192_인사성밝은곰곰이 {
	static HashSet<String> people = new HashSet<>();
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				ans += people.size();
				people.clear();
			}else {
				people.add(str);
			}
		}
		
		ans += people.size();
		
		System.out.println(ans);

	}

}
