import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>(n); // 초기 용량을 n으로 설정

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder builder = new StringBuilder(m * 2); // 대략적인 초기 크기 설정
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (set.contains(k)) {
                builder.append(1);
            } else {
                builder.append(0);
            }
            builder.append("\n");
        }

        bw.write(builder.toString());
        bw.flush();
        bw.close();
    }
}
