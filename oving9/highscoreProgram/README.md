Skip to content
Skip to breadcrumbs
Skip to header menu
Skip to action menu
Skip to quick search
Quick Search
Browse
Junjun Guo
0
Dashboard
 
Objektorientert programmering med Java
 
…
 
Observatør-observert-teknikken - HighscoreList-oppgave
Share
Add
Tools
 Observatør-observert-teknikken - HighscoreList-oppgave
Skip to end of metadata
Added by Håvard Hammer Normann, last edited by Hallvard Trætteberg on 21.03.2014  (view change) Go to start of metadata
Denne oppgaven handler om å bruke observatør-observert-teknikken for å bli informert om endringer i en highscore-liste. Vi bruker også arv for å skille ut gjenbrukbar kode for en generell, observerbar liste.
Observatør-observert-teknikken går ut på at det observerte objektet sier ifra til en eller flere observatører om at tilstanden er endret. I denne oppgaven skal vi lage en HighscoreList som kan si fra til lyttere av typen ListListener når nye resultater blir registrert. En hovedprogramklasse kalt HighscoreProgram vil bli brukt til å sjekke at det virker. Denne klassen oppretter en HighscoreList-instans, legger inn resultater (tall) fra konsollet som legges til lista og skriver ut lista hver gang et nytt resultat faktisk blir lagt til.

Del 1: Implementasjon av HighscoreList

Klassediagram for HighscoreList, ListListener og ObservableList.
En HighscoreList skal holde styr på heltallsresultater (av typen int/Integer). Lista skal være observerbar ved at den kan registrere lyttere (ListListener-instanser) og si fra til dem når lista blir endret. Lista skal ha en maksimal lengde, som settes i konstruktøren, f.eks. skal en topp 10-liste kunne opprettes med new HighscoreList(10). Nye resultater registreres med metoden addResult(int), som skal finne riktig posisjon og legge resultatet inn (dersom det er godt nok). Dersom lista er for lang, så skal det dårligste resultatet fjernes. NB: Lavest verdi er best, f.eks. antall sekunder på en oppgave eller antall flytt i Sokoban.

ListListener-grensesnittet er vist i klassediagrammet til venstre og må implementers av alle klasser som ønsker å fungere som lyttere for HighscoreList-instanser. Lyttere registrerer seg med HighscoreList sin addListListener-metode og vil siden få beskjed om nye resultater ved at listChanged-metoden kalles. Argumentene som tas inn er HighscoreList-objektet som ble endret og posisjonen i lista der endringen skjedde.

Merk at første argument til listChanged-metoden er av typen ObservableList. Dette er en abstrakt superklasse for HighscoreList, som først brukes i del 3 og som da skal holde orden på lista. ObservableList vil ha en del generelle metoder som HighscoreList arver og kan bruke. For å kunne kjøre testene for HighscoreList allerede i del 1, så må ObservableList være definert fra starten. Lag derfor en tom ObservableList-klasse og bruk denne som superklasse for HighscoreList.

Her er en oversikt over metoden som må implementeres:

HighscoreList(int maxSize) - konstruktøren tar inn maks antall resultater som lista skal kunne holde. Denne verdien må brukes av addResult, slik at resultater som er for dårlige kastes.
size() - returnerer antall elementer i lista, som altså aldri skal overstige maks-antallet
int getElement(int) - returnerer resultatet i posisjonen angitt av argumentet
void addResult(int) - registrere et nytt resultat, og dersom resultatet er godt nok til å komme med på lista, så legges det inn på riktig plass. Dersom lista blir for lang, så må dårligste resultat kastes. Alle registrerte lyttere må få beskjed om en evt. endring av lista, inkludert på hvilken posisjon som ble endret.
addListListener(ListListener) - registrerer en ny lytter
removeListListener(ListListener) - fjerner en tidligere registrert lytter
JExercise-testkode for denne oppgaven finner du her: patterns/observable/HighscoreListTest.java. Original-koden (jextest) finner du her: patterns/observable/HighscoreList.jextest.

Del 2: Hovedprogram HighscoreProgram

Klassediagrammet viser hvordan klassene henger sammen, og vårt forslag til metoder.
Lag en hovedprogramklasse kalt HighscoreProgram, som tester at HighscoreList-klassen din virker som den skal. La den opprette en HighscoreList-instans, lese inn tall fra konsollet (f.eks. med en Scanner og nextInt-metoden) og legge disse inn i lista. Sørg for at HighscoreProgram implementerer ListListener-grensesnittet og registrerer seg som lytter på HighscoreList-instansen. La lyttermetoden listChanged skrive ut informasjon og resultatene i HighscoreList-instansen og posisjonsargumentet, slik at du ser at alt virker som det skal.

Vi foreslår følgende metoder og oppførsel:

void init() - oppretter en ny HighscoreList og registrerer seg selv (altså HighscoreProgram-instansen) som lytter
void run() - leser inn tall (resultater) fra konsollet og legger dem til i listen
void listChanged(ObservableList, int) - observerer endringer i HighscoreList-instansen og skriver ut posisjonsargumentet, samt selve listen, til konsollet
 
Del 3: ObservableList

Klassediagrammet viser hvordan klassene henger sammen, og hvor metodene nå er deklarert/implementert. Merk at addElement- og removeElement-metodene er angitt som protected (ruter-symbolet), slik at kun subklasser skal kunne bruke dem.
Den abstrakte superklassen ObservableList skal legges til som en generell superklasse for observerbare lister, som HighscoreList skal arve fra. Denne klassen skal både holde en liste med objekter (Object) og håndtere registrering av lyttere, altså en liste med ListListener-instanse, som får beskjed om endringer i lista (slik at lista dermed er observerbar). Dette betyr at ObservableList overtar håndtering av både resultater og lyttere fra HighscoreList-klassen. For å gjøre ObservableList mer generell og gjenbrukbar, så lar vi den håndtere Object-instanser (heller enn Integer). Samtidig deklarerer den en abstrakt metode acceptsElement, som subklasser må redefinere for å bestemme hva slags objekter det skal være lov å legge inn. HighscoreList vil f.eks måtte redefinere den slik at bare Integer-objekter aksepteres.

ObservableList skal ha følgende metoder (noen er altså overtatt fra HighscoreList):

int size() - returnerer antall elementer i lista
Object getElement(int) - returnerer elementet i posisjonen angitt av argumentet
abstract boolean acceptsElement(Object) - returnerer hvorvidt subklassen aksepterer at objektet legges inn i lista (f.eks. aksepterer HighscoreList kun Integer-objekter).
void addElement(int, Object) - legger til et element på posisjonen angitt av argumentet, men bare dersom det aksepteres som element. Dersom elementet ikke aksepteres, så skal IllegalArgumentException utløses. Dersom posisjonen er ulovlig så skal IndexOutOfBoundsException utløses.
void addElement(Object) - legger til et element bakerst i lista, men bare dersom det aksepteres som element. Dersom elementet ikke aksepteres, så skal IllegalArgumentException utløses.
void removeElement(int) - fjerner elementet på posisjonen angitt av argumentet. Dersom posisjonen er ulovlig så skal IndexOutOfBoundsException utløses.
HighscoreList skal endres slik at den i størst mulig grad bruker metodene som arves fra ObservableList, men forøvrig ikke endrer oppførsel. Kjør hovedprogramklassen HighscoreProgram for å sjekke at dette faktisk stemmer.

 
JExercise-testkode for denne oppgaven finner du her: patterns/observable/ObservableListTest.java. Original-koden (jextest) finner du her: patterns/observable/ObservableList.jextest.

Ekstraoppgave
Implementer en HighscoreList som håndterer resultater for TicTacToe, Sokoban eller Sudoku. Etter hvert ferdige spill skal spilleren få mulighet til å legge inn resultatene i en highscore-liste, som består av navn på spilleren og antall trekk. Hvert resultat lagres som et eget objekt, og denne resultatobjektklassen må implementere Comparable-grensesnitt. Resultatene legges inn i highscore-listen, som printes etter at spilleren har fått mulighet til å registrere sitt resultat.

 


JExercise lar deg sjekke din egen kode vha. forhåndslagde JUnit-tester og JExercise-panelet. 

Twitre gjerne om oppgaven når du er ferdig: 
 

Sidetype
Dekningsgrad
Omfang
Ferdig
oppgave
75
75
95
LikeBe the first to like this	Labels	
sidetype-oppgave Edit Labels
User icon: Add a picture of yourself
Write a comment…

Powered by Atlassian Confluence 4.3.7, the Enterprise Wiki  ·  Report a bug  ·  Atlassian News
