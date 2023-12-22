import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt() - 1;
        LinkedList<Integer> q = new LinkedList<>();
        int[] result = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        int idx = 0;
        int i = 0;
        while (!q.isEmpty()){
            idx += k;
            if(idx >=n){
                idx = idx % n;
            }

            sb.append(q.remove(idx) +", ");
            n--;
        }

        System.out.print("<" + sb.toString().substring(0, sb.length()-2) +">");
    }
}