import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<m; i++){
            int k = Integer.parseInt(st.nextToken());
            if(set.contains(k)){
                builder.append(1);
            }else {
                builder.append(0);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}