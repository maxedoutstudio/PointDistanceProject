package fileIO;

import java.util.ArrayList;

import pointDist.Point2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Import {
	 
	public static ArrayList<Point2D> importPoints(File file) throws IOException{
		
		
		ArrayList<Point2D> a1 = new ArrayList<Point2D>();
		
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()){ 
			
			String line = in.nextLine();
			
			Point2D p1 = new Point2D(line);
			
			a1.add(p1);
			
		}

		in.close();
		
		return a1;
		
		
	}
	
	
	public static double[][] importLimits(File file) throws IOException{
		
		/*Controls the max-min values, in following order:
		 * limits[0] -> mins , limits[1] -> maxs
		 * maxs: amax,bmax,cmax,alphamax,betamax,gammamax,deltamax;
		 * mins: amin,bmin,cmin,alphamin,betamin,gammamin,deltamin;*/
		
		
		double[][] limits = new double[2][7];

		Scanner in2 = new Scanner(file);

		int line_counter = 0;
		
		while(in2.hasNextLine()){ 

			String line = in2.nextLine();
			String[] ar= line.split(",");
			
			limits[0][line_counter] = Double.parseDouble(ar[0]);
			limits[1][line_counter] = Double.parseDouble(ar[1]);	
			
			line_counter++;
		}

		in2.close();
		
		return limits;
		
		
	}

}
