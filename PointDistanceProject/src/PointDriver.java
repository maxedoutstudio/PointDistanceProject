import java.util.Scanner;


public class PointDriver {
	
	//Inputs scanner for all classes in driver
	static Scanner keys = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		Point2DArray a1 = new Point2DArray();
		
		boolean enterpoints = true;
		
		for(int i = 1;enterpoints == true;i++){
			Point2D p1 = new Point2D();
			System.out.println("Please enter coordinates for Point #" + i);
			System.out.print("Enter x coordinate:");
			p1.setX(keys.nextDouble());
			System.out.print("Enter y coordinate:");
			p1.setY(keys.nextDouble());
			a1.addPoint(p1);
			System.out.println("Cotinue entering points?");
			String input = keys.next();
			if(input.equals("N") || input.equals("n")){
				enterpoints = false;
			}
		}
		
		//Searching loop
		
		boolean looping = true;
		
		while(looping){
		
			System.out.println("Enter coordinates of your central point");
			
			Point2D p = createPointClient();
			
			System.out.println("What is your max distance?");
			
			double maxdistance = keys.nextDouble();
			
			System.out.println("Here are the points within " + maxdistance + " of point " + p.toString());
	
			Point2DArray a2 = a1.getPointsWithinDistanceAdv(p,maxdistance);
			
			a2.printPoints();
			
			System.out.println("Continue searching searching (Y/N) ");
			
			String contsearch = keys.next();
		
			if(contsearch.equals("N") || contsearch.equals("n")){
				looping = false;
			}
		}
		
		keys.close();
	}
	
	
	//Point distance part of program
	
	//private static 
	
	//User friendly version of setX,setY
	
	public static Point2D createPointClient(){
		Point2D p = new Point2D();
		System.out.println("Please enter the x-coordinate:");
		double x = keys.nextDouble();
		p.setX(x);
		System.out.println("Please enter the y-coordinate:");
		double y = keys.nextDouble();
		p.setY(y);
		
		return p;
	}

}
