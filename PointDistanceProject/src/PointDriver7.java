


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class PointDriver7 {
	
	//Inputs scanner for all classes in driver

	static Scanner keys = new Scanner(System.in);


	public static void main(String[] args) throws IOException{
		
		//Origin, to be used later
		Point2D origin = new Point2D(0,0);
		
		File file = new File("points.txt");
		
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


		/*Controls the max-min values, in following order:
		 * maxs: amax,bmax,cmax,alphamax,betamax,gammamax,deltamax;
		 * mins: amin,bmin,cmin,alphamin,betamin,gammamin,deltamin;*/
		
		double[] maxs = new double[7]; 
		double[] mins = new double[7]; 
		
		File file2 = new File("limits.txt");

		Scanner in2 = new Scanner(file2);

		int line_counter = 0;
		
		while(in2.hasNextLine()){ 

			String line = in2.nextLine();
			String[] ar= line.split(",");
			
			maxs[line_counter] = Double.parseDouble(ar[0]);
			maxs[line_counter] = Double.parseDouble(ar[1]);	
			
			line_counter++;
		}

		in2.close();
		
		//This is array of point2d arrays
		Point2DArray[] aofa = new Point2DArray[a1.getLength()-1]; //Since we don't make a list for the last point
		
		/*Initializes the arrays
		for(int i = 0;i<aofa.length;i++){
			aofa[i] = new Point2DArray();
		}
		*/
		
		for(int i = 0;i<a1.getLength()-1;i++){

			for(int c = i+1;c<a1.getLength()-1;c++){

				for(int d = c+1;d<a1.getLength()-1;d++){

					Point2DArray temp = new Point2DArray();
					
					
					//Checks that the Triangle conforms to specs
					
					
					
					}


				}

			}
			
		}
		
		/*
		 * OLD WAY
		 * 
		for(int i = 0;i<a1.getLength();i++){
			Point2DArray a2 = new Point2DArray();
			for(int c = i+1;c<(a1.getLength()-1);c++){
				Point2D p1 = new Point2D(a1.getPoint(i),a1.getPoint(c));
				a2.addPoint(p1);	
			}
			aofa[i] = a2;
		}
		
		
		for(int i = 0;i<aofa.length;i++){
			for(int c = 0;c<aofa[i].getLength();c++){
				double[] temp = new double[3];
				temp[0] = aofa[i].getPoint(c).getLength();
				
				for(int d = 0;d<aofa[c+1].getLength();d++){
					temp[1] = aofa[c+1].getPoint(d).getLength();
					temp[2] = aofa[i].getPoint(c+d+1).getLength();
				}
				
				
				
				
			}
			
		}
		
		
		//Starts file in which to save points & distances

		File file2 = new File("pointsout.txt");
		FileWriter out = new FileWriter(file2);
		BufferedWriter write = new BufferedWriter(out);

		for(int c = 0; c<a1.getLength();c++){
		
			Point2DArray a2 = a1.getPointsWithinDistanceAdv2(a1.getPoint(c),maxdistance);
			
			//Create distances for each point in a2

			double[] dists = a2.getDistances(a1.getPoint(c));
			
			for(int i = 0; i<a2.getLength(); i++){
				String s = String.valueOf(dists[i]);
				write.write(s);
				write.newLine();
				write.flush();
			}
			
			//Removes duplicate coords

			
			a1.removePoint(c);
			
			
			
		}
		
		write.close();
		out.close();

		System.out.println("Job complete. Output written to pointsout.txt");

		
		keys.close();
		*/
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
