package daily_coding_problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data_structures.Tuple;
public class BuildOrder {
	HashMap<Character, ArrayList<Character>> dependencies;
	ArrayList<Character> built;
	Character[] lists; 
	public BuildOrder(Character[] lists, Tuple[] pairs){
		this.lists = lists;
		built = new ArrayList<Character>();
		dependencies = new HashMap<Character, ArrayList<Character>>();
		
		for(int i = 0; i<lists.length; i++){
			ArrayList<Character> dep = new ArrayList<Character>();
			for(int j = 0; j < pairs.length; j++){
				if(pairs[j].y == lists[i]){
					dep.add(pairs[j].x);
				}
			}
			dependencies.put(lists[i], dep);
			
		}
		/*
		for(Character key : dependencies.keySet()){
			System.out.println("key: " + key);
			for(int i = 0; i< dependencies.get(key).size(); i++){
				System.out.print(dependencies.get(key).get(i));
			}
			System.out.println();
		}*/
		
	}
	
	public boolean buildProject(Character prj){
		if(built.contains(prj)){
			return true;
		}
		else if(dependencies.containsKey(prj) == false){
			//System.out.print(prj + " ");
			built.add(prj);
			return true;
		}
		else{
			ArrayList<Character>dep = dependencies.get(prj);
			Iterator<Character> itr = dep.iterator();
			while(itr.hasNext()){
				if(buildProject(itr.next()) == false){
					return false;
				}
			}
			//System.out.print(prj + " ");
			built.add(prj);
			return true;
		}
	}
	
	public ArrayList<Character> bO(){
		for(int i = 0; i < this.lists.length; i++){
			if(buildProject(lists[i]) == false){
				return null;
				
			}
		}
		return this.built;
	}
	
	public static void main(String[] args){
		Tuple[] pairs = {new Tuple('a','d'), new Tuple('f','b'), new Tuple('b','d'), new Tuple('f','a'), new Tuple('d','c')};
		Character[] lists = {'a','b','c','d','e','f'};
		BuildOrder bo = new BuildOrder(lists,pairs);
		ArrayList<Character> b = bo.bO();
		Iterator<Character> itr = b.iterator();
		//System.out.println();
	
		while(itr.hasNext()){
			System.out.print(itr.next() + " ");
		}
	}
	
}
