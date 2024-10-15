import java.util.LinkedList;

class Solution {
    public static boolean[] visited;
    public static LinkedList<Integer>[] link;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        link = new LinkedList[n];
        
        for(int i=0; i<n; i++) {
            link[i] = new LinkedList<Integer>();
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1){
                    link[i].add(j);
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int start) {
        visited[start] = true;
        for(Integer i: link[start]) {
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}