package BOJ2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, CNT[];
	static int[][] paper;
	static int[] dx = {0,1,0,1};	//1,2,3,4
	static int[] dy = {0,0,1,1};	//1,2,3,4
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		CNT = new int[2];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(paper);
		System.out.println(CNT[0]);
		System.out.println(CNT[1]);
	}
	
	static void divide(int[][] arr) {
		int init = arr[0][0];
		//기저조건: 색종이 길이가 1
		if(arr[0].length == 1) {
			CNT[init]++;
			return;
		}
		
		boolean flag = true;
		int len = arr[0].length;
		//색종이 색 확인
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(arr[i][j] != init) flag = false;	
			}
		}
		
		//기저조건: 모든 배열이 같은 색
		if(flag) {
			CNT[init]++;
			return;
		}
		else {
			//재귀 어게인
			//원래 배열 크기의 [1/2][1/2]
			int[][][] d_arr = new int[4][len/2][len/2];
			
			for(int k=0; k<4; k++) {
				for(int i=0; i<len/2; i++) {
					for(int j=0; j<len/2; j++) {
						d_arr[k][i][j] = arr[i+dy[k]*(len/2)][j+dx[k]*(len/2)];
					}
				}
				divide(d_arr[k]);
			}
		}
	}
}
