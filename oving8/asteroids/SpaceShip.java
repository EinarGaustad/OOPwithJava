package oving8.asteroids;

/***
 * 
 * @author GuoJunjun SpaceShip
 * 
 *         SpaceShip() - initialiserer vinkelfarta til 0.
 * 
 *         double getMass() - massen er alltid 1.
 * 
 *         sidewaysThrust(double thrust) - endrer vinkelfarta tilsvarende.
 *         Positiv verdi gir fart mot urvisere. (Hint: bruk
 *         get/setRotate-metodene i Polygon).
 * 
 *         forwardThrust(double thrust) - øker farta tilsvarende i retningen
 *         romskipet peker.
 */

public class SpaceShip extends SpaceObject {
	
	protected double	vinkelfarta;
	
	public SpaceShip() {
		vinkelfarta = 0;
	}
	
	public double getMass() {
		// massen er alltid 1;
		return 1;
	}
	
	/***
	 * 
	 * @param thrust
	 *            sidewaysThrust(double thrust) - endrer vinkelfarta
	 *            tilsvarende. Positiv verdi gir fart mot urvisere. (Hint: bruk
	 *            get/setRotate-metodene i Polygon).
	 */
	public void sidewaysThrust(double thrust) {
		// ikke ferdig
	}
	
	/***
	 * 
	 * @param thrust
	 *            øker farta tilsvarende i retningen romskipet peker.
	 */
	public void forwardThrust(double thrust) {
		//IKKE ferdig 
	}
}
