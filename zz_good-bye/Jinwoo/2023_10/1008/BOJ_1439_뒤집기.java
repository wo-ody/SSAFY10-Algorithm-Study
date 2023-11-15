import java.util.*;
import java.io.*;
public class MyClass {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        char before = S.charAt(0);
        int ans=0;
        for (int i=1; i<S.length(); i++){
            if(S.charAt(i)!=S.charAt(0) && S.charAt(i)!=before) ans++;
            before = S.charAt(i);
        }
        System.out.println(ans);
    }
}
