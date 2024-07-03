import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        for(Integer e: topping){
            map1.put(e, map1.getOrDefault(e, 0) + 1);
        }
        for(Integer e: topping){
            map2.put(e, map2.getOrDefault(e, 0) + 1);
            if(map1.get(e) == 1){
                map1.remove(e);
            }else{
                map1.put(e, map1.get(e)-1);
            }
            if(map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}