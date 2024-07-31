import java.util.HashSet;
import java.util.Stack;

class Solution {
    public static int[] group;
    public static int[][] visited;
    public static int[][] arr;
    static int n;
    static int m;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        group = new int[n * m];
        visited = new int[n][m];
        arr = land;

        int gid = 1; // 그룹 ID는 1부터 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 0 || arr[i][j] == 0) continue;
                search(gid, i, j);
                gid++;
            }
        }

        // 최대값 구하는 부분
        int max = 0;
        HashSet<Integer> set;
        for (int i = 0; i < m; i++) {
            set = new HashSet<>();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                gid = visited[j][i];
                //System.out.println(gid);
                if (gid == 0) continue; // 그룹이 없는 경우 생략
                if (!set.contains(gid)) {
                    sum += group[gid];
                    set.add(gid);
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public void search(int gid, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = gid;
        group[gid]++;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int tox = cx + dx[i];
                int toy = cy + dy[i];

                if (tox < 0 || toy < 0 || tox >= n || toy >= m) continue;
                if (visited[tox][toy] != 0) continue;

                if (arr[tox][toy] == 1) {
                    stack.push(new int[]{tox, toy});
                    visited[tox][toy] = gid;
                    group[gid]++;
                }
            }
        }
    }
}
