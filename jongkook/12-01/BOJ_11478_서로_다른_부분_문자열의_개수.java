import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(getSub(str));

    }
    static int getSub(String str){
        int len = str.length();
        HashSet<String> map = new HashSet<>();

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - i; j++){
                StringBuilder part = new StringBuilder();
                for(int k = 0; k < i+1; k++){
                    part.append(str.charAt(j + k));
                }
                map.add(part.toString());
            }
        }
        return map.size();
    }
}
