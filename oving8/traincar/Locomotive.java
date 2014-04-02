package oving8.traincar;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * 
 * @author junjun Klassen Locomotive skal forestille et lokomotiv som har et
 *         sett med vogner knyttet til seg. Klassen skal ha følgende metoder (se
 *         også diagrammet til høyre):
 * 
 *         addTrainCar(TrainCar) - denne metoden skal ta inn en togvogn og
 *         knytte den til dette lokomotivet. boolean contains(TrainCar) -
 *         Sjekker om lokomotivet har TrainCar-argument knyttet til seg.
 * 
 *         int getTotalWeight() - returner alle vognene sin totale vekt. Vi tar
 *         ikke høyde for lokomotivet sin eventuelle vekt.
 * 
 *         int getPassengerCount() - tilsvarende PassengerCar sin metode, men
 *         returnerer antallet for alle vognene.
 * 
 *         int getCargoWeight() - tilsvarende CargoCar sin metode, men
 *         returnerer lastevekten for alle vognene.
 * 
 *         String toString() - Redefiner Locomotive sin toString-metode. Den
 *         skal sette sammen en String med oversikt over alle vognene som er
 *         knyttet til den. For hver vogn skal vogntype og totalvekt være med.
 *         Passasjervogner skal i tillegg ha med antall passasjerer og
 *         lastevogner skal ha med hvor mye lasten veier.
 * 
 *         notes: In Java, method calls are always determined by the type of the
 *         actual object, not the type of the variable containing the object
 *         reference. This is called dynamic method lookup. Dynamic method
 *         lookup allows us to treat objects of different classes in a uniform
 *         way. This feature is called polymorphism. We ask multiple objects to
 *         carry out a task, and each object does so in its own way.
 *         Polymorphism makes programs easily extensible.<big java:438>
 */
public class Locomotive {

    private ArrayList<TrainCar> locomotive = new ArrayList<TrainCar>();

	public void addTrainCar(TrainCar traincar) {
		locomotive.add(traincar);
	}

	public boolean contains(TrainCar traincar) {
		return locomotive.contains(traincar);
	}

	public int getTotalWeight() {
		Iterator<TrainCar> iterator = locomotive.iterator();
		int pcweight = 0;
		int tcweight = 0;
		int ccweight = 0;
		int indexNr = 0;
		PassengerCar pc = null;
		TrainCar tc = null;
		CargoCar cc = null;
		while (iterator.hasNext()) {
			Object ob = iterator.next();
			//System.out.println(((Locomotive) ob).getTotalWeight());
			if ( ob instanceof PassengerCar) {
				pc = (PassengerCar) locomotive.get(indexNr);
				pcweight += pc.getTotalWeight();
			}
			if ( ob instanceof CargoCar) {
				cc = (CargoCar) locomotive.get(indexNr);
				ccweight += cc.getTotalWeight();
			}
			else if (!(ob instanceof PassengerCar) && !(ob instanceof CargoCar)) {
				tc = (TrainCar) locomotive.get(indexNr);
				tcweight += tc.getTotalWeight();
			}
			indexNr++;
		}
		return ccweight + pcweight + tcweight;//+getPassengerCount()*80;
	}

	public int getPassengerCount() {
		Iterator<TrainCar> iterator = locomotive.iterator();
		int passengercar = 0;
		int indexofpassengercar = 0;
		PassengerCar pc = null;
		while (iterator.hasNext()) {
			if (iterator.next() instanceof PassengerCar) {
				pc = (PassengerCar) locomotive.get(indexofpassengercar);
				passengercar += pc.getPassengerCount();
			}
			indexofpassengercar++;
		}
		return passengercar;
	}

	public int getCargoWeight() {
		Iterator<TrainCar> iterator = locomotive.iterator();
		int cargoweight = 0;
		int indexofcargo = 0;
		CargoCar cc = null;
		while (iterator.hasNext()) {
			if (iterator.next() instanceof CargoCar) {
				cc = (CargoCar) locomotive.get(indexofcargo);
				cargoweight += cc.getCargoWeight();
			}
			indexofcargo++;
		}
		return cargoweight ;
	}

	public String toString() {
		return "antall vogene: " + locomotive.size() + "CargoCar totalvekt: "
				+ getCargoWeight() + "Passenger Count: " + getPassengerCount();
	}
}