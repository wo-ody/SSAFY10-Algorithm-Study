/*
 *  08.14 김창희
 *  BOJ_2230_수고르기
 *
 *  [풀이]
 *  1. 두 수를 뺀값이 M과 가까워야 한다.
 *  2. 두 값만 보면 되므로 투포인터를 활용한다.
 *  3. left, right 모두 0,0부터 시작해서 값의 차이가 M보다 커지면 left를 증가시키고 M보다 작아지면 right를 증가시킨다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(number);
		
		int answer = Integer.MAX_VALUE;

		int left = 0, right = 0;
		while (right < n) {
			int cal = number[right] - number[left];

			if (cal > m) {
				left++;
				answer = Math.min(answer, cal);
			} else if (cal < m) {
				right++;
			} else {
				answer = m;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
