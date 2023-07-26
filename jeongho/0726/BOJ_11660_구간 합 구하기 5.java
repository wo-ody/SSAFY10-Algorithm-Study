package algorithm2023.jul.day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_BOJ11660 {
	static int N, M,sum[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		sum = new int[N][N];
		M = Integer.parseInt(s[1]);
		for(int y = 0;y<N;y++) {
			s = br.readLine().split(" ");
			int lineSum = 0;
			for(int x = 0;x<N;x++) {
				int cur = Integer.parseInt(s[x]);
				lineSum+=cur;
				if(y==0) {
					sum[y][x] = lineSum;
				}else {
					sum[y][x] = sum[y-1][x]+lineSum;
				}
			}
		}
		for(int m = 0;m<M;m++) {
			s = br.readLine().split(" ");
			int y1 = Integer.parseInt(s[0])-1;
			int x1 = Integer.parseInt(s[1])-1;
			int y2 = Integer.parseInt(s[2])-1;
			int x2 = Integer.parseInt(s[3])-1;
			System.out.println(partSum(y1,x1,y2,x2));
		}
		// 입력 종료
	}
	
	static int partSum(int y1, int x1, int y2, int x2) {
		if(y1<0||x1<0||y2<0||x2<0)return 0;
		int res = sum[y2][x2];
		res -=partSum(0,0,y1-1,x2)+partSum(0,0,y2,x1-1)-partSum(0,0,y1-1,x1-1);
		
		return res;
	}
}