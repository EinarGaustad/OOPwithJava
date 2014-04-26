package chess2008;


public abstract class AbstractPiece implements Piece {
    
    protected PieceColor color;

    public PieceColor getPieceColor() {
        return this.color;
    }
    
}
