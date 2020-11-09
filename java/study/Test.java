import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
	public static void main(String[] args){
		
		Test t = new Test();
		List<List<Integer>> lot = new ArrayList<List<Integer>>();
		List<Integer> s1 = new ArrayList<Integer>();
		s1.add(1);
		s1.add(0);
		s1.add(0);
		lot.add(s1);
		
		List<Integer> s2 = new ArrayList<Integer>();
		s2.add(1);
		s2.add(0);
		s2.add(0);
		lot.add(s2);
		
		List<Integer> s3 = new ArrayList<Integer>();
		s3.add(1);
		s3.add(9);
		s3.add(1);
		lot.add(s3);
		int a = t.removeObstacle(3, 3, lot);
		System.out.println(a);
	}
	
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE
        
        return countSteps(0,0,numRows,numColumns,lot);
        
    }
    
    HashMap<Integer,ArrayList<String>> visited = new HashMap<Integer,ArrayList<String>>();
    int countSteps(int currRow, int currCol, int numRows, int numCols, List<List<Integer>> lot){
        
        if(isValidCell(currRow,currCol,numRows,numCols,lot)){
            visited.getOrDefault(currRow, new ArrayList<String>()).add(String.valueOf(currRow) + String.valueOf(currCol));
            if(lot.get(currRow).get(currCol) == 9){
             return 0;
            }
            
            int up = countSteps(currRow-1, currCol, numRows,numCols,lot);
            int down = countSteps(currRow+1, currCol, numRows,numCols,lot);
            int left = countSteps(currRow, currCol-1, numRows,numCols,lot);
            int right = countSteps(currRow, currCol+1, numRows,numCols,lot);
            
            int minSteps =  Math.min(Math.min(up,down), Math.min(left,right));
            if(minSteps < Integer.MAX_VALUE){
                return minSteps + 1;
            }
            
            return Integer.MAX_VALUE;
        }
        return Integer.MAX_VALUE;
    }
    
    // METHOD SIGNATURE ENDS
    public boolean isValidCell(int r, int c, int numRows, int numCols, List<List<Integer>> lot){
        String str = String.valueOf(r) + String.valueOf(c);
        if ( r >= 0 && r < numRows && c >= 0 && c < numCols && lot.get(r).get(c) != 0 && visited.getOrDefault(r,new ArrayList<String>()).contains(str) == false ){
            return true;
        }
        return false;
    }
	
	
}
