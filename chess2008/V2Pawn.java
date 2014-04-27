package chess2008;


public class V2Pawn extends V2AbstractPiece implements V2Piece {
    
    protected V2Pawn(V2PieceColor pieceColor) {
        super(pieceColor);
    }
    
    @Override
    public boolean canMove(String from, String to, V2Board board) {
        if (board.getPiece(from).getPieceColor() == V2PieceColor.WHITE) {
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
        if (board.getPiece(from).getPieceColor() == V2PieceColor.BLACK) {
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
