package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1283_단축키_지정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        StringTokenizer st = null;
        while(num-- > 0){
            String str = br.readLine();
            st = new StringTokenizer(str);
            System.out.println(shortCut(st, set));
        }

    }
    static String shortCut(StringTokenizer st, HashSet<Character> set){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> lst = new ArrayList<>();
        while(st.hasMoreTokens()) lst.add(st.nextToken());
        for(int s = 0; s < lst.size(); s++){
            String word = lst.get(s);
            char current = Character.toLowerCase(word.charAt(0));
            char origin = word.charAt(0);
            if(!set.contains(current)){
                set.add(current);
                sb.append("[").append(origin).append("]");
                for(int notf = 1; notf < word.length(); notf++) sb.append(word.charAt(notf));
                sb.append(" ");
                for(int next = s+1; next < lst.size(); next++) sb.append(lst.get(next)).append(" ");
                return sb.toString();
            }
            else{
                sb.append(word).append(" ");
            }
        }

        sb.setLength(0);

        for(int i = 0; i < lst.size(); i++){
            String word = lst.get(i);
            sb.append(word.charAt(0));
            for(int al = 1; al < word.length(); al++){
                char current = Character.toLowerCase(word.charAt(al));
                char origin = word.charAt(al);
                if(!set.contains(current)){
                    set.add(current);
                    sb.append("[").append(origin).append("]");
                    for(int nal = al+1; nal < lst.get(i).length(); nal++) sb.append(lst.get(i).charAt(nal));
                    sb.append(" ");
                    for(int k = i+1; k < lst.size(); k++) sb.append(lst.get(k)).append(" ");
                    return sb.toString();
                }
                else{
                    sb.append(lst.get(i).charAt(al));
                }
            }
            sb.append(" ");
        }
        sb.setLength(sb.length());
        return sb.toString();
    }
}
