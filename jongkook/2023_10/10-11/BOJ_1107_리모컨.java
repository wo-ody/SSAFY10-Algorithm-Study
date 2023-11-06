package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String channel = br.readLine();
		int size = channel.length();				 
		int T = Integer.parseInt(br.readLine());
		int[] numbers = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int t = 0; t < T; t++) numbers[t] = Integer.parseInt(st.nextToken());
		
		int res = 0;
		String leggo = "";
		
		for(int i = 0; i < size; i++) {
			int number = channel.charAt(i) - '0';
			
			int increaseNumber = channel.charAt(i) - '0';
			int decreaseNumber = channel.charAt(i) - '0';
			// 배열안에 동일한 값이 없다
			// 즉, 해당 값은 고장나지 않았다.
			if(isNotSame(number, numbers)) {
				leggo += number;
				res++;
			}
			else {
				while(true) {					
					if(isNotSame(++increaseNumber, numbers)) {
						number = increaseNumber;
						break;
					}					
					
					if(isNotSame(--decreaseNumber, numbers)) {
						number = decreaseNumber;
						break;
					}					
				}
				leggo += number;
				res++;
			}
		}
		int number = Integer.parseInt(leggo);
		int dest = Integer.parseInt(channel);
		System.out.println(dest == 100 ? 0 : Math.max(number, dest) - Math.min(number, dest) + res);

	}
	static boolean isNotSame(int x, int[] array) {
		for(int i = 0; i < array.length; i++) if(array[i] == x) return false;
		return true;
	}
}
