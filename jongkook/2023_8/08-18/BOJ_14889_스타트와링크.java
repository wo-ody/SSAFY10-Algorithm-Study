import java.util.*;
import java.io.*;
public class BOJ_14889_스타트와링크 {
	static int T, map[][], MIN = Integer.MAX_VALUE;
	static boolean[] chosen;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		map = new int[T][T];
		chosen = new boolean[T];
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < T; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		startLink(0, 0);
		System.out.println(MIN);
	}
	static void startLink(int start, int cnt) {
		if(cnt == T/2) {
			spec();
			return;
		}
		for(int i = start; i < T; i++) {
			if(chosen[i]) continue;
			chosen[i] = true;
			startLink(i, cnt+1);
			chosen[i] = false;
		}		
	}
	static void spec() {
		int start = 0;
		int link = 0;
		int diff = 0;
		for(int i = 0; i < T; i++) {
			for(int j = i+1; j < T; j++) {
				if(chosen[i] && chosen[j]) start += map[i][j] + map[j][i];
				if(!chosen[i] && !chosen[j]) link += map[i][j] + map[j][i];
			}
		}
		diff = Math.abs(start - link);
		MIN = MIN < diff ? MIN : diff;
	}
}
