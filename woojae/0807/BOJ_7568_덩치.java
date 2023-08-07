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
			arr[i] = new Info(weight, height);  // 몸무게와 키를 입력 받은 객체를 생성하여 저장
		}
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) // 개개인의 기본 순위는 1, 하지만 배열은 처음에 0으로 초기화 되어있으므로 자기 자신을 비교할 때 +1 갱신
				if(i == j || (arr[j].weight > arr[i].weight && arr[j].height > arr[i].height))  // 이후 자기보다 크다면
					answer[i] += 1;
		
		for (int i : answer) sb.append(i + " ");  // 순위가 갱신된 정보를 하나의 문자열로 저장
		System.out.println(sb);
	}
}
