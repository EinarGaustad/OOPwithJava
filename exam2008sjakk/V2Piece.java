package exam2008sjakk;


public interface V2Piece {
    
    public V2PieceColor getPieceColor();
    
    public boolean canTake(String from, String to, V2Board board);
    
    public boolean canMove(String from, String to, V2Board board);
}
