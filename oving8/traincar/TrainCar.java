package oving8.traincar;

/**
 * 
 * @author junjun I denne delen skal du lage en klasse kalt TrainCar for en
 *         enkel og generell togvogn, med følgende funksjonalitet (se også
 *         diagrammet til høyre):
 * 
 *         TrainCar(int) - en konstruktør som tar inn hvor mye en tom vogn
 *         veier. int getTotalWeight - returnerer vognas totale vekt. Merk at
 *         denne også skal kunne kalles på subklasser og fortsatt returnere
 *         totalvekta toil vogna (stikkord: redefinering). setDeadWeight(int) -
 *         setter hvor mye en tom vogn veier. Altså vekten til kun vognen, uten
 *         passasjerer eller last. int getDeadWeight() - returnerer hvor mye en
 *         tom vogn veier. Altså vekten til kun vognen, uten passasjerer eller
 *         last.
 */
public class TrainCar {
	protected int	veier;

	TrainCar(int veier) {
		this.veier = veier;
	}

	public int getTotalWeight() {
		return veier;
	}

	public void setDeadWeight(int veier) {
		this.veier = veier;
	}

	int getDeadWeight() {
		return veier;
	}
}
