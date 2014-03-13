package oving2.UporDownCounter;

public class UpOrDownCounter {
	int start;
	int end;
	public UpOrDownCounter(int start, int end){
		setVerdi(start,end);
		//initialiserer objektet med angitte start- og slutt-verdier, 
		//hvor altså slutt kan være større eller mindre enn start, 
		//slik at telleren teller henholdsvis opp eller ned. 
		//Lik start og slutt-verdi skal utløse unntak av typen
		
	}
	public void setVerdi(int start, int end) throws
										IllegalArgumentException{
		if (!isValidVerdi(start,end)){
			throw new IllegalArgumentException(
					"to verdier kan ikke være lik"+start+"="+end);
		}
		this.start=start;
		this.end=end;
		
	}
	public boolean isValidVerdi(int a, int b){
		if ( a == b)
			return false;
		return true;
	}
	
	public int getCounter(){//returnerer telleren
		return start;
	}
	public boolean count(){
		//beveger telleren i retning av slutt-verdien og returnerer true
		//så lenge den ikke har nådd den, altså om telleren har mer igjen, 
		//og false ellers.
		if (start > end)
			//setVerdi(start-1, end);
			start=-1;
			
		else if (start < end)
			//setVerdi(start+1, end);
			start=+1;
		
		if (end!=start)
			return true;
		else
			return false;
	}
}
