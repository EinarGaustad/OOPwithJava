package oving8.asteroids;

import javafx.geometry.Point2D;

/***
 * 
 * @author GuoJunjun Denne oppgaven handler om simulering av objekter i rommet,
 *         hvor en bruker arv både til rom-objektene og til rom-verdenen.
 *         Simulering er en nyttig teknikk for å prøve ut ens forståelse av et
 *         fenomen, f.eks. fysikk. Enkelt sagt består en simulering av regler
 *         for hvordan objekter i en verden oppfører seg (både for seg selv og
 *         hvordan de spiller sammen), og en konkret verden i form av en
 *         start-konfigurasjon av objekter. Så tenker en seg at tiden går i små
 *         steg, og for hvert steg så oppdaterer en objektene i henhold til
 *         reglene.
 * 
 *         I denne øvingen består verdenen av objekter (asteroider og en sol)
 *         som svever fritt i rommet og et romskip med motorer som kan snurre og
 *         skyve. Alle objekter har en posisjon, fart og masse, og virker på
 *         hverandre i henhold til formelen for gravitasjon. Romskipet har i
 *         tillegg vinkelfart og mulighet for å fyre av motorer bak (dytter) og
 *         på siden (snurrer).
 */
public class LocalPolygon {
	
	// private static final double double ax = 0;
	
	protected Point2D	position;		// = new Point2D(0,0);
										
	protected double	rotate	= 0;
	
	public void setRotate(double rotate) {
		this.rotate = rotate;
	}
	
	public double getRotate() {
		return rotate;
	}
	
	public void setPosition(double x, double y) {
		this.position = new Point2D(x, y);
	}
	
	public Point2D getPosition() {
		return this.position;
	}
}
