import java.util.Scanner;

public class BOJ_2018_수들의합5 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();

		int count = 1;

		int start_index = 1;
		int end_index = 1;
		int sum = 1;

		while(end_index != N) {
			if(sum==N) {	// count++
				count++;
				end_index++;
				sum += end_index;
			} else if (sum>N) {	// start_index 이동
				sum -= start_index;
				start_index++;
			} else {			// end_index 이동
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);
	}
}
