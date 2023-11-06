import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();
            if (!map.containsKey(extension)) list.add(extension);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + " " + map.get(s) + "\n");
        }
        System.out.println(sb);
    }

}
