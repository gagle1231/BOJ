import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(Integer i: works){
            queue.offer(i);
        }
        for(int i=0; i<n; i++){
            int tmp = queue.poll();
            if(tmp == 0) break;
            queue.offer(tmp-1);
        
        }

        while(!queue.isEmpty()){
            int k = queue.poll();
            answer += k*k;
        }
        return answer;
    }
}