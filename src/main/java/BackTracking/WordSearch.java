package BackTracking;

import org.junit.Test;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    if (dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int x, int y, int u) {
        if (Cross(x,y,board)||board[x][y]!=word.charAt(u)){
            return false;
        }
        if (u==word.length()-1){
            return true;
        }
        int[][] direc ={{0,1},{0,-1},{1,0},{-1,0}};
        if (board[x][y]==word.charAt(u)){
            board[x][y]='#';
            for (int[] d:direc){
                if(dfs(board,word,x+d[0],y+d[1],u+1)){
                    return true;
                }
            }
        }
        board[x][y]=word.charAt(u);
        return false;
    }
    private boolean Cross(int x, int y,char[][] board) {
        return !(x>=0&&x<board.length&&y>=0&&y<board[0].length);
    }
    @Test
    public void test(){
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean exist = wordSearch.exist(board, word);
        System.out.println(exist);
    }

}
