import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder bd = new StringBuilder();
        for (int i = 0; i < n; i++) {
            bd.append(br.readLine().toLowerCase()+"\n");
        }
        System.out.println(bd);
    }
}
