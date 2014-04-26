package exam2008sjakk;

/**
 * 
 * @author
 * 
 *         Det vanlige er å lage en valideringsmetode for posisjoner, som
 *         bruker throw new IllegalBoardPosition(position) for å si fra om
 *         unntaket. Denne kalles enten direkte eller indirekte fra alle metoder
 *         som har posisjonsparametre, f.eks. getPiece og setPiece. Her har vi
 *         valgt å definere en såkalt unchecked exception, fordi dette er feil
 *         som kan oppstå overalt og som kan unngås i koden som kaller vår,
 *         og som ikke skyldes eksterne faktorer vi ikke har kontroll med. Det
 *         riktigste hadde forøvrig vært å subklasse IllegalArgumentException,
 *         men denne er det ikke sikkert alle husker. I vurderingen er vi ikke
 *         så nøye med om posisjonen lagres, men en bør sørge for at getMessage
 *         returnerer noe fornuftig, enten ved å kalle superklassens
 *         konstruktør, eller ved å definere en egen toString eller
 *         getMessage-metode.
 * 
 */
@SuppressWarnings("serial")
public class IllegalBoardPositionException extends RuntimeException {
    
    private String position;
    
    public IllegalBoardPositionException(String position) {
        super(position + " is an illegal chess board position");
        this.position = position;
    }
    
    public String getPosition() {
        return position;
    }
}
