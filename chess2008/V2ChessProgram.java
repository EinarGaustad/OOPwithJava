package chess2008;

import java.util.Scanner;


public class V2ChessProgram implements V2BoardListener {
        
        private V2Board game;
        
        // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
        // 8 ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜ 8
        // 7 ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟ 7
        // 6 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 6
        // 5 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 5
        // 4 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 4
        // 3 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 3
        // 2 ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙ 2
        // 1 ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖ 1
        // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
        public void init() {
            game = new V2Board();
            game.addBoardListener(this);
            
            // test:
        // int nr = 0;
        // for (String position : V2BoardIterator.computePositions()) {
        // nr++;
        // System.out.print(" " + position);
        // if (nr == 8) {
        // System.out.println();
        // nr = 0;
        // }
        // }
        // System.out.println("\n" + "test: black king position: "
        // + game.findKing(V2PieceColor.BLACK));
        // System.out.println("\n" + "test: White king position: "
        // + game.findKing(V2PieceColor.WHITE));
        }
        
        public void run() {
            Scanner sc = new Scanner(System.in);
            int moveSum = 0;
            System.out.println("Write in <from-to>: a2-a3");
            while (true) {
                System.out.println(game.toString());
                String mt;
                while (true) {
                    System.out.println(turn(moveSum) + "'s turn: ");
                    mt = sc.next();
                    if (mt.length() == 5) {
                        String from = mt.substring(0, 2);
                    if (game.getPiece(from).getPieceColor() == turn(moveSum)) {
                            String to = mt.substring(3);
                        if (game.validateBoardPosition(mt.substring(0, 2))
                                & game.validateBoardPosition(to)) {
                                if (game.isLegalMove(game.getPiece(from)
                                        .getPieceColor(), from, to)) {
                                    game.movePiece(from, to);
                                    moveSum++;
                                    if (game.isCheck(game.getPiece(to)
                                            .getPieceColor())) {
                                        System.out.println("The "
                                                + game.getPiece(to)
                                                        .getPieceColor()
                                                + "King is in Check!");
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("Illegal move!");
                }
                if (game.checkmate()) {
                    System.out.println(turn(moveSum) + " Win !");
                    System.out.println("GAME OVER!");
                    break;
                }
            }
            sc.close();
        }
        
    public static V2PieceColor turn(int moveSum) {
            if (moveSum % 2 == 0) {
            return V2PieceColor.WHITE;
            } else {
            return V2PieceColor.BLACK;
            }
        }
        

    @Override
    public void pieceMoved(String from, String to, V2Board board) {
        
    }

    @Override
    public void squareChanged(String position, V2Board board) {
        System.out.println(position+" changed");
        System.out.println(board.toString());        
    }
}
