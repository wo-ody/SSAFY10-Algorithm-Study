import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		long high = 0, low = 1;  // 랜선의 최소 길이는 무조건 1
		long mid, target;  // type을 int로 지정하면 터짐, high와 low 모두 이후 갱신된 long type의 값을 받기 때문에 long으로 선언
		
		
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			high = arr[i] > high ? arr[i] : high;  // 입력과 동시에 최대값 찾기
		}
		
		while(low <= high) {  // 이진 탐색의 아이디어, 종료 조건을 low < high로 설정하면 틀림
			mid = (low + high) / 2;
			target = 0;
			
			for(int i = 0; i < k; i++)
				target += (arr[i] / mid);  // 중간값으로 만들어 낼 수 있는 랜선을 합산
			
			if(target < n)  // 만들어진 랜선이 부족하다는 것은 너무 길게 잘랐다는 뜻
				high = mid - 1;  // 최대값을 중간값 이전으로 갱신
			else  // 개수가 충족되었을 때, 길이가 최대가 되도록 하기 위해 최소값 갱신
				low = mid + 1;
		}
		System.out.println(high);
	}
}
