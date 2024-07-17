import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int[][] matrix;
    static int[][] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));
    }
    public static int bfs(int n, int m){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        visited[n][m] = 1;
        q.add(new int[]{n,m});
        int count = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < dx.length; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x < 0 || x >= N || y < 0 || y >= M) continue;
                if(visited[x][y] == 0 && matrix[x][y] == 1){
                    q.offer(new int[]{x,y});
                    visited[x][y] = 1;
                    matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                }
            }
        }
        return matrix[N-1][M-1];
    }
}