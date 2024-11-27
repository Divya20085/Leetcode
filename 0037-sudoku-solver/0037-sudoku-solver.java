class Solution {
   public void solveSudoku(char[][] board) {
       solveSudokuUtil(board,0,0);
   }
   public boolean solveSudokuUtil(char[][] board,int row,int col){
       //base case
       if(row==9){
           return true;
       }
       int nextRow = row, nextCol = col+1;
       if(col+1==9){
           nextRow++;
           nextCol=0;
       }
       if(board[row][col]!='.'){
           return solveSudokuUtil(board,nextRow,nextCol);
       }
       for(char num='1';num<='9';num++){
           if(isSafe(board,row,col,num)){
               board[row][col]=num;
               if(solveSudokuUtil(board,nextRow,nextCol)){
                   return true;
               }
               board[row][col]='.';
           }
       }
       return false;
   }
   public boolean isSafe(char[][] board,int row,int col,char digit){
       //column
       for(int k=0;k<=8;k++){
           if(board[k][col]==digit){
               return false;
           }
       }
       //row
       for(int k=0;k<=8;k++){
           if(board[row][k]==digit){
               return false;
           }
       }
       //grid
       int gridRow = (row/3)*3;
       int gridCol = (col/3)*3;
       
       for(int x=gridRow;x<gridRow+3;x++){
           for(int y=gridCol;y<gridCol+3;y++){
               if(board[x][y]==digit){
                   return false;
               }
           }
       }
       
       return true;

   }
}