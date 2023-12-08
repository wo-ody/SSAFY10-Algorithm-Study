public class Solution {

    private static int n;
    private static int[] parents;
    private static Map<Integer, List<Integer>> map;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        map = new HashMap<>();
        set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append(lineSeparator());
        }
        System.out.println(sb);
    }

    private static void dfs(int v) {
        List<Integer> list = map.get(v);
        for (int i : list) {
            if (!set.contains(i)) {
                parents[i] = v;
                set.add(i);
                dfs(i);
            }
        }
    }
}
