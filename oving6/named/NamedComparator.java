package oving6.named;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {
	
	public int compare(Named named1, Named named2) {
		int diff = named1.getFamilyName().compareTo(named2.getFamilyName());
		if (diff == 0) {
			diff = named1.getGivenName().compareTo(named2.getGivenName());
		}
		return diff;
		
		// //Dersom etternavnene er ulike skal metoden
		// if (named1.getFamilyName() != named2.getFamilyName()){
		// int compare =
		// named1.getFamilyName().compareTo(named2.getFamilyName());
		// if ( compare > 0){//returnere et negativt heltall om det første
		// etternavnet er alfabetisk ordnet før det andre,
		// return -1;
		// }
		// else{//eller et positivt heltall i motsatt tilfelle
		// return 1;
		// }
		// }
		// else {//Dersom etternavnene er like skal metoden gjøre det samme på
		// fornavnene
		// if (named1.getGivenName() != named2.getGivenName()){
		// if (named1.getGivenName().compareTo(named2.getGivenName()) > 0){
		// return -1;
		// }
		// if (named1.getGivenName().compareTo(named2.getGivenName()) < 0){
		// return 1;
		// }
		// }
		// }
		// return 0;//Dersom også fornavnene er like skal metoden returnere 0
	}
}
