import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, s;
	static  int[] arr;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int sum = 0, start = 0, end = 0;

		while (true) {
			if (sum >= s) {  // 합이 s 이상이 됐을 경우
				answer = Math.min(answer, end - start);  // 최소 길이 계산
				sum -= arr[start++];  // 목표를 만족시켰으므로 숫자 감소
			}
			else if (end == n)
				break;
			else  // 합이 s에 미치지 못하면 end++ -> 숫자를 더 추가
				sum += arr[end++];
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}
