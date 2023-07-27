import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++)  // 집합의 값을 저장해서 중복 제거
			set.add(sc.next());
		
		ArrayList<String> arr = new ArrayList<>(set);  // 정렬을 위해 중복이 제거된 집합을 array list로 변환
		
		Collections.sort(arr, (str1, str2) -> str1.length() == str2.length() ? str1.compareTo(str2) : str1.length() - str2.length());
		// 람다식을 이용해 정렬, 음수 또는 0이면 이미 사전순으로 정렬된 상태, 양수면 위치 스왑
		for (String str : arr)
			System.out.println(str);
	}
}
