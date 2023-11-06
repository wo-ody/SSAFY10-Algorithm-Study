import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		double result = 0;
		double totalScore = 0;
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0; tc<20; tc++) {
			String subject = sc.next();
			double score = sc.nextDouble();
			String grade = sc.next();
			
			totalScore += score;
			if(grade.equals("P")) {
				totalScore -= score;
			}
			
			if(grade.equals("A+")) {
				result += 4.5*score;
			}else if(grade.equals("A0")) {
				result += 4.0*score;
			}else if(grade.equals("B+")) {
				result += 3.5*score;
			}else if(grade.equals("B0")) {
				result += 3.0*score;
			}else if(grade.equals("C+")) {
				result += 2.5*score;
			}else if(grade.equals("C0")) {
				result += 2.0*score;
			}else if(grade.equals("D+")) {
				result += 1.5*score;
			}else if(grade.equals("D0")) {
				result += 1.0*score;
			}
		}
		System.out.printf("%f", result/totalScore);
		sc.close();
	}
}
