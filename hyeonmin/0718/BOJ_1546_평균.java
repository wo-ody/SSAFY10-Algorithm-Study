import java.util.Scanner;

public class BOJ_1546_Æò±Õ {

	public static void main(String[] args) {
		// N <= 1000
		// ¼ºÀû
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double maxN = 0;
		double sum = 0;
		
		double[] array = new double[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextDouble();
			maxN = Math.max(maxN, array[i]);
		}
		
		for (int i = 0; i < N; i++) {
			sum += array[i] / maxN * 100;
		}
		System.out.println(sum/N);
		
		
		
	}

}
