import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            if(k==0){
                Integer a = q.poll();
                a = a!=null ? a : 0;
                sb.append(a +"\n");
            }else{
                q.add(k);
            }
        }
        System.out.println(sb);
    }
}