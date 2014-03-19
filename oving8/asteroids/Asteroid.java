package oving8.asteroids;

/***
 * 
 * @author GuoJunjun Asteroid
 * 
 *         public Asteroid(double density, double radius) - initialiserer
 *         tetthet og radius. Lag gjerne flere konstruktører, for å gjøre det
 *         lettere å lage asteroider med ulike konturer.
 * 
 *         double getMass() - beregner massen fra tetthet og radius.
 */

public class Asteroid extends SpaceObject {
	
	protected double	density;
	protected double	radius;
	
	public Asteroid(double density, double radius) {
		this.density = density;
		this.radius = radius;
	}
	
	public double getMass() {
		// p = m/v
		return (density * (4 / 3) * Math.PI * radius * radius * radius);
	}
}
