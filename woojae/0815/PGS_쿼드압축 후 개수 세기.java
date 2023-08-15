import java.util.ArrayList;

class Solution {
	static ArrayList<String> test = new ArrayList<String>();

	public int[] solution(int[][] arr) {
		int[] answer = { 0, 0 }; // {0, 1}
		int n = arr.length;
		search(0, 0, arr, n);

		String result = test.get(test.size() - 1); // 리스트의 마지막에 최종압축 결과과 문자열 형태로 존재
		int len = result.length();
		for (int i = 0; i < len; i++)
			answer[(int) result.charAt(i) - 48]++;  // 해당 문자열을 문자로 쪼개서 인덱스로 변환후 값 갱신, 0이 문자일 때 아스키 값은 48이므로 48을 빼서 인덱스 값 보정

		return answer;
	}

	static String search(int y, int x, int[][] arr, int n) {
		if (n == 1) {
			test.add(String.valueOf(arr[y][x]));  // 값이 모두 같을 때 최종 압축 결과
			return String.valueOf(arr[y][x]);
		}
		int half = n / 2;
		String sq1 = search(y, x, arr, half);
		String sq2 = search(y, x + half, arr, half);
		String sq3 = search(y + half, x, arr, half);
		String sq4 = search(y + half, x + half, arr, half);

		if (sq1.length() == 1 && sq1.equals(sq2) && sq1.equals(sq3) && sq1.equals(sq4))
			return sq1;
		else {
			String temp = sq1 + sq2 + sq3 + sq4;  // 값이 서로 다를 때 최종 압축 결과
			test.add(temp);
			return temp;
		}
	}
}