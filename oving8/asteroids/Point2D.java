package oving8.asteroids;

/**
 * 
 * @author GuoJunjun
 * 
 *         Vi har brukt typen Point2D for å angi at posisjon (position) og fart
 *         (speed) beskrives av to verdier (koordinatpar/vektorkoordinater).
 *         Massen beregnes, så den er angitt som en operasjon og ikke som et
 *         attributt.
 */
public class Point2D {
	
	private double[]	position	= new double[2];
	private double[]	speed		= new double[2];
	
	public Point2D(double[] position, double[] speed) {
		this.position = position;
		this.speed = speed;
	}
	
	public Point2D() {
	}
	
	public void setPosition(double px, double py) {
		this.position[0] = px;
		this.position[1] = py;
	}
	
	public void setSpeed(double vx, double vy) {
		this.speed[0] = vx;
		this.speed[1] = vy;
	}
	public double [] getSpeed(){
		return speed;
	}
	public double [] getPosition(){
		return position;
	}
}
