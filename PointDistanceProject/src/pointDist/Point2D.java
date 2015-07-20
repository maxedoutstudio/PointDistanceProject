package pointDist;

public class Point2D {
	
	protected double x;
	protected double y;
	
	public Point2D(){
		x = 0;
		y = 0;
	}
	
	public Point2D(double x,double y){
		this.x = x;
		this.y = y;
	}
	
	//Copy constructor
	
	public Point2D(Point2D other){
		x = other.x;
		y = other.y;
	}
	
	//Used to create Point2D object from string of format x,y
	
	public Point2D(String s){
		String[] coordinates = s.split(",");
		
		x = Double.parseDouble(coordinates[0]);
		y = Double.parseDouble(coordinates[1]);
		
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public boolean equals(Point2D other){
		if((x == other.x) && (y == other.y))
			return true;
		return false;
	}
	
	public Point2D copy(){
		Point2D temp = new Point2D(x,y);
		return temp;
	}
	
	public double distance(Point2D other){
		double d_x = Math.abs(other.x-x);
		double d_y = Math.abs(other.y-y);
		return Math.sqrt(Math.pow(d_x, 2)+Math.pow(d_y, 2));
	}
	
	public double getAngle(){
		return Math.atan2(y, x);
		
	}
	
	
	public String toString(){
		return ("(" + x + "," + y + ")");
	}
	
	
	//Vector related things
	
	//adds another vector to said vector
	public void add(Point2D other){
		x += other.x;
		y += other.y;
	}
	
	public Point2D getVectorBetweenPoints(Point2D other){
		Point2D pointo = new Point2D((other.getX()-getX()),other.getY()-getY());
		return pointo;
	}
	
	
	//Calculates length of vector from origin to point
	public double getLength(){
		return (Math.sqrt(Math.pow(x, 2) + Math.pow(y,2)));
	}
	
	
	

	
}
