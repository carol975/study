package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSAdjacencyList {
	private int V; //# of vertices
	private LinkedList<Integer>[] adjacencyList;
	public int count;
	public DFSAdjacencyList(int v){
		count = 0;
		V = v;
		adjacencyList = new LinkedList[v];
		for(int i=0; i<v;i++){
			adjacencyList[i] = new LinkedList<Integer>();
		}		
	}
	
	public void addEdge(int v, int n){
		adjacencyList[v].add(n);
	}
	
	public boolean searchNode(int target, int v, boolean[] visited){
		count ++;
		visited[v] = true;
		System.out.print(v + " ");
		if(v == target){
			System.out.println("FOUND");
			return true;
		}
		
		
		Iterator<Integer> iterator = adjacencyList[v].listIterator();

		while(iterator.hasNext()){
			Integer i = iterator.next();
			
			if(visited[i] == false && searchNode(target, i, visited) == true){
				return true; //otherwise continue searching other neighbors
			}
		}
		return false; 
		
		
	}
	public boolean DFS(int target,int start){
		boolean[] visited = new boolean[V];
		return searchNode(target,start,visited);
	}
	
	public static void main(String[] args){
		DFSAdjacencyList graph = new DFSAdjacencyList(7);
		graph.addEdge(1,3);
		graph.addEdge(3,1);
		graph.addEdge(0,2);
		graph.addEdge(2,0);
		graph.addEdge(2,6);
		graph.addEdge(6,2);
		graph.addEdge(4,5);
		graph.addEdge(5,4);
		graph.addEdge(1,0);
		graph.addEdge(0,1);
		graph.addEdge(2,4);
		graph.addEdge(4,2);
		
		boolean b = graph.DFS(6, 5);
		System.out.println(b);
		
		
	}
	
	

}
