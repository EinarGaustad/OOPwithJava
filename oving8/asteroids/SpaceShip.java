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
	
	protected double	angleSpeed;
	
	public SpaceShip() {
		angleSpeed = 0;
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
		double rotate = getRotate();
		if (rotate == 0) {
			setRotate(thrust);
		} else if ((rotate > 0 && thrust > 0) || (rotate < 0 && thrust < 0)) {
			setRotate(rotate + thrust);
		} else if ((rotate > 0 && thrust < 0) || (rotate < 0 && thrust > 0)) {
			setRotate(thrust);
		}
	}
	
	/***
	 * 
	 * @param thrust
	 *            øker farta tilsvarende i retningen romskipet peker.
	 */
	public void forwardThrust(double thrust) {
//		double[] tabel = speed.getSpeed();
		double vx = speed.getX();//tabel[0];
		double vy = speed.getY();//tabel[1];
		double nvx = 0;
		double nvy = 0;
		double hypotenuse = Math.sqrt(vx * vx + vy * vy);
		nvx = (vx / hypotenuse) * (hypotenuse + thrust);
		nvy = (vy / hypotenuse) * (hypotenuse + thrust);
		setSpeed(nvx, nvy);
	}
}
