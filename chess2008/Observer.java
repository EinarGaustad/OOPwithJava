package chess2008;


public interface Observer {
    
    public void boardChanged(Board board, String pos, Piece piece);
}
