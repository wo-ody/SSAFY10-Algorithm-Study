import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15904_UCPC는무엇의약자일까 {
    static final String love = "I love UCPC";
    static final String hate = "I hate UCPC";
    static boolean u = false;
    static boolean c = false;
    static boolean p = false;
    static boolean c2 = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if (!u){
                if (c1 == 'U') u = true;
            }else {
                if (!c){
                    if (c1 == 'C') c = true;
                }else {
                    if (!p){
                        if (c1 == 'P') p = true;
                    }else{
                        if (!c2){
                            if (c1 == 'C') {
                                c2 = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        if (u && c && p && c2) System.out.println(love);
        else System.out.println(hate);

    }
}
