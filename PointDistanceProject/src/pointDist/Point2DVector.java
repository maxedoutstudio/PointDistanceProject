package pointDist;

public class Point2DVector extends Point2D {
	
	private Point2D origin;
	
	public Point2DVector(double originX,double originY,double x, double y) {
		super(x, y);
		origin = new Point2D(originX,originY);
	}

	public Point2DVector(Point2D origin,double x, double y) {
		super(x, y);
		this.origin = origin;
	}

	public Point2DVector(Point2D origin,Point2D point) {
		super(point);
		this.origin = origin;
	}
	
	//Copy constructor
	public Point2DVector(Point2DVector other){
		x = other.x;
		y = other.y;
		origin.x = other.origin.x;
		origin.y = other.origin.y;
	}
	
	public double getAngle(){
		return Math.atan2(y-origin.y, x-origin.y);
	}
	
	//Checks the angle, if negative, adds PI, otherwise simply returns the angle
	public double getAbsoluteAngle(){
		double angle = getAngle();
		if(angle < 0){
			return angle+Math.PI;
		} else {
			return angle;
		}
		
	}
	
	public double getAngleBetweenVectors(Point2DVector other){
		return Math.acos((getDotProduct(other))/(getLength() * other.getLength()));
	}
	
	public double getDotProduct(Point2DVector other){
		return (((x-origin.x)*(other.x-other.origin.x))+((y-origin.y)*(other.y-other.origin.y)));
	}

	public double getLength(){
		return (Math.sqrt(Math.pow(x-origin.x, 2) + Math.pow(y-origin.y,2)));
	}
	
	//Returns a vector that is equal to this one translated to the origin of another one
	public Point2DVector getTranslatedVector(Point2DVector other){
		Point2DVector temp = new Point2DVector(origin.x,origin.y,x,y);
		double dX = other.origin.x - origin.x;
		double dY = other.origin.y - origin.y;
		temp.origin.x += dX; temp.origin.y += dY;
		temp.x += dX; temp.y += dY;
		return temp;
	}
	
	
	/**
	 * @return returns a flipped vector, where its origin is its point and vice versa
	 */
	public Point2DVector getFlippedVector(){
		return new Point2DVector(x,y,origin.x,origin.y);
	}
	
	
	public boolean sameOrigin(Point2DVector other){
		if(origin.equals(other.origin)){
			return true;
		} else {
			return false;
		}
		
	}
	
	//Checks if the origin of the other vector is at the point of this vector
	public boolean endsAtOriginOfOther(Point2DVector other){
		if(other.origin.x == x && other.origin.y == y){
			return true;
		} else {
			return false;
		}
		
	}
	
	public String toString(){
		return "Origin: (" + origin.x + "," + origin.y + ") , Point: (" + x + "," + y + ")";
	}


}
