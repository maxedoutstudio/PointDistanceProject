package pointDist;

import fileIO.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Main {

	public static ArrayList<double[]> Run(File pointsFile,File limitsFile) throws IOException{
		
		
		ArrayList<Point2D> a1 = fileIO.Import.importPoints(pointsFile);
			
		//Displays amount of points in file
		System.out.println(a1.size() + " Points have been succesfully read from points.txt");

		
		double[][] limits = fileIO.Import.importLimits(limitsFile);
		double[] maxs =  limits[1]; 
		double[] mins = limits[0]; 
		
		//ArrayList containing the results
		
		ArrayList<double[]> results = new ArrayList<double[]>();
		
		for(int i = 0;i<a1.size()-1;i++){

			for(int c = i+1;c<a1.size()-1;c++){

				for(int d = c+1;d<a1.size()-1;d++){

					Point2DTriangle temp = new Point2DTriangle(a1.get(i),a1.get(c),a1.get(d));
					
					double[] tempResult = temp.checkLimits(mins, maxs);

					if(tempResult!= null){
						
						results.add(tempResult);

					}


				}

			}
			
		}
		
		for(double[] d: results){
			for(double d2:d){
				System.out.println(d2);
			}
		}
		
		return results;
		
		
	}
	
	/*
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
	*/
	

}
