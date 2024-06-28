import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int j=1; j<=m; j++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[s].add(t);
            list[t].add(s);
        }

        int answer = 0;
        for (int i=1; i<=n; i++){
            if(!visited[i]){
                DFS(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int n){
        if(visited[n]) return ;
        visited[n] = true;
        for(int i: list[n]){
            DFS(i);
        }
    }
}