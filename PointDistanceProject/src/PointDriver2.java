
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class PointDriver2 {
	
	//Inputs scanner for all classes in driver

	static Scanner keys = new Scanner(System.in);


	public static void main(String[] args) throws FileNotFoundException{
		
		File file = new File("src/points.txt");
		
		Point2DArray a1 = new Point2DArray();
		
		
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()){
			
			String line = in.nextLine();
			
			Point2D p1 = new Point2D(line);
			
			a1.addPoint(p1);
			
		}
		
		in.close();
		
		//Displays amount of points in file
		System.out.println(a1.getLength() + " Points have been succesfully read from points.txt");
	
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
			
			System.out.println("Start new search? (Y/N) ");
			
			String contsearch = keys.next();
		
			if(contsearch.equals("N") || contsearch.equals("n")){
				looping = false;
			}
			
		}
		
		
		keys.close();
		
	}
	
	
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
