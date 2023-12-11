import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*; 

public class Main {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static long N;
static int ans; 

public static void main(String[] args) throws Exception {
N = Long.parseLong(br.readLine()); 

for (int i = 1; ; i++) {
if(i>N)
break; 

N-=i;
ans++;
} 

System.out.println(ans);
}
}
