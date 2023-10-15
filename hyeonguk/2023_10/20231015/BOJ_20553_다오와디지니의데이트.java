import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, T;
	static long answer;
	static long[] places;
	static long[] distances;
	static long[] vibration;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		places = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			places[i] = Long.parseLong(st.nextToken());
		}
		
		distances = new long[N];
		for(int i=1; i<N; i++) {
			distances[i] = distances[i-1]+places[i];
		}
		
		vibration = new long[N];
		for(int i=0; i<N-1; i++) {
			vibration[i] = places[i]+places[i+1];
		}
		
		answer = Long.MIN_VALUE;
		for(int i=0; i<N-1; i++) {
      if(2*i > T) break;
			long tmp = Math.max(2*distances[i]+vibration[i]*((T-2*i)/2)-places[i], 2*distances[i]-places[i]);
			answer = Math.max(answer, tmp);
		}
		
		System.out.println(answer);
		
	}
}
