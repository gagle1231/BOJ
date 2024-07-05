import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean check;
    static List<Integer>[] lists;
    static boolean[] back;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        back = new boolean[n+1];
        lists = new ArrayList[n+1];

        for(int i = 0; i <= n; i++) {
            lists [i] = new ArrayList<>();
        }

        // 그래프를 연결 리스트로 저장
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        for(int i = 0; i <= n; i++) {
            Collections.sort(lists[i]);
        }
        dfs(v);
        System.out.println();
        back = new boolean[n+1];
        bfs(v);
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(v);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");
            back[cur] = true;
            for(int i : lists[cur]){
                if(!back[i]){
                    queue.add(i);
                    back[i] = true;
                }
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int v){
        System.out.print(v+" ");
        back[v] = true;
        for(int i : lists[v]){
            if(!back[i]){
                dfs(i);
            }
        }
    }

}