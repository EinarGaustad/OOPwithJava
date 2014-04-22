package exam2008sjakk;


public class Knight extends AbstractPiece implements Piece {
    
    
    public Knight(String color) {
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
