import java.util.Scanner;

public class PGS_대소문자_바꿔서_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for (char str : a.toCharArray())
        {
            if (Character.isLowerCase(str))
            {
                System.out.print(Character.toUpperCase(str));
            }
            else
            {
                System.out.print(Character.toLowerCase(str));
            }
        }
    }
}
