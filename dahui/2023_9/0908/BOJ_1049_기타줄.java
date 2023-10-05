import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
    
		int set = 1000;
		int single = 1000;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			set = Math.min(set, Integer.parseInt(st.nextToken()));
			single = Math.min(single, Integer.parseInt(st.nextToken()));
		}
		
		int A, B, C;
		
		if(N % 6 == 0) {
			A = set * (N / 6);
		}else {
			A = set * ((N / 6) + 1);
		}
		B = (set * (N / 6)) + (single * (N % 6));
		C = single * N;
		
		int result = Math.min(A, Math.min(B, C));
		
		System.out.println(result);
	}

}
