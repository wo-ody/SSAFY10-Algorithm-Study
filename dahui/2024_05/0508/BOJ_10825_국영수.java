import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10825_국영수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Node(str, korean, english, math));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.korean == o2.korean &&
                    o1.english == o2.english
                    && o1.math == o2.math) {
                return o1.name.compareTo(o2.name);
            }else if (o1.korean == o2.korean && o1.english == o2.english) {
                return o2.math - o1.math;
            }else if (o1.korean == o2.korean) {
                return o1.english - o2.english;
            }else return o2.korean - o1.korean;
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).name).append("\n");
        }
        System.out.println(sb);
    }
    public static class Node {
        String name;
        int korean, english, math;
        public Node (String name, int korean, int english, int math ){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
