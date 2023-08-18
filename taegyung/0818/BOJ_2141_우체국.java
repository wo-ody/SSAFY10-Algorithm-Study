package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2141_우체국 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Long[][] village = new Long[N][2];
		int people_cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			village[i][0] = Long.parseLong(st.nextToken());
			village[i][1] = Long.parseLong(st.nextToken());
			people_cnt += village[i][1];
		}

		int middle = people_cnt / 2;
		if (people_cnt % 2 == 1)
			middle += 1;

		// 중간값 정해뒀으니까 이 값을 넘는 가장 빠른 숫자...? 이게 된다고...?

		Arrays.sort(village, (o1, o2) -> (int) (o1[0] - o2[0]));

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += village[i][1];
			if (cnt >= middle) {
				System.out.println(village[i][0]);
				break;
			}
		}
		// 이분탐색으로는 불가능함 -> 왼쪽 오른쪽 중 어디가 더 좋은 위치인지 알 수 없음

		// 그럼 모든 경우를 다 탐색하는걸 생각해봐야하나..?10만을..?

	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		int N = Integer.parseInt(br.readLine());
//		long[][] village = new long[N][2];
//		long start = Long.MAX_VALUE;
//		long end = Long.MIN_VALUE;
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 2; j++)
//				village[i][j] = Long.parseLong(st.nextToken());
//			start = Math.min(start, village[i][0]);
//			end = Math.max(end, village[i][0]);
//
//		}
//		long min_diffs = Long.MAX_VALUE;
//		long saveIdx = -1;
//		long middle = -1;
//		while (start <= end) {
//			middle = (start + end) / 2;
//			long sum = 0;
//			for (int i = 0; i < N; i++) {
//				sum += (village[i][0] - middle) * village[i][1];
//				// 총 합이 음수라면 왼쪽이 더 강세
//				// 양수라면 오른쪽이 더 강세
//			}
////			min_diffs = Math.min(min_diffs, sum);
////			if (min_diffs >= sum) {
////				min_diffs = sum;
////				end = middle - 1;
////				saveIdx = middle;
////			} else {
////				start = middle + 1;
////			}
////			if (Math.abs(sum) <)
//			if (sum > 0) {
//				if (Math.abs(sum) < min_diffs) {
//					saveIdx = middle;
//					min_diffs = Math.abs(sum);
//				}
//				start = middle + 1;
////				saveIdx = middle;
//			} else {
//				if (Math.abs(sum) <= min_diffs) {
//					saveIdx = middle;
//					min_diffs = Math.abs(sum);
//				}
//				saveIdx = middle;
//				end = middle - 1;
//			}
//
//		}
//		System.out.println(saveIdx);
//		System.out.println(middle);
//
//	}
}
