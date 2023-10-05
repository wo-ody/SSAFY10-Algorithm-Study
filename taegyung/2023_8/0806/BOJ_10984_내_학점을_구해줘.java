package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10984_내_학점을_구해줘 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			double sum = 0;
			int sum_subject = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				double G = Double.parseDouble(st.nextToken());
				sum += C * G;
				sum_subject += C;
			}
			System.out.printf("%d %.1f%n", sum_subject, sum / sum_subject);
//			System.out.println(sum_subject + " " + sum / sum_subject);
		}
	}
}
