package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	static int N, res;
	static int[] weight, sorted;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int T = 1; T <= tc; T++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			sorted = new int[N];
			isSelected = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			res = 0;
			perm(0);

			sb.append("#").append(T).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	// 왼쪽, 오른쪽 관계없이 올려놓는 순서를 정하는 '순열'함수
	private static void perm(int cnt) {
		if (cnt == N) { // 기저조건
			scale(0, 0, 0);
		}
		// 순열 만들기
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			sorted[cnt] = weight[i]; // sorted: 순열결과를 저장(인덱스 저장이 아닌 값 저장)
			isSelected[i] = true; // 현재 인덱스 선택처리
			perm(cnt + 1);
			isSelected[i] = false; // 선택 처리 초기화
		}
	}

	// 순열함수의 결과값을 이용해서 양팔저울에 올릴 경우의 수를 계산하는 '부분집합'함수
	private static void scale(int cnt, int left, int right) {
		if (left < right)
			return; // 가지치기(현재 왼쪽의 무게보다 오른쪽의 무게가 많을 때)
		if (cnt == N) { // 기저조건
			res++; // 경우의 수 증가
			return;
		}
		scale(cnt + 1, left, right + sorted[cnt]); // 오른쪽에 올렸을 때
		scale(cnt + 1, left + sorted[cnt], right); // 왼쪽에 올렸을 때
	}
}
