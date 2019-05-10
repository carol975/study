package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjacencyList {
	private int V;
	private LinkedList<Integer>[] adjacencyList;
	
	public BFSAdjacencyList(int v){
		V = v;
		adjacencyList = new LinkedList[v];
		for(int i=0; i<v;i++){
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int n){
		adjacencyList[v].add(n);
	}
	
	public boolean bfsUtil(int target, int start, boolean[] visited){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(q.isEmpty() == false){
			int node = q.remove();
			if(visited[node] == false){
				System.out.print(node + " ");
				if(node == target){
					return true;
				}
				visited[node] = true;
				
				Iterator<Integer> iterator = adjacencyList[node].listIterator();
				while(iterator.hasNext()){
					q.add(iterator.next());
				}
			}
			
			
		}
		
		return false;
	}
	public boolean BFS(int target, int start){
		boolean[]visited = new boolean[V];
		return bfsUtil(target, start, visited);
	}
	
	public static void main(String[] args){
		BFSAdjacencyList graph = new BFSAdjacencyList(7);
		graph.addEdge(1,3);
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

		
		boolean b = graph.BFS(1, 3);
		System.out.println(b);
	}
}
