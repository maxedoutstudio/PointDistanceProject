
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
	
	//Copy constructor
	
	public Point2D(Point2D other){
		coord[0] = other.coord[0];
		coord[1] = other.coord[1];
	}
	
	//Create vector from two points
	public Point2D(Point2D p1, Point2D p2){
		coord[0] = (p2.getX()-p1.getX());
		coord[1] = (p2.getY()-p1.getY());
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
	
	public double getAngleOfVectorBetweenPoints(Point2D other){
		double d_y = (other.coord[1]-coord[1]);
		double d_x = (other.coord[0]-coord[0]);
		
		if(d_x == 0){
			if(d_y > 0){
				return ((Math.PI)/2);
			}
			else if(d_y < 0){
				return ((Math.PI)*(3/2));
			} else {
				return 0;
			}
		}
		else if(d_y == 0){
			if(d_x > 0){
				return 0;
			}
			else if(d_x < 0){
				return (Math.PI);
			} else {
				return 0;
			}
		}
		else if(d_y >= 0){
			if(d_x >= 0){
				return Math.atan(d_y/d_x);
			} else {
				return (Math.abs(Math.atan(d_y/d_x)) + ((Math.PI)/2));
			}
		} else {
			if(d_x >= 0){
				return (Math.abs(Math.atan(d_y/d_x)) + ((3/2)*(Math.PI)));
			} else {
				return (Math.abs(Math.atan(d_y/d_x)) + ((Math.PI)));
			}
			
		}
	}
	
	public String toString(){
		return ("(" + coord[0] + "," + coord[1] + ")");
	}
	
	//Vector related things
	
	//adds another vector to said vector
	public void add(Point2D other){
		coord[0] += other.coord[0];
		coord[1] += other.coord[1];
	}
	public Point2D getVectorBetweenPoints(Point2D other){
		Point2D pointo = new Point2D((other.getX()-getX()),other.getY()-getY());
		return pointo;
	}
	
	
	
	public double getAngleBetweenVectors(Point2D other){
		return Math.acos((getDotProduct(other))/(getLength() + other.getLength()));
	}
	
	public double getDotProduct(Point2D other){
		return ((coord[0]*other.coord[0])+(coord[1]*other.coord[1]));
	}

	//Calculates length of vector from origin to point
	public double getLength(){
		return (Math.sqrt(Math.pow(coord[0], 2) + Math.pow(coord[1],2)));
	}
	
	
}
