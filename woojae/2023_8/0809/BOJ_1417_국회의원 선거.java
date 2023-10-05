import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int x = 0;
		int answer = 0;
		int dasom = Integer.parseInt(br.readLine());  // 다솜이의 초기 지지자 저장
		int[] arr = new int[n-1];  // 다솜이를 제외한 지지자들을 저장할 배열 -> (n - 1)
		for(int i = 0; i < n - 1; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		try {  // 다솜이를 제외한 후보중 가장 많은 지지자를 가진 후보의 지지자만 매수하면 최소한의 매수를 수행할 수 있음
			while(true) {
				Arrays.sort(arr);  // 최대 지지자를 찾기 위해 정렬
				if(dasom > arr[n-2])  // 다솜이를 제외한 후보들 중 최대 지지자를 가진 후보의 지지자가 다솜이보다 적다면 -> 지지자의 수는 n-1이며 배열의 인덱스상 0번부터 시작하므로 마지막 인덱스는 n-2
					break;  // 탐색 종료
				arr[n-2]--;  // 다솜이 제외, 최대 지지자를 가진 후보의 지지자를 1명 매수
				dasom++;  // 다솜이의 지지자 증가
				answer++;  // 뺏은 지지자의 수 갱신
			}
		} catch(ArrayIndexOutOfBoundsException e) {}  // 배열의 길이가 1, 즉 후보가 다솜이밖에 없다면 arr[n-2]에서 인덱스 에러 발생
		System.out.println(answer); 
	}
}
