package arrays_and_strings;

public class ZeroMatrix {
	
	public static void main (String[] args){
		int[][] matrix =  {{0,1,2,3,4},{5,6,7,8,9},{10,11,0,13,14},{15,16,17,18,19},{20,21,22,23,24}};
		zeroMatrix(matrix);
		for(int i = 0; i < matrix.length;i++){
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println("");
		}
	}
	public static void zeroMatrix(int[][] matrix){
		int zeroRows = 0;
		int zeroCols = 0;
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] == 0){
					zeroRows = zeroRows | (1 << i);
					zeroCols = zeroCols | (1 << j);
				}
			}
		}
		
		System.out.println(Integer.toBinaryString(zeroRows));
		System.out.println(Integer.toBinaryString(zeroCols));
		
		int i = 0;
		
		while( (1 << i) <= zeroRows){
			if((zeroRows & (1 << i)) == 1){
				clearRows(matrix,i);
			}
			i++;
		}
		
		i = 0;
		while(zeroCols > 0){
			if((zeroCols & 1) == 1){
				clearCols(matrix,i);
				//System.out.println(Integer.toBinaryString(zeroCols) + "," + i);
			}
			
			
			zeroCols = zeroCols >> 1;
			
			i++;
		}
		
		
	}
	
	public static void clearRows(int[][]matrix, int row){
		for(int j = 0; j < matrix[row].length; j++){
			matrix[row][j] = 0;
		}
	}
	
	public static void clearCols(int[][]matrix, int col){
		System.out.println(col);
		for(int i = 0; i < matrix.length; i++){
			matrix[i][col] = 0;
		}
	}
}
