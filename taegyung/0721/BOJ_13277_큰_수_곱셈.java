package net.acmicpc;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_13277_큰_수_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		System.out.println(a.multiply(b));
	}
}
