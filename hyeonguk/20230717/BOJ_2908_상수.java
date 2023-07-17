import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		num1 = Integer.parseInt(new StringBuilder().append(num1).reverse().toString());
		num2 = Integer.parseInt(new StringBuilder().append(num2).reverse().toString());
		
		System.out.println(Math.max(num1, num2));
		sc.close();

	}

}
