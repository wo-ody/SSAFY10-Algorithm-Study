import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[n + 1];  // 초기 값은 모두 false

		for(int i = 2; i * i < n + 1; i++) {  //  1은 소수가 아니므로 제외, 2 ~ sqrt(n): 합성수 n에서 1을 제외한 가장 작은 약수 x는 sqrt(n) 이하, i**2까지 돌면 자연스럽게 sqrt(n) 이하까지 탐색 가능
			if(!prime[i]) {
				for (int j = i * i; j < n + 1; j += i)  // i의 제곱보다 작은 i의 배수들은 i보다 작은 소인수들에 의해 미리 처리되므로 제곱부터 배수들을 탐색
					prime[j] = true;  // 다음 탐색 범위에서 제외하기 위해 true 처리
			}
		}
		m = Integer.max(2, m);  // m과 n의 범위에 1이 들어가 있으므로 1일 경우 제외
		for(int i = m; i < n + 1; i++)
			if(!prime[i])
				sb.append(i).append("\n");
		
		System.out.println(sb);
	}
}
