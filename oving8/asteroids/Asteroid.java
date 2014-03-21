package oving8.asteroids;

/***
 * 
 * Asteroid
 * 
 * public Asteroid(double density, double radius) - initialiserer tetthet og
 * radius. Lag gjerne flere konstruktører, for å gjøre det lettere å lage
 * asteroider med ulike konturer.
 * 
 * double getMass() - beregner massen fra tetthet og radius.
 */

public class Asteroid extends SpaceObject {
	
	protected final double	density;
	protected final double	radius;
	
	public Asteroid(double density, double radius) {
		this.density = density;
		this.radius = radius;
	}
	
	// public Asteroid(double density, double length, double width, double
	// height) {
	// this.density = density;
	// this.length = length;
	// this.width = width;
	// this.height = height;
	// }
	
	public Asteroid(double density, double radius, int cornerCount,
			double irregularity) {
		this(density, radius);
		for (int i = 0; i < cornerCount; i++) {
			double angle = i * Math.PI * 2 / cornerCount;
			double d = (1.0 - irregularity) + Math.random() * irregularity;
			addPolarPoint(angle, radius * d * 20);
		}
		setTranslateX(radius);
		setTranslateY(radius);
	}
	
	@Override
	public double getMass() {
		return (density * (4 / 3) * Math.PI * Math.pow(radius, 3));
		// p = m/v
		// return (density * (4 / 3) * Math.PI * radius * radius * radius);
	}
}
