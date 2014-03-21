package oving8.asteroids;

import javafx.geometry.Point2D;

/***
 * 
 * @author GuoJunjun Det er i hovedsak to typer rom-objekter, de som svever
 *         fritt (planeter, asteroider og stjerner) og romskipet, som har
 *         motorkraft. Det som er felles for alle rom-objektene ønsker vi å
 *         samle i superklassen SpaceObject, som de to mer spesialiserte typene
 *         Asteroid og SpaceShip arver fra. Dette er illustrert i diagrammet til
 *         venstre. Vi har brukt typen Point2D for å angi at posisjon (position)
 *         og fart (speed) beskrives av to verdier
 *         (koordinatpar/vektorkoordinater). Massen beregnes, så den er angitt
 *         som en operasjon og ikke som et attributt.
 * 
 *         Det som ikke kommer frem i dette diagrammet er hvordan vi også ønsker
 *         å bygge på Polygon-klassen i JavaFX, for å gjøre det lettere å vise
 *         rom-objektene som grafikk i et vindu på skjermen. Med Polygon som
 *         superklasse for SpaceObject, så vil en kunne angi et sett punkter som
 *         utgjør konturen til rom-objektene. Siden Polygon i praksis også har
 *         en posisjon (i kraft av å være en Node), så trenger en ikke lagre
 *         denne som et eget felt i SpaceObject, så den faktiske implementasjon
 *         blir litt annerledes enn vist til venstre. Og for å gjøre det litt
 *         lettere å utnytte mulighetene i Polygon-klassen (spesielt
 *         koordinat-håndtering er litt fiklete), så har vi lage en
 *         hjelpeklasse, kalt BaseSpaceObject, som kan brukes som den direkte
 *         superklassen til SpaceObject og som selv arver fra Polygon. Dette er
 *         illustrert til høyre.
 * 
 *         Kode m/dokumentasjon for BaseSpaceObject-klassen finner du nederst på
 *         denne siden.
 * 
 *         De spesifikke metodene i SpaceObject, Asteroids og SpaceShip, som du
 *         må implementere er som følger:
 * 
 *         SpaceObject
 * 
 *         Point2D getSpeed() - returnerer farten som et
 *         (vektor)koordinatpar-objekt. setSpeed(double vx, double vy) - setter
 *         farten til den angitt vektoren [vx, vy]. accelerate(double ax, double
 *         ay) - øker farten med den angitte akselerasjonsvektoren double
 *         getMass() - returnerer massen, som er 0 hvis ikke annet er angitt.
 *         applyForce(double fx, double fy) - justerer objektet iht. den angitte
 *         kraftvektoren. Dersom massen er 0, så skal det utløses et unntak av
 *         typen IllegalStateException. boolean intersects(SpaceObject other) -
 *         returnerer true dersom den andre SpaceObject-instansen overlapper
 *         (kolliderer) med denne instansen, ellers false. Se eget avsnitt
 *         lenger ned. void tick() - denne metoden kalles for hvert steg i
 *         simuleringen og skal justere alle dynamiske egenskaper iht. reglene
 *         for verdenen, f.eks. posisjon basert på farta.
 */
public class SpaceObject extends BaseSpaceObject {
	protected double speedX,speedY;
	//protected Point2D	speed;			// = new Point2D(0, 0);
	
	// protected Point2D acclerate; // = new Point2D(0, 0);
	
	//protected double	mass	= 0;
	// protected Point2D force; // = new Point2D(0,0);
	
	//protected double	length	= 0, width = 0, height = 0;
	
	public Point2D getSpeed() {
		return new Point2D(speedX, speedY);
	}
	
	public void setSpeed(double vx, double vy) {
		this.speedX = vx;// = new Point2D(vx, vy);
		this.speedY = vy;
	}
	
	public void accelerate(double ax, double ay) {
		speedX+=ax;
		speedY+=ay;
		// this.acclerate = new Point2D(ax, ay);
		//setSpeed(ax + getSpeed().getX(), ay + getSpeed().getY());
	}
	
	// @Override
	public double getMass() {
		return 0;// mass;
	}
	
	public void applyForce(double fx, double fy) {
		if (getMass() == 0) {
			throw new IllegalStateException("mass er null!");
		} else {
			accelerate(fx / getMass(), fy / getMass());
			// this.force = new Point2D(fx, fy);
			// F=am
			// accelerate(force.getX() / getMass(), force.getY() / getMass());
		}
	}
	
	/**
	 * 
	 * @param other
	 * @return returnerer true dersom den andre SpaceObject-instansen overlapper
	 *         (kolliderer) med denne instansen, ellers false.
	 * 
	 *         intersects-metoden skal returnere true dersom to
	 *         SpaceObject-instanser (this og argumentet) overlapper. Sjekk for
	 *         overlapp kan gjøres på mange måter, f.eks. sjekke overlapp av
	 *         såkalt "bounding box" (minste omsluttende rektangel) eller om
	 *         midten og/eller hjørnene i det ene polygonet er inni det andre
	 *         (og vice versa), eller en kombinasjon av flere av disse.
	 *         contains-metoden BaseSpaceObject i er nyttig her. Enkle teknikker
	 *         vil dekke mange relevante tilfeller, men for å ta alle
	 *         hjørnetilfellene (wink) så må en være litt kløktig og kombinere
	 *         flere typer teknikker. Figuren til høyre viser fire polygoner som
	 *         har litt ulik type overlapp og tabellen bortenfor viser hvilke
	 *         som overlapper (fasit for testkoden).
	 * 
	 */
	public boolean intersects(SpaceObject other) {
		return this.intersects1(other) || other.intersects1(this);
	}
	
	private boolean intersects1(SpaceObject other) {
		for (int i = 0; i < other.getPointCount(); i++) {
			if (contains(other, i)) {
				return true;
			}
		}
		return contains(parentToLocal(other.getCenter(true)));
	}
	
	/**
	 * denne metoden kalles for hvert steg i simuleringen og skal justere alle
	 * dynamiske egenskaper iht. reglene for verdenen, f.eks. posisjon basert på
	 * farta.
	 */
	public void tick() {
		translate(speedX,speedY);//(speed.getX(), speed.getY());
	}
}
