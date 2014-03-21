package oving8.asteroids;

import javafx.scene.paint.Color;

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
	
	private double	angleSpeed;
	
//	public SpaceShip() {
//		angleSpeed = 0;
//	}
	public SpaceShip() {
		addPoints(
			10.0d, 0.0d,
			-10.0d, 7.0d, 
			-10.0d, -7.0d
		);
		setFill(Color.GREEN);
		angleSpeed = 0.0;
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
		this.angleSpeed += thrust;
		// double rotate = getRotate();
		// if (rotate == 0) {
		// setRotate(thrust);
		// } else if ((rotate > 0 && thrust > 0) || (rotate < 0 && thrust < 0))
		// {
		// setRotate(rotate + thrust);
		// } else if ((rotate > 0 && thrust < 0) || (rotate < 0 && thrust > 0))
		// {
		// setRotate(thrust);
		// }
	}
	
	/***
	 * 
	 * @param thrust
	 *            øker farta tilsvarende i retningen romskipet peker.
	 */
	public void forwardThrust(double thrust) {
		double angle = Math.toRadians(getRotate());
		accelerate(thrust * Math.cos(angle), thrust * Math.sin(angle));
		// // double[] tabel = speed.getSpeed();
		// double vx = speed.getX();// tabel[0];
		// double vy = speed.getY();// tabel[1];
		// double nvx = 0;
		// double nvy = 0;
		// double hypotenuse = Math.sqrt(vx * vx + vy * vy);
		// nvx = (vx / hypotenuse) * (hypotenuse + thrust);
		// nvy = (vy / hypotenuse) * (hypotenuse + thrust);
		// setSpeed(nvx, nvy);
	}
	
	@Override
	public void tick() {
		super.tick();
		setRotate(getRotate() - angleSpeed);
	}
}
