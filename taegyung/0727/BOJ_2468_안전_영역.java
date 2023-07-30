package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972_다음_순열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArray = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		// 뒤에서부터 확인하면서 사전순으로 되어있으면 바꾼다?
		boolean flag = false;
		for (int i = N - 1; i >= 1; i--) { // 앞과 비교하기 위해
			if (numArray[i] > numArray[i - 1]) { // 앞 수가 더 작다면 -> 바꿔준다.
//				int tmp = numArray[i];
//				
//				numArray[i] = numArray[i - 1];
//				numArray[i - 1] = tmp; // 둘만 바꿔놓고

//				int tmp = numArray[i];
				for (int j = N - 1; j >= i; j--) {
					if (numArray[j] > numArray[i - 1]) {
						int tmp = numArray[i - 1];
						numArray[i - 1] = numArray[j];
						numArray[j] = tmp;
						break;
					}
				}
				// TODO 뒤를 sorting한다.

				// 어떻게 ? 아마
				int[] subArr = Arrays.copyOfRange(numArray, i, N);
//				for (int j : subArr)
//					System.out.println(j);
				Arrays.sort(subArr);
				for (int j = i; j < N; j++) {
					numArray[j] = subArr[j - i];
				}
				flag = true;
				break;
			}
		}
		if (flag) {
			for (int i = 0; i < N; i++) {
				System.out.print(numArray[i] + " ");
			}
		} else {
			System.out.println(-1);
		}

	}
}
