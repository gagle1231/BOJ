import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] m = new int[n][2];
        String str;
        StringTokenizer st;
        for(int i=0; i<n; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            m[i][0] = Integer.parseInt(st.nextToken());
            m[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(m, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int count = 1;
        int endTime = m[0][1];
        for(int i=1; i<n; i++){
            if(m[i][0]>=endTime) {
                count++;
                endTime = m[i][1];
            }
        }
        System.out.println(count);
    }
}