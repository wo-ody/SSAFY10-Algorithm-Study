package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_17413_단어뒤집기2 {
	static Deque<Character> stack = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c=='<') {
				int l = stack.size();
				for(int j=0; j<l; j++) {
					sb.append(stack.pop());
				}
				sb.append(c);
				while(true) {
					i += 1;
					c = str.charAt(i);
					sb.append(c);
					if(c == '>') break;
				}
			}else if(c == ' ') {
				int l = stack.size();
				for(int j=0; j<l; j++) {
					sb.append(stack.pop());
				}
				sb.append(c);
			}else {
				stack.push(c);
			}
		}
		
		int length = stack.size();
		
		for(int i=0; i<length; i++) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}

}
