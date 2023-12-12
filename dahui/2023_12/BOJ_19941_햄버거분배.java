package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//왼쪽 사람부터 자신이 먹을 수 있는 가장 왼쪽의 버거를 먹을 수 있게 한다.
//식탁 길이 N길이의 boolean 배열 -> 먹은 햄버거 1, 사람 1,  안 먹은 햄버거1
//20*20000 
public class BOJ_19941_햄버거분배 {
	static boolean[] burger;
	static int N,K,ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		String table = br.readLine();
		burger = new boolean[N];
		
		for(int i=0; i<N; i++) {
			if(table.charAt(i) == 'H') burger[i] = true;
		}
		
		for(int i=0; i<N; i++) {
			if(table.charAt(i) == 'H') { //사람이라면
				for(int j=-K; j<=K; j++) {
					if(i+j < 0 || i+j >= N) continue; //식탁을 벗어나면 패스
					if(!burger[i+j]) { //안먹은 버거라면 먹은 버거로 바꾸고 다음으로
						burger[i+j] = true;
						ans++;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
