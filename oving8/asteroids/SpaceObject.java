package oving8.asteroids;

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
	
	// protected double[] farten = new double[2];
	protected Point2D	point		= new Point2D();
	protected double[]	acclerate	= new double[2];
	protected double[]	force		= new double[2];
	protected double	mass		= 0;
	
	public Point2D getSpeed() {
		// ikke ferdig
		
		return null;// farten;
	}
	
	public void setSpeed(double vx, double vy) {
		point.setSpeed(vx, vy);
	}
	
	public void accelerate(double ax, double ay) {
		this.acclerate[0] = ax;
		this.acclerate[1] = ay;
	}
	
	public double getMass() {
		return mass;
	}
	
	public void applyForce(double fx, double fy) {
		if (mass == 0) {
			throw new IllegalStateException("mass er null!");
		} else {
			this.force[0] = fx;
			this.force[1] = fy;
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
	 *         De blå, grønne og røde polygonene overlapper, og her vil en
	 *         "bounding box"-test fungere. Men en slik test vil også gi
	 *         overlapp med den gule, og det stemmer jo ikke. En test for om
	 *         hjørnene til den ene er inni den andre (og vice versa), vil
	 *         fungere for de fleste, men ikke for den røde og grønne. En test
	 *         for om midt-punktet til den ene er inni den andre (og vice
	 *         versa), vil fungere for de fleste, men ikke for den grønne og
	 *         gule. Det som altså fungerer best er en kombinasjon av alle disse
	 *         teknikkene!
	 */
	public boolean intersects(SpaceObject other) {
		// if (){//ikke ferdig
		// return true;
		// }
		return false;
	}
	
	/**
	 * denne metoden kalles for hvert steg i simuleringen og skal justere alle
	 * dynamiske egenskaper iht. reglene for verdenen, f.eks. posisjon basert på
	 * farta.
	 */
	public void tick() {
		// ikke ferdig
	}
}
