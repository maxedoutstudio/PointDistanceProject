
public class testo {

	public static void main(String[] args){
		
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(1,-1.73);
		Point2D p3 = p1.getVectorBetweenPoints(p2);
		
		System.out.println("From P1");
		
		System.out.println(Math.toDegrees(p1.getAngleBetweenVectors(p2)));
		System.out.println(Math.toDegrees(p1.getAngleBetweenVectors(p3)));
		
		System.out.println("From P2");
		
		System.out.println(Math.toDegrees(p2.getAngleBetweenVectors(p1)));
		System.out.println(Math.toDegrees(p2.getAngleBetweenVectors(p3)));
		
		System.out.println("From P3");
		
		System.out.println(Math.toDegrees(p3.getAngleBetweenVectors(p1)));
		System.out.println(Math.toDegrees(p3.getAngleBetweenVectors(p2)));
	}
}
