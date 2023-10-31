package study;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class Solution {

	/** 제출단 **/
	public static Queue<Integer> solution(String today, String[] terms, String[] privacies) {
		Queue<Integer> answer = new ArrayDeque<>(); // 결과 배열의 크기가 정해져있지 않기 때문에 queue 사용

		/** 로직 작성 **/

		HashMap<String, Integer> termsMap = new HashMap<>(); // 약관 종류 : 유효기간

		String[] date = today.split("\\."); // 현재 날짜를 . 을 기준으로 나눈다
		int tyear = Integer.parseInt(date[0]);
		int tmonth = Integer.parseInt(date[1]);
		int tday = Integer.parseInt(date[2]);

		for (int i = 0; i < terms.length; i++) {

			String[] term = terms[i].split(" ");
			termsMap.put(term[0], Integer.parseInt(term[1])); // 약관 배열을 돌며 맵에 저장

		}

		for (int i = 0; i < privacies.length; i++) {

			String[] privacy = privacies[i].split("\\.| "); // 가입일자를 .과 공백을 기준으로 나눔

			int year = Integer.parseInt(privacy[0]);
			int month = Integer.parseInt(privacy[1]);
			int day = Integer.parseInt(privacy[2]); // 날짜와
			String key = privacy[3]; // 약관 종류를 받음

			int term = termsMap.get(key); // 약관 종류를 key 값으로 주고 더해줄 기간을 term 변수로 받아준다.

			year += term / 12; // ex. term=25
			month += term % 12; // year에는 2를 더하고, month에는 1을 더한다.

			if (month > 12) { // 12월이라면
				year++; // 1년 증가
				month -= 12; // 13이면 1월, 15면 3월
			}

			if (day == 1) { // 가입일이 1일이라면
				if (month == 1)
					month = 12; // 1월이면 12월
				else
					month -= 1; // 그 외에는 -1을 해준다

				day = 28; // 하루 전은 28일
			} else {
				day -= 1;
			}

			// 하나씩 현재 날짜랑 검사하기
			if (tyear > year) {
				answer.add(i + 1); // 당해가 크면 무조건 추가
			} else if (tyear == year) { // 같은 해일 때
				if (tmonth > month) {
					answer.add(i + 1); // 당월이 크면 추가
				} else if (tmonth == month) { // 동월일 때
					if (tday > day) {
						answer.add(i + 1);
					}
				}
			}

		}
		return answer;
	}

	/***/

	public static void main(String[] args) {

		// test_case
		String t = "2020.01.02";
		String[] te = { "A 1" };
		String[] p = { "2020.01.02 A" };

		Queue<Integer> list = solution(t, te, p);

		while (!list.isEmpty()) {
			System.out.print(list.poll() + " ");
		}
	}

}
