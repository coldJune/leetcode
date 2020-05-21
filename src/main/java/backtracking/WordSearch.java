package backtracking;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 */
public class WordSearch {

    public static void main(String[] args) {
        String word = "ABCCED";
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board,word));
        word = "SEE";
        System.out.println(exist(board,word));
        word = "ABCB";
        System.out.println(exist(board,word));

    }
    private static int[][] direction = {{0,-1},{0,1},{-1,0},{1,0}};
    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,i,j,word,0,visited)){
                    return true;
                }

            }
        }
        return false;
    }


    /**
     *
     * @param board 字符数组
     * @param i x轴
     * @param j y轴
     * @param word 单词
     * @param start 单词下标
     * @param visited 访问标记数组
     * @return
     */
    private static boolean dfs(char[][] board, int i,int j, String word,int start,boolean[][] visited){
        if(start == word.length() -1){
            return board[i][j]==word.charAt(start);
        }

        if(board[i][j] == word.charAt(start)){
            visited[i][j] = true;
            for(int k = 0;k<4;k++){
                int newX = i+direction[k][0];
                int newY = j+direction[k][1];
                if(newX<board.length&&newX>=0
                        &&newY<board[0].length&&newY>=0
                        &&!visited[newX][newY]){
                    if(dfs(board,newX,newY,word,start+1,visited)){
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;

    }
}