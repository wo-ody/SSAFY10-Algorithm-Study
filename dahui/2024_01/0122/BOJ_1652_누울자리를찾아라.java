package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//짐을 만나기 전까지 2칸이 되는지 
public class BOJ_1652_누울자리를찾아라 {
	static int N;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		int rCnt = 0;
		int cCnt = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			int o = 0;
			for(int j=0; j<N; j++ ) {
				Character c = str.charAt(j);
				arr[i][j] = c;
				
				if(c == '.') o++;
				else {
					if(o >= 2) rCnt++;
					o = 0;
				}
			}
			if( o >= 2 ) rCnt++;
		}
		
		for(int i=0; i<N; i++) {
			int o = 0;
			for(int j=0; j<N; j++) {
				Character c = arr[j][i];
				
				if(c == '.') o++;
				else {
					if(o>=2) cCnt++;
					o = 0;
				}
			}
			if( o >= 2 ) cCnt++;
		}
		
		sb.append(rCnt).append(" ").append(cCnt);
		System.out.println(sb);

	}

}
