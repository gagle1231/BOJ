import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a =  Math.abs(o1);
                int b = Math.abs(o2);
                if(a == b) return o1 - o2;
                else return a - b;
            }
        });

        for(int i=0; i<n; i++){
           int x = Integer.parseInt(br.readLine());
           if(x == 0){
               Integer rslt = heap.poll();
               rslt = rslt==null ? 0 : rslt;
               sb.append(rslt+"\n");
           }else{
               heap.add(x);
           }
        }
        System.out.print(sb);
    }
}