package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10799_쇠막대기 {
	static Deque<Character> stack = new ArrayDeque<>();
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				stack.add(c);
			}else {
				stack.pop();
				if(str.charAt(i-1) == '(') {
					ans += stack.size();
				}else {
					ans += 1;
				}
				
			}
		}
		
		System.out.println(ans);
	}

}
