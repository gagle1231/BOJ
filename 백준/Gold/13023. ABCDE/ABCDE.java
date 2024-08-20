import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] lists;
    static boolean[] visited;
    public static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        lists = new List[n+1];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            lists[v1].add(v2);
            lists[v2].add(v1);
        }

        boolean flag = false;
        visited = new boolean[n+1];
        for(int i=0; i<n; i++) {
            if(dfs(i, 1)){
                    flag = true;
                    break;
            }
        }
        System.out.println(flag ? 1 : 0);
    }

    public static boolean dfs(int n, int depth){
        if(depth == 5){
            return true;
        }
        visited[n] = true;
        for(int v: lists[n]){
            if(!visited[v]){
                 if(dfs(v, depth+1))
                     return true;
            }
        }
        visited[n] = false;
        return false;
    }
}