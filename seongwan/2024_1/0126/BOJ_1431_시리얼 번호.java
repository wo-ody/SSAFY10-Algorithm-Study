import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//담고 시키는 대로 정렬하면 될 거 같음
//숫자인지 확인은 '0'을 빼고 범위가 0~9 인지 확인
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static List<String> list = new ArrayList<>();
	//시리얼 번호별 숫자 합 정보를 담을 맵
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
			char[] temp = list.get(i).toCharArray();
			int sum = 0;
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] - '0' <= 9) {
					sum += temp[j] - '0';
				}
			}
			map.put(list.get(i), sum);
		}
		list.sort((e1, e2) -> e1.length() != e2.length() ?
			e1.length() - e2.length() :
			(!Objects.equals(map.get(e1), map.get(e2)) ? map.get(e1) - map.get(e2) :
				e1.compareTo(e2)));
		for (String s : list) {
			sb.append(s + "\n");
		}
		System.out.println(sb);
	}
}