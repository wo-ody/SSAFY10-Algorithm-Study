package practice.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2309 {
	static int[] arr = new int[9];
	static int[] select = new int[7];
	static boolean flag = false; // 여러가지 정답이 발생할 수 있는 상황에서 한 가지 케이스에 대해서만 정답을 출력할 수 있도록 플래그 설정
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr); // 오름차순 출력을 위한 정렬
		search(0, 0, 0);
		System.out.println(sb);
	}

	static void search(int idx, int target, int sum) {
		if (target == 7) {
			if (sum == 100) {
				if (!flag) {  // 첫 번째로 발견한 정답이라면
					for (int i : select) sb.append(i).append("\n");  // 난쟁이들 저장
					flag = true;  // 다음 정답을 저장하지 않도록 플래그 활성화
				}
			}
			return;
		}
		if (idx == 9)
			return;

		select[target] = arr[idx];
		search(idx + 1, target + 1, sum + select[target]);
		search(idx + 1, target, sum);
	}
}
