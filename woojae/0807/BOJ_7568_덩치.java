import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Info {
		int weight, height;
		Info(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int weight, height;
		Info[] arr = new Info[n];
		int[] answer = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			weight = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			arr[i] = new Info(weight, height);
		}
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) 
				if(i == j || (arr[j].weight > arr[i].weight && arr[j].height > arr[i].height))
					answer[i] += 1;
		
		for (int i : answer) sb.append(i + " ");
		System.out.println(sb);
	}
}
