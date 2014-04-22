package exam2008sjakk;

public interface Piece {
    
    public PieceColor getPieceColor();
    
    public boolean canTake(String from, String to, Board board);
    
    public boolean canMove(String from, String to, Board board);
    // ░░a░ b░c░d ░e░f░░g░h░░
    // 8 ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜ 8
    // 7 ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟ 7
    // 6 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 6
    // 5 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 5
    // 4 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 4
    // 3 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 3
    // 2 ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙ 2
    // 1 ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖ 1
    // ░░a░ b░c░d ░e░f░░g░h░░
}
