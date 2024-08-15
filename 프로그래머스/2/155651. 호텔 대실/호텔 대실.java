import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        List<Book> bookList = new ArrayList<>();
        for (String[] times : book_time){
            String start = times[0].replace(":","");
            String end = times[1].replace(":","");
            bookList.add(new Book(Integer.parseInt(start), Integer.parseInt(end)+9));
        }
        
        //1. 시작 시간으로 정렬
        Collections.sort(bookList);
        int[] endList = new int[bookList.size()];
        for(int i=0; i<bookList.size(); i++){
            Book b = bookList.get(i);
            System.out.println(b.startTime);
            boolean addBucket = true;
            for(int j=0; j<answer; j++){
                if(b.startTime > endList[j]){
                    endList[j] = b.endTime;
                    addBucket = false;
                    break;
                }
            }
            if(addBucket){
                endList[answer++] = b.endTime;
            }
        }
        return answer;
    }
    
    
    public static class Book implements Comparable<Book>{
        int startTime;
        int endTime;

        public Book(int i, int i1) {
            startTime = i;
            endTime = i1;
            if(endTime%100 >=60){
                endTime+=40;
            }
        }

        @Override
        public int compareTo(Book o) {
            if(startTime == o.startTime){
                return o.endTime - endTime;
            }
            return startTime - o.startTime;
        }
    }
}