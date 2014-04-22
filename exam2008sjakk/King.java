package exam2008sjakk;

public class King extends AbstractPiece implements Piece {
    
    public King(String color) {
        this.color = new PieceColor(color);
    }

    @Override
    public boolean canTake(String from, String to, Board board) {
        if (board.getPiece(from).getPieceColor().getColor() != board
                .getPiece(to).getPieceColor().getColor()
                & canMove(from, to, board)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canMove(String from, String to, Board board) {
        if ((from.charAt(0) + 1 == to.charAt(0)
                || from.charAt(0) - 1 == to.charAt(0) || from.charAt(0) == to
                .charAt(0))
                & (from.charAt(1) + 1 == to.charAt(1)
                        || from.charAt(1) - 1 == to.charAt(1) || from.charAt(1) == to
                        .charAt(1)) & (from != to)) {
            return true;
            
        }
        return false;
    }
    
    // o o o
    // o K o
    // o o o

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
