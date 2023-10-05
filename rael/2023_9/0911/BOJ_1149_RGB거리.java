import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	final static int R = 0;
	final static int G = 1;
	final static int B = 2;
	
	static int[][] cost;
	static int[][] memoi;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		memoi = new int[N][3];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			cost[i][R] = Integer.parseInt(st.nextToken());
			cost[i][G] = Integer.parseInt(st.nextToken());
			cost[i][B] = Integer.parseInt(st.nextToken());
		}
		
		memoi[0][R] = cost[0][R];
		memoi[0][G] = cost[0][G];
		memoi[0][B] = cost[0][B];
		
		
		System.out.println(Math.min(Paint_cost(N- 1, R), Math.min(Paint_cost(N - 1, G), Paint_cost(N - 1, B))));
	}
	
	static int Paint_cost(int N, int color) {

		if(memoi[N][color] == 0) {
			if(color == R) {
				memoi[N][R] = Math.min(Paint_cost(N - 1, G), Paint_cost(N - 1, B)) + cost[N][R];
			}
			else if(color == G) {
				memoi[N][G] = Math.min(Paint_cost(N - 1, R), Paint_cost(N - 1, B)) + cost[N][G];
			}
			else {
				memoi[N][B] = Math.min(Paint_cost(N - 1, R), Paint_cost(N - 1, G)) + cost[N][B];
			}
		}
		
		return memoi[N][color];
	}
}
