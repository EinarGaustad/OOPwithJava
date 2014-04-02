package oving8.traincar;

/***
 * 
 * @author junjun I denne delen skal du lage to forskjellige typer togvogner som
 *         er spesialiserte for sitt bruk. Begge skal arve fra TrainCar.
 *         CargoCar extends TrainCar: Denne klassen skal gjenspeile en lastevogn
 *         som frakter diverse ting og tang. Følgende funksjonalitet trengs (se
 *         også diagrammet til høyre):
 * 
 *         CargoCar(int, int) - her tas inn hvor mye en tom vogn veier (som i
 *         TrainCar), og hvor mye vogna sin last veier. int getCargoWeight() -
 *         returnerer hvor mye lasten veier. setCargoWeight(int) - setter en ny
 *         verdi for vekten til lasten. PassengerCar extends TrainCar: Denne
 *         klassen gjenspeiler en passasjervogn. Legg til følgende metoder (se
 *         også diagrammet til høyre):
 */
public class CargoCar extends TrainCar {
	
	private int	lastVeier;

    public CargoCar(int veier, int lastVeier) {
		super(veier);
		this.lastVeier = lastVeier;
	}

	public int getCargoWeight() {
		return lastVeier;
	}

	public void setCargoWeight(int lastVeier) {
		this.lastVeier = lastVeier;
	}
	
	public int getTotalWeight() {
		return super.getTotalWeight()+lastVeier;
	}
}
