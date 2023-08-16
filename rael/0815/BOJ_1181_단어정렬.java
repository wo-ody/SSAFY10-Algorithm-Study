import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static String[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, (o1, o2) ->{
            if(o1.toString().length() == o2.toString().length()) return o1.compareTo(o2);
            else return o1.toString().length() - o2.toString().length();
        });

        System.out.println(arr[0]);
        for(int i=1; i<N; i++){
            if(!arr[i].equals(arr[i-1])){
                System.out.println(arr[i]);
            }
        }
    }
}
