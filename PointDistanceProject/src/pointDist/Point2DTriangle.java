package pointDist;

public class Point2DTriangle {
	
	
	
	private Point2D[] points = new Point2D[3];
	
	/*
	private Point2D pointA;
	private Point2D pointB;
	private Point2D pointC;
	
	private double angleA;
	private double angleB;
	private double angleC;
	*/
	
	/*Copy Constructor
	public Point2DTriangle(Point2DTriangle other){
		pointA = other.pointA;
		pointB = other.pointB;
		pointC = other.pointC;
		
		//updateAngles();
	}
	*/
	
	public Point2DTriangle(Point2D pointA,Point2D pointB,Point2D pointC){
		points[0] = pointA;
		points[1] = pointB;
		points[2] = pointC;
	}
	

	/**
	 * @param mins
	 * @param maxs
	 * @return true when limits are respected, false when not
	 */
	
	public boolean onSameLine(){
		if(points[0].x * (points[1].y - points[2].y) + points[0].x * (points[2].y - points[0].y) + points[2].x * (points[0].y - points[1].y) == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public double[] checkLimits(double[] mins,double[] maxs){

		//Since 3 points on same line cannot form legit triangle
		if(onSameLine()){
			return null;
		}
		
		Point2DVector[] sides = new Point2DVector[3]; //Formatted as AB, BC , CA
		
		
		double[] returnArray = new double[7];
		
		sides[0] = new Point2DVector(points[0],points[1]);
		sides[1] = new Point2DVector(points[1],points[2]);
		sides[2] = new Point2DVector(points[2],points[0]);
		
		int smallest = 0, largest = 0, mid;
		
		for(int i = 1;i<points.length;i++){
			
			for(int c = i;c<points.length;c++){
				
				if(sides[c].getLength() > sides[largest].getLength()){
					largest = c;
				} else if (sides[c].getLength() < sides[smallest].getLength()){
					smallest = c;
				}
			}
				
		}
		
		mid = 3 - largest - smallest;
				
		returnArray[0] = sides[smallest].getLength();
		returnArray[1] = sides[mid].getLength();
		returnArray[2] = sides[largest].getLength();
		returnArray[3] =  Math.PI - sides[mid].getTranslatedVector(sides[largest]).getAngleBetweenVectors(sides[largest]);
		returnArray[4] = Math.PI - sides[largest].getTranslatedVector(sides[smallest]).getAngleBetweenVectors(sides[smallest]);
		returnArray[5] =  Math.PI - sides[smallest].getTranslatedVector(sides[mid]).getAngleBetweenVectors(sides[mid]);
		returnArray[6] = sides[mid].getAbsoluteAngle();
		
		//This part checks the sides for mins and maxs
		
		if(returnArray[0] < mins[0] || returnArray[0]> maxs[0]){
			return null;
		}
		if(returnArray[1] < mins[1] || returnArray[1] > maxs[1]){
			return null;
		}
		if(returnArray[1] < mins[2] || returnArray[1] > maxs[2]){
			return null;
		}
		
		//This part checks the angle for the mins, maxs
		
		if(returnArray[3] < mins[3] || returnArray[3] > maxs[3]){
			return null;
		}
		if(returnArray[4] < mins[4] || returnArray[4] > maxs[4]){
			return null;
		}
		if(returnArray[5] < mins[5] || returnArray[5] > maxs[5]){
			return null;
		}
		if(returnArray[6] < mins[6] || returnArray[6] > maxs[6]){
			return null;
		}
		
		return returnArray;
		
		
		/* Begining of old method using technique of flipping vectors. Seemingly translating them is easier.
		 * 
		if(sides[mid].endsAtOriginOfOther(sides[largest])){
			Point2DVector tempFlipped = sides[mid].getFlippedVector();
			if(Math.abs(tempFlipped.getAngleBetweenVectors(sides[largest])) < mins[3] || Math.abs(tempFlipped.getAngleBetweenVectors(sides[largest])) > maxs[3]){
				return null;
			}
		} else {
			Point2DVector tempFlipped = sides[largest].getFlippedVector();
			if(Math.abs(sides[mid].getAngleBetweenVectors(tempFlipped)) < mins[3] || Math.abs(sides[mid].getAngleBetweenVectors(tempFlipped)) > maxs[3]){
				return null;
			}
		}
		*/
		

		
		
		
		
	}
	

	
	
	

	
}
