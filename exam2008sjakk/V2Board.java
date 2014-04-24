package exam2008sjakk;

/**
 * 
 * @author
 * 
 *         Løsningen inneholder 3 vesentlige elementer:
 * 
 *         1) deklarasjonen av riktig tabelltype og riktig bruk av indekser,
 * 
 *         2) omregning til indeks vha. char-aritmetikk og
 * 
 *         3) riktig bruk private- og public-modifikatorer. Det er mulig, men
 *         ikke like bra, å bruke en én-dimensjonal tabell, så lenge den
 *         kapsles inn riktig. Det er også greit å klare seg uten
 *         hjelpemetoder, men det teller positivt dersom det ville gjort koden
 *         for øvrig enklere.
 * 
 */
public class V2Board {
    
    private V2Piece[][] pieces;
    
    private static int getColumnIndex(String position) {
        return position.charAt(0) - 'a';
    }
    
    private static int getRowIndex(String position) {
        return position.charAt(1) - '1';
    }
    
    public V2Piece getPiece(String position) {
        return getPiece(getColumnIndex(position), getRowIndex(position));
    }
    
    public V2Piece getPiece(int column, int row) {
        return pieces[row][column];
    }
    
    public void setPiece(String position, V2Piece piece) {
        pieces[getRowIndex(position)][getColumnIndex(position)] = piece;
    }
    
    /**
     * Her er det et poeng å skjønne hvordan indeksene kan brukes til å
     * avgjøre om flyttet er rett eller diagonalt. I løsningen har jeg definert
     * to hjelpemetoder som er nyttige i andre metoder. isOccupiedBetween er
     * litt fiklete å få til rett, men poenget er å lage en generell løkke
     * hvor inkrementet er regnet ut på bakgrunn av differansene. En må da
     * bruke variabler, += og == i løkka, siden en ikke ved hvilken retning
     * (oppover eller nedover) løkkevariabelen beveger seg. I oppgaveteksten var
     * det forøvrig ikke sagt at isOccupiedBetween bare skulle håndtere flytt
     * som var rette eller diagonale, men ut fra reglene skulle det gå frem at
     * den kun var relevant i dette tilfellet (og altså ikke for hesten).
     */
    public static boolean isStraight(String from, String to) {
        return getColumnDistance(from, to) == 0
                || getRowDistance(from, to) == 0;
    }
    
    public static boolean isDiagonal(String from, String to) {
        return getColumnDistance(from, to) == getRowDistance(from, to);
    }
    
    public boolean isOccupiedBetween(String from, String to) {
        int fromColumn = V2Board.getColumnIndex(from), fromRow = V2Board
                .getRowIndex(from);
        int toColumn = V2Board.getColumnIndex(to), toRow = V2Board
                .getRowIndex(to);
        int dColumn = (fromColumn == toColumn ? 0 : (toColumn - fromColumn)
                / Math.abs(toColumn - fromColumn));
        int dRow = (fromRow == toRow ? 0 : (toRow - fromRow)
                / Math.abs((toRow - fromRow)));
        for (int column = fromColumn + dColumn, row = fromRow + dRow; column != toColumn
                || row != toRow; column += dColumn, row += dRow) {
            if (getPiece(column, row) != null) {
                return true;
            }
        }
        return false;
    }
    
    private static int getRowDistance(String from, String to) {
        return Math.abs(from.charAt(0) - to.charAt(0));
    }
    
    private static int getColumnDistance(String from, String to) {
        return Math.abs(from.charAt(1) - to.charAt(1));
    }
}
