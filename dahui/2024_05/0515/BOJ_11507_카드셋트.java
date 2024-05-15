import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ_11507_카드셋트 {
	static final String db = "GRESKA";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder ans = new StringBuilder();
		HashSet<String> card = new HashSet<>();
		HashMap<Character, Integer> shape = new HashMap();
		for (int i = 0; i < sb.length()/3; i++) {
			String str = sb.substring(i*3,i*3+3);
			if (card.contains(str)) {
				System.out.println(db);
				return;
			}
			card.add(str);
			char c = str.charAt(0);
			if (shape.containsKey(c)) {
				shape.put(c, shape.get(c) + 1);
			}else shape.put(c, 1);
		}
		ans.append(13 - (shape.get('P')==null?0:shape.get('P'))).append(" ");
		ans.append(13 - (shape.get('K')==null?0:shape.get('K'))).append(" ");
		ans.append(13 - (shape.get('H')==null?0:shape.get('H'))).append(" ");
		ans.append(13 - (shape.get('T')==null?0:shape.get('T'))).append(" ");
		System.out.println(ans);
	}
}
