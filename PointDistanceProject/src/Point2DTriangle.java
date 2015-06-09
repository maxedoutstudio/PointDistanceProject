
public class Point2DTriangle extends Point2DArray {
	
	/*Controls the max-min values, in following order:
	 * maxs: amax,bmax,cmax,alphamax,betamax,gammamax,deltamax;
	 * mins: amin,bmin,cmin,alphamin,betamin,gammamin,deltamin;*/
	
	private double[] maxs = new double[7]; 
	private double[] mins = new double[7]; 

	public Point2DTriangle(double[] maxs,double[] mins){
		super();
		System.arraycopy(maxs, 0, this.maxs, 0, maxs.length);
		System.arraycopy(mins, 0, this.mins, 0, maxs.length);
	}
	
	//Checks if Triangle satisfies conditions
	
	public boolean isTriangle(){
		if(super.getLength() == 3){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkLimits(){
		
		if(!isTriangle()){
			return false;
		}
		
		
		double[] length = new double[3];
		length[0] = super.getPoint(0).distance(super.getPoint(1));
		length[1] = super.getPoint(1).distance(super.getPoint(2));
		length[2] = super.getPoint(2).distance(super.getPoint(0));
		
		int largest, smallest;
		
		
		
		
	}
	
	
}
