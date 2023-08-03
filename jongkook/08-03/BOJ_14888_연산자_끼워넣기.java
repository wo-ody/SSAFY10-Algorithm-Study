package baekjoon;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14888_연산자_끼워넣기 {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int[] numbers, operators;
	static int line, num;
	public static void main(String[] args) throws IOException {
		// 더하기 빼기 곱하기 나누기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		line = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		numbers = new int[line];
		operators = new int[4]; 
		// 곱할 수 들
		for(int i = 0; i < line; i++) numbers[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		// 연산자의 갯수
		for(int i = 0; i < 4; i++) operators[i] = Integer.parseInt(st.nextToken());
		
		operator(numbers[0], 1);
		System.out.println(MAX);
		System.out.println(MIN);
		
	}
	static void operator(int num, int idx) {
		if(idx == line) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		for(int i = 0; i <4; i++) {
			if(operators[i] > 0) {
				operators[i]--;
				switch(i){
					case 0 : 
						operator(num + numbers[idx], idx + 1);
						break;
					case 1 :
						operator(num - numbers[idx], idx + 1);
						break;
					case 2 :
						operator(num * numbers[idx], idx + 1);
						break;
					case 3 :
						operator(num / numbers[idx], idx + 1);
						break;
				}
				operators[i]++;
			}
		}
	}
}
