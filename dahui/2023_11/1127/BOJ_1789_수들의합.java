import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		int N = 1;
		while(true) {
			if(S >= N) S -= N;
			else break;
			N++;
		}
		System.out.println(N-1);
	}

}
