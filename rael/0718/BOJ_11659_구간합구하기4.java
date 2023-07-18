import java.util.Scanner;

//0718_BOJ_11659_구간합구하기4
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//누적합 배열
		int nums[] = new int[N+1];
		
		nums[0] = 0;
		for(int i=1; i<=N; i++) {
			nums[i] = sc.nextInt()+nums[i-1]; 
		}
		
		for(int i=0; i<M; i++) {
			int s_idx = sc.nextInt();
			int e_idx = sc.nextInt();
	
			System.out.println(nums[e_idx] - nums[s_idx-1]);
		}
		
		sc.close();
	}
}

//Time Complexity O(n^2)
//시간 초과 해결을 위해서, 누적합 사용 필요
// 배열에 누적합을 저장하고, 구간이 3,5라면 arr[5] - arr[2]를 출력하면 된다.

/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//N개의 숫자 입력 받기
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		//M번 연산하기
		for(int l=0; l<M; l++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int sum = 0;
			for(int m=i; m<=j; m++) {
				sum += nums[m-1];
			}
			System.out.println(sum);
		}
		
		sc.close();
	}
*/