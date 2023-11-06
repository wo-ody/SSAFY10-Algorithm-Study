import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] numbers = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(numbers[j] < numbers[i]) {
						int tmp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = tmp;
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
		
	}
}
