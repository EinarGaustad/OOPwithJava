package oving8.traincar;

/***
 * 
 * @author junjun PassengerCar(int, int) - her tas inn hvor mye en tom vogn
 *         veier (som i TrainCar), og hvor mange passasjerer det er i vogna. int
 *         getPassengerCount() - returner antall passasjerer.
 *         setPassengerCount() - setter en ny verdi for antall passasjerer. For
 *         å beregne totalvekta, så kan du anta at en gjennomsnittspassasjer
 *         veier 80 kg.
 */
public class PassengerCar extends TrainCar {

	private int	passasjerer;

	PassengerCar(int veier, int passasjerer) {
		super(veier);
		this.passasjerer = passasjerer;
	}

	public int getPassengerCount() {
		return passasjerer;
	}

	public void setPassengerCount(int passasjerer) {
		this.passasjerer = passasjerer;
	}
	public int getTotalWeight() {
		return super.getTotalWeight()+passasjerer*80;
	}
}
