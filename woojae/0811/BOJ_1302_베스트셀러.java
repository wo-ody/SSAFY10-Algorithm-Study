import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static class Data {
		String name;
		int count;
		Data(Object names, Object counts) {  // 입력받은 객체를 목적에 맞게 타입 캐스팅
			this.name = (String)names;
			this.count = (int)counts;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			String book = br.readLine();
			if(!hash.containsKey(book))  // 기본적인 해시 저장
				hash.put(book, 1);
			else
				hash.put(book, hash.get(book) + 1);
		}
		int len = hash.size();
		Data[] result = new Data[len];  // 책 정보를 저장할 객체 배열 생성
		Object[] keys = hash.keySet().toArray();  // 해시의 키와 값을 각각 배열로 변환
		Object[] values = hash.values().toArray();

		for(int i = 0; i < len; i++) 
			result[i] = new Data(keys[i], values[i]);  // 각각의 값을 가진 객체를 배열에 저장
	
		Arrays.sort(result, (o1, o2) -> o1.count == o2.count ? o1.name.compareTo(o2.name) : o2.count - o1.count);
		// 판매량이 같다면 사전순으로 정렬, 그게 아니라면 판매량이 높은 순으로 정렬
		System.out.println(result[0].name);  // 정렬된 객체들의 최고값의 이름을 출력
	}
}
