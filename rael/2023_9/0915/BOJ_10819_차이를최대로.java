import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static boolean[] visited;
    static int n;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(arr, 0);

        System.out.println(result);
    }

    public static void dfs(ArrayList<Integer> arr, int count) {
        if(count==n){
            result = Math.max(getResult(arr), result);
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(nums[i]);
                dfs(arr, count+1);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }
    }

    public static int getResult(ArrayList<Integer> arr){
        int sum=0;
        for(int i=0; i<n-1; i++){
            sum += Math.abs(arr.get(i)-arr.get(i+1));
        }
        return sum;
    }
}
