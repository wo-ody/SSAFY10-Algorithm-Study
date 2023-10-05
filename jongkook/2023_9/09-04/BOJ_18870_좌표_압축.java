import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] origin = new int[T];
        int[] sorted = new int[T];
        HashMap<Integer, Integer> compress = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < T; i++) origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sorted);

        int ranking = 0;

        for(int i : sorted){
            if(!compress.containsKey(i)){
                compress.put(i, ranking);
                ranking++;
            }
        }
        for(int key : origin){
            int ordered = compress.get(key);
            sb.append(ordered).append(" ");
        }
        System.out.println(sb);
    }
}
