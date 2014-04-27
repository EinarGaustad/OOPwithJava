package chess2008;


public interface V2BoardListener {
    
    public void pieceMoved(String from, String to, V2Board board);
    
    public void squareChanged(String position, V2Board board);
}
