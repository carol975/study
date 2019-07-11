package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class TripleStep {
	public class Step{
		int row;
		int col;
		public Step(int row, int col){
			this.row = row;
			this.col = col;
		}
		
		public void print(){
			System.out.println(this.row + "," + this.col);
		}
	}
	public List<Step> RobotInAGrid(int[][]grid, int currRow, int currCol){
		List<Step> route = new ArrayList<Step>();
		if(currRow == 0 && currCol == 0){
			route.add(0,new Step(currRow, currCol));
			return route;
		}
		if(currRow > 0 && currRow < grid.length && grid[currRow-1][currCol] != -1 ){
			List<Step> nextStep = RobotInAGrid(grid,currRow-1, currCol);
			if(nextStep != null){
				route.add(0,new Step(currRow-1, currCol));
				route.addAll(0, nextStep);
				return route;
			}
		}
		if(route.size() == 0 && currCol > 0 && currCol < grid[currRow].length && grid[currRow][currCol-1] != -1){
			List<Step> nextStep = RobotInAGrid(grid,currRow, currCol-1);
			if(nextStep != null){
				route.add(0, new Step(currRow, currCol-1));
				route.addAll(0, nextStep);
				return route;
			}
		}

		return null;
		
		
	}
	
	public static void main(String[] args){
		int[][]grid = new int[5][5];
		grid[0][1] = -1;
		grid[1][3] = -1;
		grid[2][0] = -1;
		grid[2][1] = -1;
		grid[2][2] = -1;
		grid[3][0] = -1;
		grid[3][1] = -1;
		grid[3][2] = -1;
		grid[3][4] = -1;
		
		/*
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				//grid[i][j] = 0;
				System.out.println(grid[i][j]);
			}
		}*/
		List<Step> route = new TripleStep().RobotInAGrid(grid,4,4);
		for(Step s : route){
			s.print();
		}
	}
}
