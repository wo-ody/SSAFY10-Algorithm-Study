import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lst = new int[T];
		for(int t = 0; t < T; t++) lst[t] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(lst);
		int sum = 0;
		for(int t = 0; t < T; t++) for(int j = 0; j <= t; j++) sum += lst[j];

		System.out.println(sum);
	}

}
