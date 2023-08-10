package codingtest.BOJ;
import java.io.*;
import java.util.*;
public class BOJ_25758_유전자_조합 {
    static boolean[] chosen;
    static String[] gene;
    static String[] connectArray = new String[2];
    static ArrayList<Character> chr = new ArrayList<>();
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        gene = new String[T];
        chosen = new boolean[T];
        for(int tc = 0; tc < T; tc++) gene[tc] = st.nextToken();
        perm(0);
        Collections.sort(chr);
        sb.append(chr.size()).append("\n");
        for(char c : chr) sb.append(c).append(" ");
        System.out.println(sb);

    }
    static void perm(int count){
        if( count == 2){
            connect(connectArray);
            return;
        }
        for(int  i = 0; i < T; i++){
            if(chosen[i]) continue;
            connectArray[count] = gene[i];
            chosen[i] = true;
            perm(count+1);
            chosen[i] = false;
        }
    }
    static void connect(String[] methodGene){
        String glue = String.valueOf(methodGene[0].charAt(0)) +  String.valueOf(methodGene[1].charAt(1));
        char present = (glue.charAt(0) > glue.charAt(1)) ? glue.charAt(0) : glue.charAt(1);
        if(!chr.contains(present)) chr.add(present);

    }
}
