package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//홀수면 안된다. 4이상이면 AAAA로 다 채우고 마지막에 BB 
public class BOJ_1343_폴리오미노 {
	static StringBuilder sb = new StringBuilder();
	static StringBuilder temp = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		boolean fail = false;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c=='X') {
				temp.append(c);
			}else {
				int length = temp.length();
				temp.delete(0, temp.length());
				
				if(length%2 == 1) {
					System.out.println(-1);
					fail = true;
					break;
				}else {
					if(length!=0) {
						if(length%4!=0) {
							for(int j=0; j<length-2; j++) {
								sb.append('A');
							}
							sb.append("BB");
						}else {
							for(int j=0; j<length; j++) {
								sb.append('A');
							}
						}
					}
				}
				
				sb.append('.');
			}
		}
		
		int length = temp.length();
		temp.delete(0, temp.length());
		
		if(length%2 == 1) {
			System.out.println(-1);
			fail = true;
		}else {
			if(length!=0) {
				if(length%4!=0) {
					for(int j=0; j<length-2; j++) {
						sb.append('A');
					}
					sb.append("BB");
				}else {
					for(int j=0; j<length; j++) {
						sb.append('A');
					}
				}
			}
		}
		
		if(!fail) System.out.println(sb);
		
		

	}

}
