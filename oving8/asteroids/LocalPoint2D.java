package oving8.asteroids;

/**
 * LocalPoint2D not used!
 * @author GuoJunjun
 * 
 *         Vi har brukt typen Point2D for å angi at posisjon (position) og fart
 *         (speed) beskrives av to verdier (koordinatpar/vektorkoordinater).
 *         Massen beregnes, så den er angitt som en operasjon og ikke som et
 *         attributt.
 */
public class LocalPoint2D {
	
	// private double[] position = new double[2];
	// private double[] speed = new double[2];
	private double[]	point	= new double[2];
	
	// private double x,y;
	
	// public Point2D(double[] position, double[] speed) {
	public LocalPoint2D(double x, double y) {
		this.point[0] = x;
		this.point[1] = y;
		// this.x=x;
		// this.y=y;
	}
	
	public LocalPoint2D(double[] speed) {
		this.point[0] = speed[0];
		this.point[1] = speed[1];
	}
	
	public LocalPoint2D() {
	}
	
	public void setPosition(double px, double py) {
		this.point[0] = px;
		this.point[1] = py;
		// this.x=px;
		// this.y=py;
	}
	
	public void setSpeed(double vx, double vy) {
		this.point[0] = vx;
		this.point[1] = vy;
		// this.x=vx;
		// this.y=vy;
	}
	
	public double[] getSpeed() {
		return point;
	}
	
	public double[] getPosition() {
		return point;
	}
}
