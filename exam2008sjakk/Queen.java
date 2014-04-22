package exam2008sjakk;


public class Queen extends AbstractPiece implements Piece {
    
    private PieceColor color;
    
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
