import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, L, answer;
	static int[][] waterhalls;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		waterhalls = new int[N][2];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			waterhalls[i][0] = Integer.parseInt(st.nextToken());
			waterhalls[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(waterhalls, (int[] o1, int[] o2)-> {
			return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
		});
		
		int cover = 0;
		for(int i=0; i<N; i++) {
			if(waterhalls[i][0] > cover) cover = waterhalls[i][0];
			
			if(waterhalls[i][1] >= cover) {
				while(waterhalls[i][1] > cover) {
					cover += L;
					answer++;
				}
			}
		}
		System.out.println(answer);	
	}
}
