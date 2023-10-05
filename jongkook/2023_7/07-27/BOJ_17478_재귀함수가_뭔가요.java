package studyAuthenticating;

import java.util.*;
import java.io.*;

public class BOJ_17478_재귀함수가_뭔가요 {
	static String answer1 = "\"재귀함수가 뭔가요?\"";
	static String answer2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String answer3 ="마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String answer4 ="그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String tail = "라고 답변하였지.";
	static int c;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		c = Integer.parseInt(br.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		whatIsRecursion(0, "");

	}
	static void whatIsRecursion(int n, String head) {
		if (n == c) {
			System.out.println(head + answer1);
			System.out.println(head + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(head + "라고 답변하였지.");
			return;
		}
		System.out.println(head + answer1);
		System.out.println(head + answer2);
		System.out.println(head + answer3);
		System.out.println(head + answer4);
		whatIsRecursion(n + 1, head + "____");
		System.out.println(head + "라고 답변하였지.");
		
	}
}
