package chess2008;


public abstract class V2AbstractPiece implements V2Piece {
    
    private final V2PieceColor pieceColor;
    
    public V2PieceColor getPieceColor() {
        return pieceColor;
    }
    
    protected V2AbstractPiece(V2PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }
    
    public boolean canTake(String from, String to, V2Board board) {
        return canMove(from, to, board);
    }
}
