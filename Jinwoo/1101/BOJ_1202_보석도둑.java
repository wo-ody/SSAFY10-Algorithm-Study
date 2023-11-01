import java.io.*;
import java.util.*;
public class BOJ_1202_보석도둑 {
	
	public static void main(String[] args) throws Exception{
		int n=readInt();
		int k=readInt();
		List<int[]> jewels = new ArrayList<>();
		for (int i=0; i<n; i++) {
			jewels.add(new int[] {readInt(),readInt()});
		}
		List<Integer> bags = new LinkedList<>();
		for (int i=0; i<k; i++) {
			bags.add(readInt());
		}
		
		Collections.sort(jewels,(o1,o2)-> o1[0]-o2[0]);
		Collections.sort(bags);
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		
		long ans=0; int i=0;
		for (int C:bags) {
			while (i<n && jewels.get(i)[0] <= C) heap.add(jewels.get(i++)[1]);
			
			if(!heap.isEmpty()) ans += heap.poll();
		}
		System.out.println(ans);
	}

    static int readInt() throws IOException {
        int val = 0;
        do {
            int c = System.in.read();
            if (c == ' ' || c == '\n' || c == -1) break;
            val = 10*val + c-48;
        } while (true);
        return val;
    }
}
