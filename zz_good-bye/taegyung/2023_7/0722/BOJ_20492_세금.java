package net.acmicpc;

import java.util.Scanner;

public class BOJ_20492_세금 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Price = sc.nextInt();
		System.out.println((int) (Price * 0.78) + " " + (int) (Price * 0.956));
	}
}
