package chess2008;


public class V2Queen extends V2AbstractPiece implements V2Piece {
    
    protected V2Queen(V2PieceColor pieceColor) {
        super(pieceColor);
    }
    
    @Override
    public boolean canMove(String from, String to, V2Board board) {
        return (V2Board.isStraight(from, to) || V2Board.isDiagonal(from, to))
                & board.isOccupiedBetween(from, to);
    }
    
}
