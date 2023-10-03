import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        for(int i =0; i<n; i++){
            String[] path = br.readLine().split("\\\\");
            trie.init();
            for(String directory : path){
                trie.insert(directory);
            }
        }
        StringBuilder space = new StringBuilder();
        traverser(trie.root,space);
        System.out.println(answer);
    }

    public static void traverser(Node node,StringBuilder space){
        List<String> temp = new ArrayList<>();
        for(String s: node.childNode.keySet()){
            temp.add(s);
        }
        Collections.sort(temp);

        for(String s: temp){
            answer.append(space.toString()).append(s).append("\n");
            space.append(" ");
            traverser(node.childNode.get(s),space);
            space.delete(space.toString().length()-1,space.toString().length());
        }
    }

    static class Trie{
        Node root = new Node();
        Node cur;

        public void init(){
            this.cur = this.root;
        }

        public void insert(String str){
            Node node = this.cur;
            node = node.childNode.computeIfAbsent(str,key->new Node());
            this.cur = node;
        }
    }
    static class Node{
        Map<String,Node> childNode = new HashMap<>();
    }
}
