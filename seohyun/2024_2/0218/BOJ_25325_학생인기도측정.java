import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            hashMap.put(st.nextToken(), 0); 
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); 

            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                hashMap.put(s, hashMap.get(s) + 1); 
            }
        }

        List<String> keySet = new ArrayList<>(hashMap.keySet());

        keySet.sort((o1, o2) -> {
            if(hashMap.get(o1) - hashMap.get(o2) == 0)
                return o1.compareTo(o2);
            else
                return hashMap.get(o2) - hashMap.get(o1);
        });

        for(String key : keySet) {
            System.out.println(key + " " + hashMap.get(key));
        }

    }
}
