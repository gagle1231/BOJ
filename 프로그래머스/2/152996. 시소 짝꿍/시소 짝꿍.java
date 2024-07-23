import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        double[] dv = { 1.0, 2.0/3.0, 1.0/2.0, 3.0/4.0};
        Arrays.sort(weights); //1. 정렬
        for(int w: weights){
            for(int i=0; i<4; i++){
                double key = w*dv[i];
                if(map.containsKey(key)){
                    answer += map.get(key);
                }
            }
            map.put(w*1.0, map.getOrDefault(w*1.0, 0)+1);
        }
        return answer;
    }
}