import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;// 사용자 의견의 개수
	static List<Integer> list = new ArrayList<Integer>();
	// 제출한 난이도 의견들
	static double sum;// 큰 값,작은 값 15%씩을 제외한 합
	//나눌 때 소수점까지 구하기 위해 double형으로

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		list.sort((n1, n2) -> n1 - n2);//오름차순 정렬
		list = list.subList((int) Math.round(n * 0.15), (int) (n - Math.round(n * 0.15)));
		//작은 값,큰 값 15%씩 제외
		for (Integer i : list) {
			sum += i;
		}
		System.out.println(Math.round(sum / list.size()));//평균값 구하고 반올림
	}

}
