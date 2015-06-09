package com.maxedoutstudio.pointer;

public class Point2DArray {
	
	private Point2D[] points;
	
	public Point2DArray(){
		points = new Point2D[0];
	}
	
	public int getLength(){
		return points.length;
	}
	
	public void addPoint(Point2D newpoint){
		Point2D[] newpoints = new Point2D[points.length+1];
		
		for(int i = 0;i<points.length;i++){
			newpoints[i] = points[i];
		}
		
		newpoints[points.length] = newpoint;
		
		points = newpoints;
		
	}
	
	public void removePoint(int index){
		Point2D[] newpoints = new Point2D[points.length-1];
		
		for(int i = 0;i<index;i++){
			newpoints[i] = points[i];
		}
		
		for(int i = index+1;i<points.length;i++){
			newpoints[i-1] = points[i];
		}
		
		points = newpoints;
		
	}
	
	//Check if array contains a given point
	public boolean hasPoint(Point2D point){
		for(int i = 0;i<points.length;i++){
			if(points[i].equals(point)){
				return true;
			}
		}
		return false;
	}
	
	//public void addPoints(Point2DArray points){
	//	for(int i = 0;i<points[i].length;i++){
	//		addPoint(points[i]);
	//	}
	//}
	
	public Point2D getPoint(int index){
		return points[index].copy();
	}
	
	//Get distances and returns in array
	public double[] getDistances(Point2D point){
		double[] distarray = new double[points.length];
		for(int i = 0;i<points.length;i++){
			distarray[i] = points[i].distance(point);
		}
		return distarray;
	}
	//Prints distances for user
	
	public void printDistances(Point2D point){
		
		for(int i = 0;i<points.length;i++){
			System.out.print(points[i].distance(point) + " ");
		}
		System.out.println();
	}
	
	//Prints points for user
	
	public void printPoints(){
		for(int i = 0;i<points.length;i++){
			System.out.print(points[i].toString() + " ");
		}
		System.out.println();
		
	}
	
	
	//Gets points within certain distance of point
	public Point2DArray getPointsWithinDistance(int pointindex,double maxdistance){
		Point2DArray array = new Point2DArray();
		
		for(int i = 0; i<points.length;i++){
			//if(i != pointindex){ ##Test remove
			if(points[i].distance(points[pointindex]) <= maxdistance){
				array.addPoint(points[i]);
			}
			//} ##Test remove
		}
		
		return array;
		
	}
	
	public Point2DArray getPointsWithinDistanceAdv(Point2D point,double maxdistance){
		
		Point2DArray array = new Point2DArray();
		
		for(int i = 0;i<points.length;i++){
			
			if(point.distance(points[i]) <= maxdistance){
				array.addPoint(points[i]);
			}
			
		}
		
		return array;
		
	}
	
	public Point2DArray getPointsWithinDistanceAdv2(Point2D point,double maxdistance){

		Point2DArray array = new Point2DArray();

		for(int i = 0;i<points.length;i++){

			if((point.distance(points[i]) <= maxdistance) && !points[i].equals(point)){
				array.addPoint(points[i]);
			}

		}

		return array;

	}
	
	
}
