package exam2008sjakk;


public class V2Rook extends V2AbstractPiece implements V2Piece {
    

    
    protected V2Rook(V2PieceColor pieceColor) {
        super(pieceColor);
    }

    public boolean canMove(String from, String to, V2Board board) {
        return Board.isStraight(from, to)
                && (!board.isOccupiedBetween(from, to));
    }
}
