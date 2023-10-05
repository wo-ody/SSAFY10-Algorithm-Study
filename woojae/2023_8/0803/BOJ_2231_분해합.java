import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int num = 0;
		int temp;
		int answer = 0;
		while(true) {
			temp = ++num;  // 반복할 때 마다 다음 숫자로 갱신
			String num_arr = Integer.toString(temp);
			int len = num_arr.length();
			for(int i = 0; i < len; i++)
				temp += (num_arr.charAt(i) - '0');  // 갱신된 숫자의 분해합 계산, charAt은 아스키값이므로 0을 빼서 시작값을 0으로 고정
			if(temp == target) {  // 현재 num의 분해합으로 target을 만들 수 있다면
				answer = num;  
				break;
			}
			if(num == target)  // 갱신된 num이 target이 된다면 num은 target을 포함하고 있으므로 절대 생성자를 만들 수 없음
				break;
		}
		System.out.println(answer);
	}
}
