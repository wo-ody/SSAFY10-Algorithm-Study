import java.util.*;
 
public class Main {    
    
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //n개의 정수를 입력받는다.
        int n = scan.nextInt();
        num = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            num[i] = scan.nextInt();
        }
        
        //순서대로 사이클이 발생하는지 dfs로 확인한다.
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        Collections.sort(list); //작은 수 부터 출력하므로 정렬한다.
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }    
    
    public static void dfs(int start, int target) {
        if(visited[num[start]] == false) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }
        if(num[start] == target) list.add(target); //사이클 발생시 해당 숫자를 list에 담아준다.
   
