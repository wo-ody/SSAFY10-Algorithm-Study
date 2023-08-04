package algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24060_병합정렬 {

	private static int N, K;
	private static int[] A;
	private static int i, j, t;
	private static int count;
	private static int[] temp;

	private static void merge_sort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(arr, p, q);
			merge_sort(arr, q + 1, r);
			merge(arr, p, q, r);

		}

	}

	private static void merge(int[] arr, int p, int q, int r) {
		i = p;
		j = q + 1;
		t = 0;

		while (i <= q && j <= r) {
			if (arr[i] < A[j]) {
				temp[t++] = arr[i++];
			} else
				temp[t++] = arr[j++];
		}

		while (i <= q)
			temp[t++] = arr[i++];
		while (j <= r)
			temp[t++] = arr[j++];
		i = p;
		t = 0;
		while (i <= r) {
			arr[i++] = temp[t++];
			count++;

			if (count == K)

				System.out.println(arr[i - 1]);
		}

	}

	public static void main(String[] args) throws Exception {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		count = 0;
		temp = new int[N];
		merge_sort(A, 0, N - 1);

		// 출력
		// 배열 A에 K번째 저장되는 수를 출력한다.
		// 저장 횟수가 K보다 작으면 -1을 출력한다.

		// System.out.println(Arrays.toString(A));

		if (count < K)
			System.out.println(-1);

	}

}
