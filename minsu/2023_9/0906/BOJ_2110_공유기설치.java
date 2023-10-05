package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2110_공유기설치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);

		int[] houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);

		int left = 1;
		int right = houses[N - 1] - houses[0];
		int maxDistance = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			int count = 1;
			int lastHouse = houses[0];
			for (int i = 1; i < N; i++) {
				if (houses[i] - lastHouse >= mid) {
					count++;
					lastHouse = houses[i];
				}
			}

			if (count >= C) {
				maxDistance = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(maxDistance);
	}
}
