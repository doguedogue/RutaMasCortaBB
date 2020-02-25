package com.dodosw;

import java.util.Iterator;

/**
 * @author RVILCHES
 * 
**/

import java.util.PriorityQueue;

public class BranchAndBoundSearch {
	private  int INT_MAX = 1000;
	private int N;
		
	// botton, left, top, right 
	private  int row[] = { 1, 0, -1, 0 }; 
	private  int col[] = { 0, -1, 0, 1 }; 
	

	public  void solve(int map[][], int x_ini, int y_ini, int x_fin, int y_fin){ 
		// Create a priority queue to store live nodes of 
		// search tree; 
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparador()); 
		int cont = 0;

		// create a root node and calculate its cost 
		Node root = new Node(x_ini, y_ini, 0, null); 
		root.setCost(calculateCost(map, x_ini, y_ini, x_fin, y_fin)); 

		// Add root to list of live nodes; 
		pq.add(root); //push

		// Finds a live node with least cost, 
		// add its childrens to list of live nodes and 
		// finally deletes it from the list. 
		while (pq.size()>0){ //!empty 
			cont++;
			// Find a live node with least estimated cost 
			// The found node is deleted from the list of 
			// live nodes 
			Node min = pq.poll(); //top //pop

			// if min is an answer node 
			if (min.getCost() == 0){ 
				// print the path from root to destination; 
				printPath(map, min); 
				System.out.println("Número de pasos: "+min.getLevel());
				System.out.println("Número de iteraciones: "+cont);
				return; 
			} 
			
			//RVA Optimización para no repetir estados que ya han sido utilizados
			if (haSidoUtilizado(min, pq))
				continue;

			// do for each child of min 
			// max 4 children for a node 
			for (int i = 0; i < 4; i++){ 
				int x_new =min.getX() + row[i];
				int y_new = min.getY() + col[i];
				
				if (isSafe(x_new, y_new) && map[x_new][y_new]!=0){ 
					// create a child node and calculate 
					// its cost 
					Node child = new Node (x_new, y_new, min.getLevel() + 1, min); 
					child.setCost(calculateCost(map, x_new, y_new, x_fin, y_fin)); 

					// Add child to list of live nodes 
					pq.add(child); //push
				} 
			} 
		} 
	} 	
	
	private boolean haSidoUtilizado(Node min, PriorityQueue<Node> pq) {
		for (Iterator<Node> iterator = pq.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			if (min.equals(node.getParent()))
				return true;
		}
		return false;
		
	}

	// Function to check if (x, y) is a valid matrix cordinate 
	private  boolean isSafe(int x, int y){ 
		return (x >= 0 && x < N && y >= 0 && y < N); 
	} 

	
	// print path from root node to destination node 
	private  void printPath(int mat[][], Node root){ 
		if (root == null) 
			return; 
		printPath(mat, root.getParent()); 
		mat[root.getX()][root.getY()]=3;
		printMatrix(mat); 
		System.out.print("\n"); 
	} 	

	// Function to print N x N matrix 
	public  void printMatrix(int mat[][],int x1, int y1){ 
		for (int i = 0; i < N; i++){ 
			for (int j = 0; j < N; j++) 
				if (i==x1 && j ==y1)
					System.out.print("T "); 
				else 
					System.out.print(mat[i][j]+" "); 
			System.out.print("\n"); 
		} 
	} 	

	// Function to print N x N matrix 
	public  void printMatrix(int mat[][]){ 
		for (int i = 0; i < N; i++){ 
			for (int j = 0; j < N; j++) 
				System.out.print(mat[i][j]+" "); 
			System.out.print("\n"); 
		} 
	} 	

	
	// Function to calculate the number of misplaced tiles 
	// ie. number of non-blank tiles not in their goal position 
	public  int calculateCost(int map[][], int x1, int y1, int x2, int y2){ 
		if (x1 == x2 && y1 == y2)
			return 0;
		else
			return  Math.abs(x1 - (x2+1))+ Math.abs(y1-(y2+1));
	} 
	
	public void resuelve (int mat[][], int x1, int y1, int x2, int y2) {
		N = mat.length;		
		printMatrix(mat);
		System.out.println("********************\n");
		solve (mat, x1, y1, x2, y2);
	}
	
}
