package dynamic_programming;

public class EightQueen {
	public int eightQueen(int row, int[] colRowMap){
		System.out.println(row +","+ colRowMap.length);
		if(row >= colRowMap.length){
			System.out.println("FOUND ONE SOL");
			return 1;
		}
		
		int ways = 0;
		for(int col = 0; col < colRowMap.length; col++){
			if(isValid(row, col, colRowMap) == true){
				colRowMap[row] = col;
				ways+= eightQueen(row+1, colRowMap);
			}
		}
		return ways;
		
	}
	
	public boolean isValid(int row, int col, int[] colRowMap){
		for(int previousRow = 0; previousRow < row; previousRow++){
			if(colRowMap[previousRow] == col){
				return false;
			}
			System.out.println("curr col"+col);
			//int colDis = Math.abs(getPrevCol(previousRow, colRowMap)-col);
			int colDis= Math.abs(col-colRowMap[previousRow]);
			System.out.println("curr row"+ row);
			System.out.println("prev row"+ previousRow);
			int rowDis = row - previousRow;
			if(colDis == rowDis){
				return false;
			}
		}
		return true;
	}
	
	public int getPrevCol(int row, boolean[][]colRowMap){
		for(int col = 0; col < colRowMap[row].length; col++){
			if(colRowMap[row][col] == true){
			    System.out.println("prev col"+col);
				return col;
			}
		}
		return -1;
	}
	                         
	public static void main(String[] args){
		EightQueen q = new EightQueen();
		//boolean[][] bol = new boolean[8][8];
		//System.out.println(bol[0][0]);
		System.out.println(q.eightQueen(0, new int[8]));
	
	}
}
