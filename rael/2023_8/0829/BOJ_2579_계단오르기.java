import java.util.Scanner;
 
public class BOJ_2579_계단오르기 {
    static int N;
	static Integer memoi[];
	static int arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		memoi = new Integer[N + 1];
		arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
        //디폴트 초기화
		memoi[0] = arr[0];
		memoi[1] = arr[1];
		
		if(N >= 2) {
			memoi[2] = arr[1] + arr[2];
		}
		
		System.out.println(find(N));
	}
	
	static int find(int N) {
		if(memoi[N] == null) {
			memoi[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
		}
		
		return memoi[N];
	}
	
}