class Solution {
    public static char[][] boardArray;
    public static int M;
    public static int N;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        boardArray = new char[M][N];
        
        for (int i = 0; i < M; i++) {
            boardArray[i] = board[i].toCharArray();
        }
        
        while (true) {
            boolean[][] marked = new boolean[M][N];
            int blocksToRemove = 0;
            
            // Find all 2x2 blocks to remove
            for (int i = 0; i < M - 1; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (boardArray[i][j] != ' ' && checkBlock(i, j)) {
                        marked[i][j] = true;
                        marked[i][j+1] = true;
                        marked[i+1][j] = true;
                        marked[i+1][j+1] = true;
                    }
                }
            }
            
            // Count and remove marked blocks
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (marked[i][j]) {
                        boardArray[i][j] = ' ';
                        blocksToRemove++;
                    }
                }
            }
            
            if (blocksToRemove == 0) {
                break;
            }
            
            answer += blocksToRemove;
            dropBlocks();
        }
        
        return answer;
    }
    
    private boolean checkBlock(int x, int y) {
        char c = boardArray[x][y];
        return boardArray[x][y+1] == c && boardArray[x+1][y] == c && boardArray[x+1][y+1] == c;
    }
    
    private void dropBlocks() {
        for (int j = 0; j < N; j++) {
            int emptyIndex = M - 1;
            for (int i = M - 1; i >= 0; i--) {
                if (boardArray[i][j] != ' ') {
                    char temp = boardArray[emptyIndex][j];
                    boardArray[emptyIndex][j] = boardArray[i][j];
                    boardArray[i][j] = temp;
                    emptyIndex--;
                }
            }
        }
    }
}
