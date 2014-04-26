package chess2008;

public class Pawn extends AbstractPiece implements Piece {

    public Pawn(String color) {
        this.color = new PieceColor(color);
    }
    
    
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



    @Override
    public boolean canTake(String from, String to, Board board) {
        if (board.getPiece(from).getPieceColor().getColor() == "WHITE") {
            if (board.getPiece(to).getPieceColor().getColor() == "BLACK"
                    & from.charAt(1) + 1 == to.charAt(1)) {
                if (from.charAt(0) + 1 == to.charAt(0)
                        || from.charAt(0) - 1 == to.charAt(0)) {
                    return true;
                }
            }
        }
        if (board.getPiece(from).getPieceColor().getColor() == "BLACK") {
            if (board.getPiece(to).getPieceColor().getColor() == "WHITE"
                    & from.charAt(1) - 1 == to.charAt(1)) {
                if (from.charAt(0) + 1 == to.charAt(0)
                        || from.charAt(0) - 1 == to.charAt(0)) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("static-access")
    @Override
    public boolean canMove(String from, String to, Board board) {
        if (board.getPiece(from).getPieceColor().getColor() == "WHITE") {
            if (board.getPiecePosition(this).charAt(1) == 2) {
                if (from.charAt(0) == to.charAt(0)) {
                    if (to.charAt(1) == 4 & !board.isOccupiedBetween(from, to)) {
                        return true;
                    }
                }
            }
            if (to.charAt(0) == from.charAt(0)
                    & to.charAt(1) == from.charAt(1) + 1) {
                return true;
            }
        }
        if (color.getColor() == "BLACK") {
            if (board.getPiecePosition(this).charAt(1) == 7) {
                if (from.charAt(0) == to.charAt(0)) {
                    if (to.charAt(1) == 5 & !board.isOccupiedBetween(from, to)) {
                        return true;
                    }
                }
            }
            if (to.charAt(0) == from.charAt(0)
                    & to.charAt(1) == from.charAt(1) - 1) {
                return true;
            }
        }
        return false;
    }
}
