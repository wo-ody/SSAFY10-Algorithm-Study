package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_17615_볼_모으기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());		
		ArrayList<Character> red = new ArrayList<>();
		ArrayList<Character> blue = new ArrayList<>();
		char[] chr = br.readLine().toCharArray();
		for(int i = 0; i < len; i++) {
			red.add(chr[i]);
			blue.add(chr[i]);
		}
		
		int rMin = 0;
		int bMin = 0;
		
		// 빨간 색을 먼저 뽑을 경우
//		for(int i = len - 2; i >= 0; i--) {		
//			if(red.get(i) == 'R' && red.get(i+1) == 'B') {
//				red.remove(i);
//				red.add('R');
//				rMin++;
//			}
//		}
		for(int i = len - 2; i >= 0; i--) {		
			if(chr[i] == 'R' && chr[i+1] == 'B') {
				chr[i] = 'B';
				rMin++;
			}
		}
		
		// 파란 색을 먼저 뽑을 경우
		for(int i = len - 2; i >= 0; i--) {		
			if(chr[i] == 'B' && chr[i+1] == 'R') {
				chr[i] = 'R';
				bMin++;
			}
		}

//		System.out.println(rMin + " " + bMin);
		System.out.println(rMin > bMin ? bMin : rMin);
		
	}

}
