package exam2008sjakk;


public class V2Knight extends V2AbstractPiece implements V2Piece {
    
    protected V2Knight(V2PieceColor pieceColor) {
        super(pieceColor);
    }
    
    @Override
    public boolean canMove(String from, String to, V2Board board) {
        return V2Board.getColumnDistance(from, to)
                * V2Board.getRowDistance(from, to) == 2;
    }
    
}
