import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Card[] cards;
	static int[] number = new int[10];
	static String[] color = {"R", "B", "Y", "G"};
	static int[] colorCnt = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cards = new Card[5];
		// 값 입력 받기 
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cards[i] = new Card(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		// 숫자 카운트 하기 
		for(int i=0; i<5; i++) {
			number[cards[i].getNumber()]++;
		}
		
		// 색깔별로 카운트 하기
		for(int i=0; i<5; i++) {
			for(int j=0; j<4; j++) {
				if(cards[i].getColor().equals(color[j])) {
					colorCnt[j]++;
				}
			}
		}
		
		
		boolean sameColor5 = false;
		boolean continuousNumber5 = false;
		boolean sameNumber4 = false;
		boolean sameNumber3 = false;
		boolean sameNumber2 = false;
		boolean sameOtherNumber2 = false;
		int maxNum = 0;
		
		// 카드5장 색이 모두 같은지
		for(int i=0; i<4; i++) {
			if(colorCnt[i] == 5) sameColor5 = true;
		}
		
		for(int i=1; i<10; i++) {
			// 최댓값 찾기 
			if(number[i]>0) maxNum = Math.max(maxNum, i);
			
			// 변수 처리 하기 
			if(number[i]== 4) sameNumber4 = true;
			if(number[i]== 3) sameNumber3 = true;
			if(number[i]== 2) {
				if(sameNumber2) sameOtherNumber2 = true;
				else sameNumber2 = true;
			}
			
		}
		
		// 값이 연속적으로 5개인지 찾기 
		int idx = 0;
		for(int i=1; i<10; i++) {
			if(number[i]== 1) {
				idx = i;
				break;
			}
		}
		int cnt = 0;
		for(int i=idx; i<10; i++) {
			if(number[i]==1) cnt++;
			else break;
		}
		if(cnt == 5) continuousNumber5 = true;
		
		int answer = 0;
		// 점수를 정하는 규칙 
		// 카드 5장 모두 같은색인 경우 
		if(sameColor5) {
			answer = Math.max(answer, 600 + maxNum);
		}
		
		// 카드 5장 숫자가 연속적인 경우  
		if(continuousNumber5) {
			// 카드 5장 모두 같은 색이면서 연속적인 경우 
			if(sameColor5) {
				answer = Math.max(answer, 900 + maxNum);
			// 카드 5장 숫자가 연속적인 경우 
			}else {
				answer = Math.max(answer, 500 + maxNum);
			}
		}
		
		if(sameNumber4) {
			int tmp =0;
			for(int i=1; i<10; i++) {
				if(number[i]== 4) {
					tmp = i;
					break;
				}
			}
			answer = Math.max(answer, 800 + tmp);
		}
		
		if(sameNumber3) {
			// 카드 5장 중 3장의 숫자가 같고 나머지 2장 숫자가 같을 경우 
			if(sameNumber2) {
				int tmp3 = 0;
				int tmp2 = 0;
				for(int i=1; i<10; i++) {
					if(number[i]==3) tmp3 = i;
					if(number[i]==2) tmp2 = i;
				}
				answer = Math.max(answer, tmp3*10 + tmp2 + 700);
			// 카드 3장만 숫자가 같을 경우 
			}else {
				int tmp = 0;
				for(int i=1; i<10; i++) {
					if(number[i] == 3) {
						tmp = i;
						break;
					}
				}
				answer = Math.max(answer, 400 + tmp);
			}
		} 
		
		// 카드 2장이 같을 경우
		if(sameNumber2) {
			// 또 다른 2의 숫자가 같을 경우 
			if(sameOtherNumber2) {
				int bigger = 0;
				int smaller = 10;
				for(int i=0; i<10; i++) {
					if(number[i] == 2) {
						bigger = Math.max(bigger, i);
						smaller = Math.min(smaller, i);
					}
				}
				answer = Math.max(answer, bigger * 10 + smaller + 300);
			}else {
				int tmp = 0;
				for(int i=1; i<10; i++) {
					if(number[i]==2) {
						tmp = i;
						break;
					}
				}
				answer = Math.max(answer, 200+tmp);
			}
		}
		answer = Math.max(answer, 100+maxNum);
		System.out.println(answer);
	}
	
	static class Card{
		private String color;
		private int number;
		
		Card(){}
		public Card(String color, int number) {
			super();
			this.color = color;
			this.number = number;
		}
		
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
	}
}
