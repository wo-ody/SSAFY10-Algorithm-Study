package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2852_NBA농구 {
	static int N,score1,score2,time1,time2,time0;
	static int winner;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			if(team == 1) score1++;
			else score2++;
			
			String str = st.nextToken();
			
			String[] t = str.split(":");
			int second = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
			
			if(winner==0) { //이전이 동점이었을 경우 이긴 쪽 바꿔주고 기준 시간 넣어주기 
				if(score1 > score2) {
					winner=1;
					time0 = second;
				}else {
					winner=2;
					time0 = second;
				}
			}else if(winner == 1) { //1팀이 이기고 있던 경우
				if(score1 == score2) { //동점으로 바뀌면
					time1 += (second-time0); //기준 시간과 현재 시간 차를 이긴시간에 더해주기
					winner = 0;
					time0 = second;
				} //그대로 1팀이 이기고 있다면 넘겨도 됨.
			}else { //2팀이 이기고 있던 경우
				if(score1 == score2) { //동점으로 바뀌면
					time2 += (second-time0);
					winner = 0;
					time0 = second;
				}
			}
		}
		//마지막 타임까지 이기고 있었다면
		if(winner == 1) {
			time1 += (48*60 - time0);
		}else if(winner == 2) {
			time2 += (48*60 - time0);
		}
		
		sb.append(String.format("%02d", time1/60)).append(":")
		.append(String.format("%02d", time1%60)).append("\n");
		sb.append(String.format("%02d", time2/60)).append(":")
		.append(String.format("%02d", time2%60)).append("\n");
		System.out.println(sb);
	}

}
