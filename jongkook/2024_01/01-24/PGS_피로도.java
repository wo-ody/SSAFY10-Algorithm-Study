class Solution {
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        System.out.println(len);
        visited = new boolean[len];
        search(k, 0, dungeons);

        return max;
    }
    static void search(int k, int count, int[][] dungeons){
        if(count >= max) {
            System.out.println(count);
            max = count;
        }
        if(max == len) {
            System.out.printf("k: %d count: %d max: %d\n", k, count, max);
            return;
        }

        for(int i = 0; i < len; i++){
            int minimum = dungeons[i][0];
            int consume = dungeons[i][1];
            if(k-minimum < 0 || visited[i]) continue;
            visited[i] = true;
            search(k - consume, count+1, dungeons);
            visited[i] = false;
        }
    }
}