import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

//TreeSet을 사용하면 중복제거와 정렬이 한번에 됩니다.
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        Set<Integer> set = new TreeSet<Integer>();
        while(n-- > 0) {
            set.add(sc.nextInt());
        }
        
        Iterator<Integer> it = set.iterator();
        
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
