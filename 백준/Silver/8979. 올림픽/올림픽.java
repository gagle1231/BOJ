import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> medal = new TreeMap<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            str = str.replace(" ", "");
            int num = str.charAt(0) - '0';
            int m = Integer.parseInt(str.substring(1));
            medal.put(num, m);
        }
        int rank = 1;
        int frontVal = 0;
        int seq = 0;
        for(Map.Entry<Integer, Integer> e: medal.entrySet()){
            //System.out.println("rank #"+rank+": " + e.getKey()+"/"+e.getValue());
            int key = e.getKey();
            int value = e.getValue();
            if(value == frontVal)
                seq++;
            if(key==k){
                rank = rank - seq;
                System.out.println(rank);
                break;
            }
            rank++;
            frontVal = value;
        }
    }
}