import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, C, result;
	private static int[] house;

	private static void binarySearch(int min, int max) {
		while (min <= max) {
			int mid = (min + max) / 2;

			int start = 0; // 제일 처음 공유기는 무조건 설치
			int count = 1; // 제일 첫 집에 공유기를 설치했기 때문에 count = 1

			for (int i = 1; i < N; i++) {
				if (house[i] - house[start] >= mid) {
					start = i;
					count++;
				}
			}

			if (count < C) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		result = min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		house = new int[N];

		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		// 이분정렬을 위한 오름차순 정렬
		Arrays.sort(house);

		binarySearch(1, house[N - 1]);

		System.out.println(result - 1);
	}
}
