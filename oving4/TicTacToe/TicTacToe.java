package oving4.TicTacToe;
/*
I spillet Tripp-trapp-tresko skal to spillere legge hver sine brikker i et rutenett
 på 3x3 ruter og prøve å få tre på rad før brettet er fullt. 
 Oppgaven fokuserer på å realisere dette ved bruk av to klasser, 
 med en tydelig rollefordering: 
 
 TicTacToe-klassen håndterer selve brettet og hvem 
 sin tur det er, mens 
 
 TicTacToeProgram-klassen håndterer tekst-basert interaksjon 
 med spillerne gjennom konsollet. 
 
 Denne tydelige oppdelingen i logikk og interaksjon
 (også kalt brukergrensesnitt) vil gjøre det lettere å senere lage et grafisk 
 brukergrensesnitt uten å måtte programmere alt på nytt, 
 siden logikk-klassen vil kunne gjenbrukes. 
 For å gjøre klassene noenlunde uavhengig av hverandre brukes prinsippet om 
 Innkapsling.
 */

/*
Oppgaven er åpen i den forstand at den ikke spesifiserer akkurat hvilke metoder 
hver klasse skal ha, men sier noe om hvordan det skal ta seg ut for brukeren. 
Dette gjør det vanskeligere å teste enkeltmetoder, så istedenfor testes teksten 
som kommer ut, basert på hva brukeren (eller testprogrammet) gir inn.
 */

/*
Det er ofte lurt å løse slike oppgaver i mindre trinn, og derfor har vi nedenfor 
spesifisert hvilke funksjoner vi tror er lurt å lage i hvert trinn.

Trinn 1 - kunne vise frem brettet med og uten brikker. I dette trinnet lager du 
TicTacToe-klassen med en toString()-metode som viser brettet med de brikkene 
som er satt (f.eks. av et enkelt test-hovedprogram du lager selv). 
TicTacToe-klassen skal være ordentlig innkapslet.
 */

/*
Trinn 3 - et helt fungerende spill, hvor TicTacToe-klassen kan si fra til 
TicTacToeProgram-klassen hvilken spiller som har turen, om spillet er ferdig og 
hvilken spiller som evt. har vunnet.
 */
public class TicTacToe {
	//tenker:
	//1. database: lage en to dimensjonal array [2][2]
	//2. lager metoder:
	//2.1	setInn()
	//2.2	skrive ut: toString()
	//2.3	hvim har turen truen()
	//2.4	hvim vinne vinne()
	//2.5	kjekk inndata må være lovlig
	
	private char [] [] tabel = { //new char [2][2];
			{' ',' ',' '},
			{' ',' ',' '},
			{' ',' ',' '},
	};
	private int sumere=0;
	/*
	public TicTacToe(){
		for (int i=0; i<=2;i++){
			for (int j=0; j<=2; j++){
				tabel[i][j]='_';
			}
		}
	}
	*/
	public char turen(){// kunne dele med to en øke sumere en ruren
		sumere++;
		if (sumere%2 == 0){
			return 'O';
		}		
		return 'X';
	}
	public void setInn(int x, int y){
		if(sumere%2==0){
			tabel[x][y] = 'O';
		}
		else
			tabel[x][y] = 'X';
	}
	public boolean isValid(String s){
		if (s.length()!=2){
			return false;
		}
		char x = s.charAt(0);
		char y = s.charAt(1);
		if ((x=='0' || x=='1' || x=='2')&&(y=='0'||y=='1'||y=='2')){
			if (tabel[Integer.parseInt(""+x)][Integer.parseInt(""+y)]==' '){
				return true;
			}
		}
		return false;
	}
	public String toString(){//minst mulig....
		if (vinne()!=' '){
			return "spileren : "+vinne()+" vinne!"+"\n"
					+tabel[0][0]+" | "+tabel[0][1]+" | "+tabel[0][2]+"\n"
					+tabel[1][0]+" | "+tabel[1][1]+" | "+tabel[1][2]+"\n"
					+tabel[2][0]+" | "+tabel[2][1]+" | "+tabel[2][2];
		}
		if (sumere==9){
			return "ingen vinne!"+"\n"
					+tabel[0][0]+" | "+tabel[0][1]+" | "+tabel[0][2]+"\n"
					+tabel[1][0]+" | "+tabel[1][1]+" | "+tabel[1][2]+"\n"
					+tabel[2][0]+" | "+tabel[2][1]+" | "+tabel[2][2];
		}
		return "spileren : "+turen()+"\n"
				+tabel[0][0]+" | "+tabel[0][1]+" | "+tabel[0][2]+"\n"
				+tabel[1][0]+" | "+tabel[1][1]+" | "+tabel[1][2]+"\n"
				+tabel[2][0]+" | "+tabel[2][1]+" | "+tabel[2][2];
	}
	public char vinne(){
		if (tabel[0][0]==tabel[0][1] && tabel[0][1]==tabel[0][2]){
			return tabel[0][0];
		}
		if (tabel[1][0]==tabel[1][1] && tabel[1][1]==tabel[1][2]){
			return tabel[1][0];
		}
		if (tabel[2][0]==tabel[2][1] && tabel[2][1]==tabel[2][2]){
			return tabel[2][0];
		}
		
		if (tabel[0][0]==tabel[1][0] && tabel[1][0]==tabel[2][0]){
			return tabel[0][0];
		}
		if (tabel[0][1]==tabel[1][1] && tabel[1][1]==tabel[2][1]){
			return tabel[0][1];
		}
		if (tabel[0][2]==tabel[1][2] && tabel[1][2]==tabel[2][2]){
			return tabel[0][2];
		}
		
		if (tabel[0][0]==tabel[1][1] && tabel[1][1]==tabel[2][2]){
			return tabel[0][0];
		}
		if (tabel[0][2]==tabel[1][1] && tabel[1][1]==tabel[2][0]){
			return tabel[0][2];
		}
		return ' ';
	}
	public int getSumere(){
		return sumere;
	}
	
}
