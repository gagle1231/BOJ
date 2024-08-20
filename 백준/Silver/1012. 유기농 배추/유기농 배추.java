import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            board = new boolean[n][m];
            visited = new boolean[n][m];
            int count = 0;
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = true;
                list.add(new int[]{x, y});
            }

            for(int[] v: list){
                int x = v[0];
                int y = v[1];
                if(!visited[x][y]){
                    solution(v);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    public static void solution(int[] point){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(point);
        visited[point[0]][point[1]] = true;
        while (!queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];

            for(int i=0; i<4; i++){
                int tox = dx[i]+x;
                int toy = dy[i]+y;

                if(tox<0 || toy<0 || tox>= board.length || toy >= board[0].length) continue;
                if(board[tox][toy] && !visited[tox][toy]){
                    visited[tox][toy] = true;
                    queue.add(new int[]{tox, toy});
                }
            }

        }
    }
}