import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean check;
    static List<Integer>[] lists;
    static boolean[] back;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        lists = new List[n];
        back = new boolean[n];
        for(int i=0; i<n; i++){
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        for(int i=0; i<m; i++){
            DFS(i, 1);
            if(check){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static boolean DFS(int num, int depth) {
        if(depth == 5){
            return check = true;
        }
        if(!back[num]) {
            back[num] = true;  // 현재 노드 방문 표시
            for(int i : lists[num]) {
                if(!back[i]) {
                    if(DFS(i, depth + 1)) return true;
                }
            }
            back[num] = false;  // 재귀 호출이 끝난 후 방문 표시 해제
        }
        return false;
    }
}