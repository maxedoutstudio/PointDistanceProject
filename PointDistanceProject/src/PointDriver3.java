
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class PointDriver3 {
	
	//Inputs scanner for all classes in driver

	static Scanner keys = new Scanner(System.in);


	public static void main(String[] args) throws IOException{
		
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
		
		int looping = 1;
		
		while(looping > 0){
		
			System.out.println("Enter coordinates of your central point");
			
			Point2D p = createPointClient();
			
			System.out.println("What is your max distance?");
			
			double maxdistance = keys.nextDouble();
	
			Point2DArray a2 = a1.getPointsWithinDistanceAdv(p,maxdistance);
			
			//Create distances for each point in a2
			
			double[] dists = a2.getDistances(p);
			
			//Starts file in which to save points & distances
			
			File file2 = new File("src/pointsout" + looping + ".txt");
			FileWriter out = new FileWriter(file2);
			BufferedWriter write = new BufferedWriter(out);
			
			for(int i = 0; i<a2.getLength(); i++){
				String s = (a2.getPoint(i).toString() + " " + dists[i]);
				write.write(s);
				write.newLine();
				write.flush();
			}
			
			write.close();
			out.close();
			
			System.out.println("The points within " + maxdistance + " of point " + p.toString() + " have been written to pointsout" + looping + ".txt");
			
			System.out.println("Start new search? (Y/N) ");
			
			String contsearch = keys.next();
			
			looping += 1;
		
			if(contsearch.equals("N") || contsearch.equals("n")){
				looping = 0;
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
