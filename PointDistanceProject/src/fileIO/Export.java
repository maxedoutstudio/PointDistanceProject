package fileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Export {

	public static void exportPoints(File file,ArrayList<double[]> results) throws IOException{
		

		FileWriter out = new FileWriter(file);
		BufferedWriter write = new BufferedWriter(out);

		for(double[] c: results){

			String s = c[0] + "," + c[1] + "," + c[2] + "," + c[3] + "," + c[4] + "," + c[5] + "," + c[6];

			write.write(s);
			write.newLine();
			write.flush();

		}

		write.close();
		out.close();

		System.out.println("Job complete. Output written to pointsout.txt");

		
	}
	
}
