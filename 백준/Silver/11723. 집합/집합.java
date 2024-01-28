import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int set = 0;

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) - 1 : 0;
            switch (command){
                case "add":
                    set = set | (1 << num);
                    break;
                case "remove":
                    set = set & ~(1 << num);
                    break;
                case "check" :
                    int check = set & (1 << num);
                    if(check==0) sb.append(0+"\n");
                    else sb.append(1+"\n");
                    break;
                case "toggle":
                    set = set ^ (1 << num);
                    break;
                case "all":
                    set = (1 << 21) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}