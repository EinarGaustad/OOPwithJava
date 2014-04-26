package chess2008;


public class Queen extends AbstractPiece implements Piece {
    
    public Queen(String color) {
        this.color = new PieceColor(color);
    }
    
    @Override
    public boolean canTake(String from, String to, Board board) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canMove(String from, String to, Board board) {
        // TODO Auto-generated method stub
        return false;
    }
}
