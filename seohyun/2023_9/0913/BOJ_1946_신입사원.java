import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int T,N;
	static int[][] map;
	
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][2];
			result = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[i][0] = a;
				map[i][1] = b;
			}
			
			// 함수 시작
			simulation();
			System.out.println(result + 1);
		}
	}
	
	static void simulation() {
		
		Arrays.sort(map, (o1, o2) -> o1[0] - o2[0]);
		int min_value = map[0][1];
		
		for (int i = 1; i < N; i++) {
			if(map[i][1] > min_value) continue;
			else {
				result++;
				min_value = Math.min(min_value, map[i][1]);
			}
		}
		
	}
	
	


}
