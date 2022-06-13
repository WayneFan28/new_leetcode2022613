package Graph;

import UnionFind.UF;

public class SurroundedRegions {
    /**
     Given an m x n matrix board containing 'X' and 'O',
     capture all regions that are 4-directionally surrounded by 'X'.
     A region is captured by flipping all 'O's into 'X's in that surrounded region.
     */
    public void solve(char[][] board) {//leetcode130
        if (board.length==0){
            return;
        }
        int m=board.length, n=board[0].length;
        UF uf = new UF(m * n + 1);
        int dummy = m*n;
        for (int i=0;i<m;i++){
            if (board[i][0]=='O'){
                uf.union(i*n,dummy);
            }
            if (board[i][n-1]=='O'){
                uf.union(i*n+n-1,dummy);
            }
        }
        for (int j=0;j<n;j++){
            if (board[0][j]=='O'){
                uf.union(j,dummy);
            }
            if (board[m-1][j]=='O'){
                uf.union(n*(m-1)+j,dummy);
            }
        }
        int[][] d = new int[][] {{1,0},{0,1},{0,-1},{-1,0}};
        for (int i=1;i<m-1;i++){
            for (int j=1;j<n-1;j++){
                if (board[i][j]=='O'){
                    for (int k=0;k<4;k++){
                        int x=i+d[k][0];
                        int y=j+d[k][1];
                        if (board[x][y]=='O'){
                            uf.union(x*n+y,i*n+j);
                        }
                    }
                }
            }
        }
        for (int i=1;i<m-1;i++){
            for (int j=1;j<n-1;j++){
                if (!uf.connected(dummy,i*n+j)){
                    board[i][j]='X';
                }
            }
        }
    }
//----------------------------------------------------------------
    public void solve1(char[][] board) {
        int m = board.length, n = board[0].length;
        if (m == 0 || n == 0) return;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                boolean atEdge = i == 0 || j == 0 || i == m-1 || j == n-1;
                if (atEdge && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length-1 || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';
        int[][] d = new int[][] {{1,0},{0,1},{0,-1},{-1,0}};
        for (int[] s : d){
            dfs(board , i + s[0], j + s[1]);
        }
    }
}
