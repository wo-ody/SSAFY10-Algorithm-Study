import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BOJ_1251_단어나누기 {
    static String str;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for (int i = 1; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                make(i,j);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }

    public static void make(int idx, int idx2) {
        StringBuffer sb1 = new StringBuffer(str.substring(0, idx));
        StringBuffer sb2 = new StringBuffer(str.substring(idx, idx2));
        StringBuffer sb3 = new StringBuffer(str.substring(idx2, str.length()));

        String s = sb1.reverse().toString() +
                    sb2.reverse().toString() +
                    sb3.reverse().toString();
        list.add(s);
    }
}
