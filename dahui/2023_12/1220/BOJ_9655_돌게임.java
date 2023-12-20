import java.io.*;
import java.util.*;

public class Main {
    static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        
        if(num % 2 == 1) {
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
        
    }
}
