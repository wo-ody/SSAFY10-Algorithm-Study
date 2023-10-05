import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] memoi = new int[N+8]; //idx 돈을 만들때 필요한 동전 개수 넣기
		int[] coin = {1,2,5,7};
		
		Arrays.fill(memoi, Integer.MAX_VALUE);
		memoi[0] = 0;
		memoi[1] = 1;
		memoi[2] = 1;
		memoi[5] = 1;
		memoi[7] = 1;

		for(int j=1; j<=N; j++) {
			memoi[j+1] = Math.min(memoi[j] + 1, memoi[j+1]);
			memoi[j+2] = Math.min(memoi[j] + 1, memoi[j+2]);
			memoi[j+5] = Math.min(memoi[j] + 1, memoi[j+5]);
			memoi[j+7] = Math.min(memoi[j] + 1, memoi[j+7]);
		}
		
		System.out.println(memoi[N]);
	}

}
