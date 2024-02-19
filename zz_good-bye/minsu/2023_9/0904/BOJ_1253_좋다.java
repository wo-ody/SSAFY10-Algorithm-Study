package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		int result = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1; // 음수값이 있음에 유의!
			while (true) {
				// 현재 나(i)의 위치에 있는 경우
				if (left == i)
					left++;
				else if (right == i)
					right--;

				// 결과를 찾을 수 없다.
				if (left >= right)
					break;

				// 정렬이 되어 있으므로, 합이 더 크다면 더 작은 수와 더해주어야 하니까 왼쪽으로 움직이는 right 값을 변경
				if (numbers[left] + numbers[right] > numbers[i])
					right--;
				else if (numbers[left] + numbers[right] < numbers[i])
					left++;
				else { // 좋다!
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
