package algol0918;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2112_보호필름 {

	static int T;
	static int D, W, K;
	static int [][] map;
	static int[] a0, a1;
	static int ans;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			D=scann.nextInt();
			W=scann.nextInt();
			K=scann.nextInt();
			map=new int[D][W];
			a0=new int[W];
			a1=new int[W];
			Arrays.fill(a1, 1);
			for (int i = 0; i <D; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j]=scann.nextInt();
				}
			}
			ans=-1;
			for (int i = 0; i <=K; i++) {
				dfs(0,0,i);
				if(ans!=-1){ break ;}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	// index 행에 약품 처리
	// k 약품 투입 행의 개수
	public static void dfs(int cnt, int index, int k) {
		
		//if(ans!=-1){ return ;} // 
		
		if(cnt==k){  // 약품처리 회수가 k가 되면 
			if(check()){
				ans=k;
			}
			return ;
		}
		// 0~D 행을 변경
		if(index==D){ return ;}
		
		int [] temp=new int[W];
		System.arraycopy(map[index], 0, temp, 0, W);
		System.arraycopy(a0, 0, map[index], 0, W);
		// index+1 번째줄에 약품처리  0
		dfs(cnt+1, index+1,k);
		System.arraycopy(a1, 0, map[index], 0, W);
		// index+1 번째줄에 약품처리  1
		dfs(cnt+1, index+1,k);
		// index+1 번째줄에 약품처리 안함 ,처리횟수 증가 안함
		System.arraycopy(temp , 0, map[index], 0, W);
		dfs(cnt, index+1,k);
	}
	
	public static boolean check(){
		for (int j = 0; j < W; j++) {// 칼럼별 검사!!
			int cnt=1;  // 자신 1
			for (int i = 1; i < D; i++) {
				if(map[i-1][j]==map[i][j]){
					cnt++;
				}else {
					cnt=1;  // 다른 번호로 시작 1
				}
				if(cnt==K){break;}
			}
			if(cnt<K){return false;}
		}
		return true;
	}
}