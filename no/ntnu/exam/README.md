Java Collection
=
Java collections overview
-
En collection er et objekt som representerer en gruppe objekter. Dette brukes mye i programmeringssammenheng, og for å forenkle representasjonen og manipulering av slike objekter har Java-plattformen et eget rammeverk med nyttige strukturer og optimaliserte algoritmer. Foruten å sette en standard, sparer også collection-rammeverket deg for en stor mengde implementasjon som ville tatt masse tid å programmere hver gang du trengte det.

Basen til rammeverket er fjorten grensesnitt som representerer ulike typer collections som sets, lists og maps.
På Oracle sine sider finner man denne tabellen, som oppsummerer implementasjonene av de ulike grensesnittene ganske oversiktelig:

![collection Overview](junjunguo.github.io/image/java/collectionsoverview.jpg)

*Kort om grensesnittene
1. Set
Et set er en collection som ikke kan inneholde duplikate elementer. Grensesnittet representerer den matematiske definisjonen av en mengde, og brukes for eksempel til å holde kortene som utgjør en pokerhånd eller prosessene som kjører på en datamaskin. Man kan utføre en rekke mengde-operasjoner på et set. Disse og mer om set-grensesnittet finner du her.

2. List
En list er en ordnet (ikke det samme som sortert) collection som kan inneholde duplikate elementer. Når man bruker lister har man ofte kontroll over hvor i listen hvert element blir satt inn og kan aksessere elementene ved hjelp av indeksposisjonene deres. Mer om list-grensesnittet her.

3. Queue
En queue er en collection som brukes til å holde flere elementer i prioritert rekkefølge med hensyn til prosessering. For utenom basis collection-operasjoner støtter en kø ekstra innsetting, utplukking og inspeksjons-operasjoner.
Køer ordner vanligvis, men ikke nødvendigvis, elementene etter et FIFO (first-in, first-out) system. Andre eksempler er køer hvor elementene ordnes etter en gitt sammenlignbar verdi, eller elementenes naturlige ordning.
Uansett hvordan køen organiseres vil elementet først i køen fjernes dersom man kaller remove eller poll . Mer om queue her.

4. Deque
En deque fungerer på samme måte som som en queue, men i tillegg kan vi legge til, fjerne og se nærmere på elementer i begge ender av køen (double-ended queue). Dette gjør en deque både kan brukes med et FIFO og et LIFO (Last-in, First-out) system. Mer her.

5. Map
Et map er et objekt som mapper nøkler til verdier. Et map kan ikke inneholde duplikate nøkler, og hver nøkkel kan bare mappe til en verdi. Dersom man har brukt en Hashtabell kjenner man til konseptene bak et map.
Maps er ikke en ordnet collection, men ved hjelp av nøkkelen kan man gjøre oppslag i konstant tid.


Collection detail:

![collection detail](junjunguo.github.io/image/java/Collections-detail.png)


UML collection implementation:


![collection detail](junjunguo.github.io/image/java/collection_implementation.jpg)
