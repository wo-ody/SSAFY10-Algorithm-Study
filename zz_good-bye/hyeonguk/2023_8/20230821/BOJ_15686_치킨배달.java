import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, homeSize, chickenSize, answer;
	static int map[][];
	static List<int[]> home;
	static List<int[]> chicken;
	static int[][] tgt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		map = new int[N][N];
		tgt = new int[M][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new int[] {i, j});
				}else if(map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
				
			}
		}
		
		answer = Integer.MAX_VALUE;
		homeSize = home.size();
		chickenSize = chicken.size();
		comb(0, 0);
		
		System.out.println(answer);
	}
	
	static void comb(int tgtIdx, int srcIdx) {
		if(tgtIdx == M) {
			// complete code
			int distance = calcDistance();
			answer = Math.min(answer, distance);
			return;
		}
		
		if(srcIdx == chickenSize) {
			return;
		}
		
		tgt[tgtIdx][0] = chicken.get(srcIdx) [0];
		tgt[tgtIdx][1] = chicken.get(srcIdx) [1];
		
		comb(tgtIdx+1, srcIdx+1);
		comb(tgtIdx, srcIdx+1);
		
	}
	
	// 치킨집과 집들 사이의 거리를 계산
	static int calcDistance() {
		int sum = 0;
		for(int[] nowHome : home) {
			int tmp = Integer.MAX_VALUE;
			for(int[] nowTgt: tgt) {
				tmp = Math.min(tmp, Math.abs(nowTgt[0]-nowHome[0]) + Math.abs(nowTgt[1]- nowHome[1]));
			}
			sum += tmp;
		}
		return sum;
	}
}
