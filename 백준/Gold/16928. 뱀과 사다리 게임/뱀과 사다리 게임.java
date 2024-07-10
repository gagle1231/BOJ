import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[] lnk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[101];
        lnk = new int[101];
        for (int i=0; i<n+m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lnk[s] = e;
        }
        System.out.println(bfs());

    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for(int j=0; j<size; j++){
                int e = queue.poll();
                for (int i = 1; i <= 6; i++) {
                    int move = e + i;
                    if (move == 100) return cnt;
                    if (move > 100 || visited[move]) continue;
                    visited[move] = true;
                    if(lnk[move]!=0) queue.add(lnk[move]);
                    else queue.add(move);
                }
            }

        }
        return cnt;
    }

}