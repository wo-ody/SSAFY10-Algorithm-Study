package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	static ArrayList<int[]> steps;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		steps = new ArrayList<int[]>();
		
		BigInteger count = new BigInteger("2");
		System.out.println(count.pow(n).subtract(new BigInteger("1")));
		
		if(n<=20) {
		hanoi(n, 1, 3, 2);
		
		for(int i=0; i<steps.size(); i++) {
			int[] step = steps.get(i);
			System.out.println(step[0] + " " + step[1]);
		}
		}
		
		
	}
	
	static void hanoi(int n, int from, int to, int via) { //시작, 목적지, 중간  
		//기저조
		if(n == 1) {
			steps.add(new int[] {from, to});
		}else {
			hanoi(n-1, from, via, to);
			steps.add(new int[] {from, to});
			hanoi(n-1, via, to, from);
		}
	}

}
