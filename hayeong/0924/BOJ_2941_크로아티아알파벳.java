import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_2941_크로아티아알파벳 {
    static String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i = 0; i<alpha.length; i++){
            if(str.contains(alpha[i])){
                str = str.replace(alpha[i], "@");
            }
        }

        System.out.println(str.length());
    }
}
