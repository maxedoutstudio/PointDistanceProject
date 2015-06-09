package com.maxedoutstudio.pointer;

public class Point2D {
	
	private double[] coord = new double[2];
	
	public Point2D(){
		coord[0] = 0;
		coord[1] = 0;
	}
	
	public Point2D(double x,double y){
		coord[0] = x;
		coord[1] = y;
	}
	
	//Used to create Point2D object from string of format x,y
	
	public Point2D(String s){
		String[] coordinates = s.split(",");
		
		coord[0] = Double.parseDouble(coordinates[0]);
		coord[1] = Double.parseDouble(coordinates[1]);
		
	}
	
	public double getX(){
		return coord[0];
	}
	
	public double getY(){
		return coord[1];
	}
	
	public void setX(double x){
		this.coord[0] = x;
	}
	
	public void setY(double y){
		this.coord[1] = y;
	}
	
	public boolean equals(Point2D other){
		if((coord[0] == other.coord[0]) && (coord[1] == other.coord[1]))
			return true;
		return false;
	}
	
	public Point2D copy(){
		Point2D temp = new Point2D(coord[0],coord[1]);
		return temp;
	}
	
	public double distance(Point2D other){
		double d_x = Math.abs(other.coord[0]-coord[0]);
		double d_y = Math.abs(other.coord[1]-coord[1]);
		return Math.sqrt(Math.pow(d_x, 2)+Math.pow(d_y, 2));
	}
	
	public String toString(){
		return ("(" + coord[0] + "," + coord[1] + ")");
	}
	

	
	
}
