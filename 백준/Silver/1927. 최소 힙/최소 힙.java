import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            if(k==0){
                Integer a = q.poll();
                a = a!=null ? a : 0;
                bw.write(a + "\n");
            }else{
                q.add(k);
            }
        }
        bw.flush();
        bw.close();
    }
}