import java.util.*;

public class Main {
    public static LinkedList<Integer>[] link;
    public static int[] value;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        link =  new LinkedList[n+1];
        for (int i=0; i<n + 1; i++) {
            link[i] = new LinkedList<>();
        }
        value =  new int[n+1];
        for(int i=0; i<m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            link[s].add(e);
        }
        bfs(x);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<n+1; i++){
            if(value[i] == k) {
                sb.append(i)
                        .append("\n");
            }
        }
        if(sb.isEmpty()){
            sb.append(-1);
        }

        System.out.println(sb);
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        value[x] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(Integer l : link[node]) {
                if (value[l] == 0 && l != x) {
                    value[l] = value[node] + 1; // 깊이 설정
                    queue.add(l); // 큐에 추가
                }
            }
        }

    }
}
