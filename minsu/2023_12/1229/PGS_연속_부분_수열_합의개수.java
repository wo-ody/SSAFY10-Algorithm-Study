import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] elements) {
        int[] newElements = new int[elements.length * 2];
        
        for(int i = 0; i < elements.length; i++) {
            newElements[i] = newElements[i + elements.length] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(newElements, j, j+i).sum());
            }
        }
        
        return set.size();
    }
}
