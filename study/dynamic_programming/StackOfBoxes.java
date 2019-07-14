package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {
	class Box {
		int h;
		int w;
		int d;
		
		public Box(int h, int w, int d){
			this.h = h;
			this.w = w;
			this.d = d;
		}
		
		public boolean canBeAtBottom(Box top){
			if(top.h < this.h && top.w < this.w && top.d < this.d){
				return true;
			}
			return false;
		}
	}

	class SortBoxByHeight implements Comparator<Box>{
		@Override
		public int compare(Box b1, Box b2) {
			return b2.h - b1.h;
		}
	}
	
	public int stackBoxes (ArrayList<Box> boxes){
		Collections.sort(boxes, new SortBoxByHeight());
		int maxHeight = 0;
		int[] maxHeightMem = new int[boxes.size()];
		for(int i = 0; i < boxes.size(); i++){
			int height = stackBoxes(boxes, i, maxHeightMem);
			maxHeightMem[i] = height;
			maxHeight = height > maxHeight? height:maxHeight;
			
		}
		return maxHeight;
	}
	
	public int stackBoxes(ArrayList<Box> boxes, int bottomIndex, int[] maxHeightMem){
		if(bottomIndex >= boxes.size()){
			return 0;
		}
		
		if(maxHeightMem[bottomIndex] > 0){
			return maxHeightMem[bottomIndex];
		}
		
		
		
		int height = 1;
		for(int i = bottomIndex; i < boxes.size()-1; i++){
			if(boxes.get(i).canBeAtBottom(boxes.get(i+1)) == true){
				height++;
			}
		}
		
		return height;
		
	}
	
	public static void main (String[] args){
		ArrayList<Box> boxes = new ArrayList<Box>();
		StackOfBoxes stb = new StackOfBoxes();
		boxes.add(stb.new Box(1,1,1));
		boxes.add(stb.new Box(2,2,2));
		boxes.add(stb.new Box(4,3,3));
		boxes.add(stb.new Box(4,4,4));
		
		System.out.println(stb.stackBoxes(boxes));
		
		
	}
		
}
