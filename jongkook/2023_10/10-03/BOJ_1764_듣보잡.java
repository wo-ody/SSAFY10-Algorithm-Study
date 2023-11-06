package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int listen = Integer.parseInt(st.nextToken());
        int see = Integer.parseInt(st.nextToken());
        int count = 0;
        ArrayList<String> strList = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < listen; i++) set.add(br.readLine());

        for(int i = 0; i < see; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                count++;
                strList.add(s);
            }
        }

        Collections.sort(strList);

        System.out.println(count);
        for(int i = 0; i < strList.size(); i++) System.out.println(strList.get(i));

    }
}
