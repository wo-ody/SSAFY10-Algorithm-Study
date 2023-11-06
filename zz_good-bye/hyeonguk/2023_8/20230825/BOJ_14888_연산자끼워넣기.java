import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, max, min;
	static int[] numbers;
	static char[] operations;
	static int[] npArray;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operations = new char[N-1];
		npArray = new int[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		char[] oper = new char[] {'+', '-', '*', '/'};
		for(int i=0; i<4; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<num; j++) {
				operations[idx++] = oper[i];
			}
		}
		
		for(int i=0; i<N-1; i++) {
			npArray[i] = i;
		}

		Arrays.sort(operations);
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		do {
			calc();
		}while(np());
		
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static boolean np() {
		int i, j;
		i=j = N-2;
		
		while(i > 0 && npArray[i-1] > npArray[i]) i--;
		
		if(i==0) 
			return false;
		
		
		while(j > i && npArray[i-1] > npArray[j]) j--;
		
		swap(i-1, j);
		Arrays.sort(operations, i, N-1);
		Arrays.sort(npArray, i, N-1);
		
		return true;
	}
	
	static void swap(int i, int j) {
		char tmp = operations[i];
		operations[i] = operations[j];
		operations[j] = tmp;
		
		int temp = npArray[i];
		npArray[i] = npArray[j];
		npArray[j] = temp;
	}
	
	static void calc() {
		int result = numbers[0];
		for(int i=1; i<N; i++) {
			if(operations[i-1] == '+') {
				result += numbers[i];
			}else if(operations[i-1] == '-') {
				result -= numbers[i];
			}else if(operations[i-1] == '*') {
				result *= numbers[i];
			}else if(operations[i-1] == '/') {
				result /= numbers[i];
			}
			
		}
		max = Math.max(max, result);
		min = Math.min(min, result);
	}
}
