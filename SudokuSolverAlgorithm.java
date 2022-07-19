package ArrayLeetcode;

public class SudokuSolverAlgorithm {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(board,k,i,j)){
                            board[i][j]=k;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    // we are checking for each row, column and each cell containing repeating number or not
    boolean isValid(char[][] board,char k,int i,int j){
        for(int l=0;l<board.length;l++){
            if(board[i][l]==k){
                return false;
            }
            if(board[l][j]==k){
                return false;
            }
            if(board[3*(i/3)+l/3][3*(j/3)+l%3]==k){
                return false;
            }
        }
        return true;
    }
}
