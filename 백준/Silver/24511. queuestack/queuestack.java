import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] b = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine()); //0: 큐, 1: 스택
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()){
            if(Integer.parseInt(st.nextToken()) == 0){
                dq.addFirst(Integer.parseInt(st2.nextToken()));
            }else{
                st2.nextToken();
            }

        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            dq.addLast(Integer.parseInt(st.nextToken()));
            sb.append(dq.pollFirst() +" ");
        }
        System.out.print(sb);
    }
}