import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static double answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] vote = new int[n];
		for(int i = 0; i < n; i++)
			vote[i] = Integer.parseInt(br.readLine());
		System.out.println(solve(vote));

	}
	
	static int solve(int[] arr) {
		if(n == 0)  // 아무 의견이 없는 경우
			return n;  // n = 0;
		Arrays.sort(arr);  // 상위와 하위 의견을 걸러내기 위해 정렬
		int tm = (int)Math.round((n * 0.3) / 2);  // 절사 평균 15%
		arr = Arrays.copyOfRange(arr, tm, n - tm);  // 상위 및 하위 15% 제외한 배열
		for (int i : arr) answer += i;  // 잘린 배열에서의 합
		return (int)Math.round(answer / arr.length);  // 평균 계산
	}
}
