
import java.util.*;

public class Solution {
	
	public static void display(int[][]board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void solveSoduku(int[][] board,int i,int j) {
		//base case
		if(i==board.length) {
			display(board);
			return;
		}
		int ni = 0;
		int nj = 0;
    
    //if col is equals to the board col length then go to the next row
		if(j==board[0].length-1) {
			ni = i+1;
			nj = 0;
		}
    //else row is eauals to the board row length then go to the next col
    else { 
			ni = i;
			nj = j+1;
		}
		if(board[i][j]!=0) {
			solveSoduku(board,ni,nj);
		}else {
			for(int po = 1;po<=9;po++) {
				if(isValid(board,i,j,po)==true) {
					board[i][j] = po;
					solveSoduku(board,ni,nj);
					board[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean isValid(int[][] board, int x , int y, int val) {
		
    //check in column
		for(int j =0;j<board[0].length;j++) {
			if(board[x][j] == val) {
				return  false;
			}
		}
    
    //check in row
		for(int i =0;i<board.length;i++) {
			if(board[i][y] == val) {
				return  false;
			}
		}
		
    //check in submatrix of 3x3
		int smi = x/3*3;
		int smj = y/3*3;
		for(int i=0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(board[smi+i][smj+j]==val) {
					return false;
				}
			}
		}
		return true;
	}
  
  //Driver code
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] arr= {{3,0,6,5,0,8,4,0,0},
				{5,2,0,0,0,0,0,0,0},
				{0,8,7,0,0,0,0,3,1},
				{0,0,3,0,1,0,0,8,0},
				{9,0,0,8,6,3,0,0,5},
				{0,5,0,0,9,0,6,0,0},
				{1,3,0,0,0,0,2,5,0},
				{0,0,0,0,0,0,0,7,4},
				{0,0,5,2,0,6,3,0,0}};

		solveSoduku(arr,0,0);
		sc.close();
	}

}s