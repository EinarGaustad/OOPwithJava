package exam2008sjakk;

/**
 * 
 * @author
 * 
 *         Det er uheldig å bruke String eller int, fordi en da ikke kan
 *         begrense verdiområdet vha. statisk typesjekking. Skal en da begrense
 *         hvilke instanser som kan være gyldige verdier, må en legge inn en
 *         dynamisk sjekk i koden. Det finnes flere alternative løsninger,
 *         dersom en ikke bruker enum:
 * 
 *         • Det beste er å innkapsle en Boolean i en PieceColor-klasse, og la
 *         false/true tilsvare white/black (eller omvendt). Dette vil fungere
 *         relativt bra siden en er garantert at det kun finnes to ulike
 *         Boolean-verdier. Det er mulig å bruke Boolean direkte, siden dette
 *         kan sees på som en boolean med to verdier. En får da ikke en ny
 *         klasse med navn PieceColor, og må definere getOtherColor som en
 *         hjelpemetode.
 * 
 *         • En kan også innkapsle en String eller int, men må da sørge for at
 *         det kun kan lages to ￼￼instanser, vha. riktig bruk av konstruktører
 *         og private-modifikatorer. Dette vil nesten ￼tilsvare en
 *         reimplementasjon Java sin egen enum-mekanisme.
 */
public enum V2PieceColor {
    WHITE, BLACK;
    
    /**
     * 
     * @return
     * 
     *         max = (a > b) ? a : b;
     * 
     *         (a > b) ? a : b; is an expression which returns one of two
     *         values, a or b. The condition, (a > b), is tested. If it is true
     *         the first value, a, is returned. If it is false, the second
     *         value, b, is returned. Whichever value is returned is dependent
     *         on the conditional test, a > b. The condition can be any
     *         expression which returns a boolean value.
     */
    public V2PieceColor getOtherColor() {
        return this == WHITE ? BLACK : WHITE;
    }
}
