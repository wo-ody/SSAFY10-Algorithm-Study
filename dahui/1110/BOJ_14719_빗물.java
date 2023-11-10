package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	static int H,W,ans;
	static int[] height;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		height = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		boolean block = false;
		boolean firstBlock = false;
		
		for(int i=1; i<=H; i++) {
			block = false;
			firstBlock = false;
			cnt = 0;
			for(int j=0; j<W; j++) {
				if(height[j] >= i && !block) { //이전이 블록이 아니고 현재 블록이라면
					firstBlock = true;
					block = true;
					ans += cnt;
					cnt = 0;
				}else if(height[j] < i && firstBlock) { //빈칸이고 블럭을 만난 적이 있다면 
					cnt++;
					block = false;
				}//이전도 블록이고 현재도 블록이면 아무것도 안해도 됨 
			}
    }
		System.out.println(ans);
	}	
}
