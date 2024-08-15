import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int len = book_time.length;
        int[][] books = new int[len][2];

        for (int i=0; i<len; i++){
            books[i][0] = Integer.parseInt(book_time[i][0].replace(":", ""));
            books[i][1] = Integer.parseInt(book_time[i][1].replace(":", "")) + 10;
            if(books[i][1]%100 >=60){
                books[i][1] += 40;
            }
        }
        // 시작 시간 순으로 오름차순 정렬
        Arrays.sort(books, Comparator.comparingInt(b -> b[0]));

        // 종료 시간을 관리하기 위한 우선순위 큐를 사용
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for(int[] times: books){
            if(!endTimes.isEmpty() && endTimes.peek() <= times[0]){ //우선순위 큐를 보고 들어갈 수 있는 방이 있는지 확인
                endTimes.poll(); // 입실 가능하면 해당 방 마지막 입실 시간 갱신
            }
            endTimes.offer(times[1]); 
        }
        return endTimes.size();
    }
}