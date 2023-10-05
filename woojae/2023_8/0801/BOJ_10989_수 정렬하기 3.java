import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 빠른 입출력을 위한 버퍼 리더 및 스트링 빌더 선언
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];  // 메모리 관리를 위해 리스트가 아닌 배열 선언 = primitive type 사용
		
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());  // 개행 제거, parseInt의 반환 타입은 int
		
		Arrays.sort(arr);  // 정렬
		for (int i : arr)
			sb.append(i).append("\n");
		
		System.out.println(sb);  // 한꺼번에 출력
	}
}
