package chess2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
    
    private V2Piece[][]    pieces;
    public V2BoardIterator iterator;
    
    public V2Board() {
        iterator = new V2BoardIterator();
        init();
    }
    
    // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
    // 8 ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜ 8
    // 7 ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟ 7
    // 6 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 6
    // 5 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 5
    // 4 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 4
    // 3 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 3
    // 2 ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙ 2
    // 1 ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖ 1
    // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
    private void init() {
        pieces = new V2Piece[8][8];
        // set row 3,4,5,6 to null
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }
        }
        for (int i = 0; i < 8; i++) {
            pieces[1][i] = (V2Piece) new V2Pawn(V2PieceColor.WHITE);
            pieces[6][i] = (V2Piece) new V2Pawn(V2PieceColor.BLACK);
        }
        
        pieces[0][0] = (V2Piece) new V2Rook(V2PieceColor.WHITE);
        pieces[0][1] = (V2Piece) new V2Knight(V2PieceColor.WHITE);
        pieces[0][2] = (V2Piece) new V2Bishop(V2PieceColor.WHITE);
        pieces[0][3] = (V2Piece) new V2Queen(V2PieceColor.WHITE);
        pieces[0][4] = (V2Piece) new V2King(V2PieceColor.WHITE);
        pieces[0][5] = (V2Piece) new V2Bishop(V2PieceColor.WHITE);
        pieces[0][6] = (V2Piece) new V2Knight(V2PieceColor.WHITE);
        pieces[0][7] = (V2Piece) new V2Rook(V2PieceColor.WHITE);
        
        pieces[7][0] = (V2Piece) new V2Rook(V2PieceColor.BLACK);
        pieces[7][1] = (V2Piece) new V2Knight(V2PieceColor.BLACK);
        pieces[7][2] = (V2Piece) new V2Bishop(V2PieceColor.BLACK);
        pieces[7][3] = (V2Piece) new V2Queen(V2PieceColor.BLACK);
        pieces[7][4] = (V2Piece) new V2King(V2PieceColor.BLACK);
        pieces[7][5] = (V2Piece) new V2Bishop(V2PieceColor.BLACK);
        pieces[7][6] = (V2Piece) new V2Knight(V2PieceColor.BLACK);
        pieces[7][7] = (V2Piece) new V2Rook(V2PieceColor.BLACK);
    }
    
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
    
    /**
     * 
     * @param from
     * @param to
     * @return Static-modifikatoren angir at metoden ikke utføres i kontekst av
     *         en (implisitt) instans, og følgelig ikke har tilgang til annet
     *         enn andre static-metoder og static-felt.
     * 
     *         Det er greit å markere at en metode ikke bruker instansdata ved
     *         å bruke static-modifikatoren.
     * 
     *         Merk at dette gjelder isStraight og isDiagonal, men ikke
     *         isOccupiedBetween, siden de første kun trenger parametrene for å
     *         klassifisere flyttet, mens sistnevnte trenger å sjekke brikkene
     *         som er på brettet.
     */
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
    
    public static int getRowDistance(String from, String to) {
        return Math.abs(from.charAt(0) - to.charAt(0));
    }
    
    public static int getColumnDistance(String from, String to) {
        return Math.abs(from.charAt(1) - to.charAt(1));
    }
    
    public boolean isLegalMove(V2PieceColor pieceColor, String from, String to) {
        try {
            validateBoardPosition(from);
            validateBoardPosition(to);
        } catch (IllegalBoardPositionException e) {
            return false;
        }
        V2Piece piece = getPiece(from), otherPiece = getPiece(to);
        if (piece == null || piece.getPieceColor() != pieceColor) {
            return false;
        }
        return (otherPiece != null & otherPiece.getPieceColor() != pieceColor) ? piece
                .canTake(from, to, this) : otherPiece == null
                & piece.canMove(from, to, this);
    }
    
    public static void main(String[] args) {
        V2Board board = new V2Board();
        V2PieceColor pieceColor = V2PieceColor.WHITE;
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        do {
            System.out.println(pieceColor + " 's turn: ");
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                break;
            }
            String[] fromTo = line.split("-");
            if (fromTo.length != 2) {
                System.out.println("Illegal syntax ...");
                continue;
            }
            String from = fromTo[0].trim(), to = fromTo[1].trim();
            if (!board.isLegalMove(pieceColor, from, to)) {
                System.out.println("Liiegal move!");
                continue;
            }
            board.movePiece(from, to);
            pieceColor = pieceColor.getOtherColor();
            for (V2PieceColor kingColor : V2PieceColor.values()) {
                if (board.isCheck(kingColor)) {
                    System.out.println("the " + kingColor + " king is check!");
                }
            }
        } while (board.findKing(V2PieceColor.WHITE) != null
                & board.findKing(V2PieceColor.BLACK) != null);
    }
    
    public boolean isCheck(V2PieceColor color) {
        String posK = findKing(color);
        for (String pos : V2BoardIterator.computePositions()) {
            if (getPiece(pos) != null
                    & getPiece(pos).getPieceColor() == color.getOtherColor()
                    & getPiece(pos).canTake(pos, posK, this)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateBoardPosition(String pos) {
        for (String position : V2BoardIterator.computePositions()) {
            if (position == pos) {
                return true;
            }
        }
        return false;
    }
    
    private List<V2BoardListener> listeners = new ArrayList<V2BoardListener>();
    
    public void addBoardListener(V2BoardListener listener) {
        listeners.add(listener);
    }
    
    public void removeBoardListener(V2BoardListener listener) {
        listeners.remove(listener);
    }
    
    public void fireSquareChanged(String position) {
        for (V2BoardListener listener : listeners) {
            listener.squareChanged(position, this);
        }
    }
    
    public void setPiece(String position, V2Piece piece) {
        validateBoardPosition(position);
        pieces[getRowIndex(position)][getColumnIndex(position)] = piece;
        fireSquareChanged(position);
    }
    
    private void firePieceMoved(String from, String to) {
        for (V2BoardListener listener : listeners) {
            listener.pieceMoved(from, to, this);
        }
    }
    
    public void movePiece(String from, String to) {
        V2Piece piece = getPiece(from);
        setPiece(from, null);
        setPiece(to, piece);
        firePieceMoved(from, to);
    }
    
    public String findKing(V2PieceColor pieceColor) {
        for (String position : V2BoardIterator.computePositions()) {
            V2Piece piece = getPiece(position);
            if (piece instanceof King & piece.getPieceColor() == pieceColor) {
                return position;
            }
        }
        return null;
    }
    
    public String getPiecePosition(V2Piece piece) {
        for (String pos : V2BoardIterator.computePositions()) {
            return getPiece(pos) == piece ? pos : null;
        }
        return null;
    }
    
    public boolean checkmate() {
        if (findKing(V2PieceColor.BLACK) == null || V2PieceColor.WHITE == null) {
            return true;
        }
        return false;
    }
    // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
    // 8 ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜ 8
    // 7 ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟ 7
    // 6 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 6
    // 5 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 5
    // 4 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 4
    // 3 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 3
    // 2 ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙ 2
    // 1 ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖ 1
    // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
    public String toString() {
        String s = " ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░";
        for (int i = 8; i > 0; i--) {
            s += "\n";
            s += " " + i + " ";
            for (int j = 0; j < 8; j++) {
                String pos = "" + (char) ((char) j + 'a') + "" + i;
                if (getPiece(pos) == null) {
                    s += "▓ ";
                } else {
                    V2Piece piece = getPiece(pos);
                    if (piece.getPieceColor() == V2PieceColor.BLACK) {
                        if (piece instanceof V2King) {
                            s += "♚ ";
                        } else if (piece instanceof V2Queen) {
                            s += "♛ ";
                        } else if (piece instanceof V2Bishop) {
                            s += "♝ ";
                        } else if (piece instanceof V2Knight) {
                            s += "♞ ";
                        } else if (piece instanceof V2Rook) {
                            s += "♜ ";
                        } else if (piece instanceof V2Pawn) {
                            s += "♟ ";
                        }
                    } else if (piece.getPieceColor() == V2PieceColor.WHITE) {
                        if (piece instanceof V2King) {
                            s += "♔ ";
                        } else if (piece instanceof V2Queen) {
                            s += "♕ ";
                        } else if (piece instanceof V2Bishop) {
                            s += "♗ ";
                        } else if (piece instanceof V2Knight) {
                            s += "♘ ";
                        } else if (piece instanceof V2Rook) {
                            s += "♖ ";
                        } else if (piece instanceof V2Pawn) {
                            s += "♙ ";
                        }
                    }
                }
            }
            s += "" + i;
        }
        s += "\n" + " ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░";
        return s;
    }
}
