import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		loop1:
		for(int i = 0; i <= 50; i++)  // 모든 경우의 수에 대해 조사
			for(int j = 0; j <= 50; j++)
				for(int k = 0; k <= 50; k++) {
					if(a * i + b * j + c * k == n) {  // 조건을 만족하면 모든 반복 종료
						answer = 1;
						break loop1;
					}
				}
		System.out.println(answer);
	}
}
