package com.dodosw;

/**
 * @author RVILCHES
 * 
 */


public class PathBranchAndBoundApp {
	
	public static void main (String []args) {
		// input maze
		int[][] mat =
		{
			{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
			{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
		};

		BranchAndBoundSearch search = new BranchAndBoundSearch();

		// Find shortest path from source (0, 0) to
		// destination (7, 5)
		search.resuelve(mat, 0, 0, 7, 5); 
	}
	
}
