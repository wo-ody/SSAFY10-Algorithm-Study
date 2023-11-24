package month10.day29;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10655_마라톤1 {
	
	static int N, sum, max;
	static int[][] pos;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		pos = new int[N][2];
		dist = new int[N-1];
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N-1; i++) {
			dist[i] = getDist(pos[i], pos[i+1]);
			sum+=dist[i];
		}
		
		for (int i = 0; i < N-2; i++) {
			int go = dist[i] + dist[i+1];
			int jump = getDist(pos[i],pos[i+2]);
			max = Math.max(max, go - jump);
		}
		
		System.out.println(sum - max);
	}
	
	static int getDist(int[] n1,int[] n2) {
		return Math.abs(n1[0]-n2[0])+Math.abs(n1[1]-n2[1]);
	}
}