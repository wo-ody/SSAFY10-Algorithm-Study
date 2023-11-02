package algorithm2023.aug.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1057_토너먼트 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int jm = Integer.parseInt(st.nextToken());
		int hs = Integer.parseInt(st.nextToken());
		List<Integer> team = new ArrayList<>();
		for(int i= 1;i<=N;i++) {
			team.add(i);
		}
		int cnt = 1;
		loop: while(true) {
			int sz = team.size();
			List<Integer> round = new ArrayList<>();
			for(int i= 0;i<sz-1;i+=2) {
				int a = team.get(i);
				int b= team.get(i+1);
				if((a==jm&&b==hs)||(a==hs&&b==jm)) {
					break loop;
				}
				if(a==jm||b==jm) {
					round.add(jm);
				}else if(a==hs||b==hs) {
					round.add(hs);
				}else {
					round.add(a);
				}
			}
			if(sz%2==1) {
				round.add(team.get(sz-1));
			}
			team = round;
			cnt++;
		}
		System.out.println(cnt);
	}
}
