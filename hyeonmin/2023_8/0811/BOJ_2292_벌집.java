import java.util.Scanner;

public class BOJ_2292_벌집 {

	public static void main(String[] args) {
		int N=new Scanner(System.in).nextInt(), a=1;
		// 1  2   3   4   5
		// 1  7  19  37  61
		// 6x1 6x2 6x3 6x4
		/* 1 : 1
		 * 2 : 2~7  6ea
		 * 3 : 8~19  12ea
		 * 4 : 20~37  18ea
		 * 5 : 38~61  24ea
		 */
		while(N>1)N-=a++*6;
		System.out.println(a);
	}

}
