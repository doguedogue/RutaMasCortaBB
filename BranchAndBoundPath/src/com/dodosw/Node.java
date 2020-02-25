package com.dodosw;

/**
 * @author RVILCHES
 * 
**/

//state space tree nodes 
public class Node {
	private Node parent; 

	private int x, y; 
 
	private int cost; 

	// stores the number of moves so far 
	private int level; 
	
	public Node(int x, int y, int level, Node parent) {
		this.x= x;
		this.y= y;
		this.level = level;
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean equals(Node node) {
		if (getX() != node.getX())
			return false;
		if (getY() != node.getY())
			return false;		
		if (getLevel() != node.getLevel())
			return false;
		if (getCost() != node.getCost())
			return false;
		return true;
		
	}
}
