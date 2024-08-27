import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());

            if(min.size() == max.size()){
                max.offer(k);
            }else{
                min.offer(k);
            }
            if(!min.isEmpty() && !max.isEmpty() && max.peek() > min.peek()){
                int tmp = min.poll();
                min.offer(max.poll());
                max.offer(tmp);
            }
            sb.append(max.peek())
                    .append("\n");
        }
        System.out.println(sb);
    }
}
