import java.util.Scanner;

//0718_BOJ_11659_�����ձ��ϱ�4
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//������ �迭
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
//�ð� �ʰ� �ذ��� ���ؼ�, ������ ��� �ʿ�
// �迭�� �������� �����ϰ�, ������ 3,5��� arr[5] - arr[2]�� ����ϸ� �ȴ�.

/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//N���� ���� �Է� �ޱ�
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		//M�� �����ϱ�
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