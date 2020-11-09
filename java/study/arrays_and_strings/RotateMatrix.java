package arrays_and_strings;

import java.util.Arrays;

public class RotateMatrix {
	public static void main(String[] args){
		int[][] matrix = {{0,1,2,3,4},{5,6,7,8,9},{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}};
		//int[][] matrix = {{0,1,2},{5,6,7},{8,9,10}};
		rotateMatrix2(matrix,0,matrix.length-1);
		for(int i = 0; i < matrix.length;i++){
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println("");
		}
	}
	public static void rotateMatrix(int[][] matrix, int start, int end){
		if(end > 0){
			//left to top 
			
			for(int i = start; i <= end; i++){
				for(int j = start; j <= end; j++){
					System.out.print(matrix[i][j] + ",");
				}
				System.out.println("");
			}
			
			int j = 0;
			
			for(int i = start; i < end;i++){
				int temp = matrix[start][end-j];
				System.out.println(temp);
				
				
				//top = left
				matrix[start][end-j] = matrix[i][start];
				
				//left = bottom
				matrix[i][start] = matrix[end][i];
				
				//bottom = right
				matrix[end][i] = matrix[end-j][end];
				
				//right = top
				matrix[end-j][end] = temp;
				j++;
				//System.out.println(num);
			}
			
			rotateMatrix(matrix,start+1, end-1);
		
		
		}	
	}
	
	public static void rotateMatrix2(int[][] matrix, int start, int end){
		if(end > 0){
			//left to top 
			
			for(int i = start; i <= end; i++){
				for(int j = start; j <= end; j++){
					System.out.print(matrix[i][j] + ",");
				}
				System.out.println("");
			}
			
			//int j = 0;
			
			for(int i = 0; i < end;i++){
				int temp = matrix[start][end-i];
				System.out.println(temp);
				
				
				//top = left
				matrix[start][end-i] = matrix[i+start][start];
				
				//left = bottom
				matrix[i+start][start] = matrix[end][i+start];
				
				//bottom = right
				matrix[end][i+start] = matrix[end-i][end];
				
				//right = top
				matrix[end-i][end] = temp;
				//System.out.println(num);
			}
			
			rotateMatrix2(matrix,start+1, end-1);
		
		
		}
		
		
		
		
		
	}
}
