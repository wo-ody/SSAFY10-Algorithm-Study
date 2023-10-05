import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;
	static int[] count;
	static int min_value = Integer.MAX_VALUE;
	static int max_value = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		count = new int[4];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		fun(num[0] ,  1);
		
		System.out.println(max_value);
		System.out.println(min_value);
	}
	static int cal(int num1, int num2, int op) { // op : 연산자
 		if(op == 0) return num1 + num2;
 		else if(op == 1) return num1 - num2;
 		else if(op == 2) return num1 * num2;
 		else return num1 / num2;
	}

	static void fun(int value , int cnt) {
		if(cnt == N) {
			min_value = Math.min(min_value, value);
			max_value = Math.max(max_value, value);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(count[i] == 0) continue;
			count[i]--;
			int su = cal(value,num[cnt],i); 
			fun(su , cnt + 1);
			count[i]++;
		}
	}

}
