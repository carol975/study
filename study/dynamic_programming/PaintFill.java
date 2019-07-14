package dynamic_programming;

public class PaintFill {
	public int[][] paintfill(int[][]screen, int color, int row, int col){
		if(row >= screen.length || row < 0 || col >= screen[row].length || col < 0){
			return screen; 
		}
		
		if(screen[row][col] == color){
			return screen;
		}
		
		screen[row][col] = color;
		screen = paintfill(screen, color, row+1, col);
		screen = paintfill(screen, color, row, col+1);
		screen = paintfill(screen, color, row-1, col);
		screen = paintfill(screen, color, row, col-1);
		return screen;
		
	}
	
}
