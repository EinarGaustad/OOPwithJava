package exam2008sjakk;

import java.util.ArrayList;

public class Board {
    
    private ArrayList<ArrayList<Piece>> board;
    
    public Board() {
        board = new ArrayList<ArrayList<Piece>>();
    }
    
    public void initBoard() {
        for (int i = 0; i < 8; i++) {
            ArrayList<Piece> insideList=new ArrayList<Piece>();
            for (int j = 0; j < 8; j++) {
                insideList.add(null);
            }
            board.add(insideList);
        }
    }
    
    public Piece getPiece(String position) {
        int x = position.charAt(0) - 'a';
        int y = position.charAt(1) - '0';
        return board.get(y).get(x);
    }
    
    public void setPiece(String position, Piece piece) {
        int x = position.charAt(0) - 'a';
        int y = position.charAt(1) - '0';
        board.get(y).set(x, piece);
    }
    
    public boolean isStraight(String from, String to) {
        if (from.charAt(0) == to.charAt(0)) {
            return true;
        }
        if (from.charAt(1) == to.charAt(1)) {
            return true;
        }
        return false;
    }
    
    public boolean isDiagonal(String from, String to) {
        int x = from.charAt(0) - 'a';
        int y = from.charAt(1) - '0';
        int tx = to.charAt(0) - 'a';
        int ty = to.charAt(1) - '0';
        // ---+
        // --+-
        // -+--
        // +---
        if (Math.abs((x - ty)) == Math.abs((y - tx))) {// 1
            return true;
        }
        // +---
        // -+--
        // --+-
        // ---+
        if (Math.abs((x - tx)) == Math.abs((y - ty))) {// 2
            return true;
        }
        return false;
    }
    
    public boolean isOccupiedBetween(String from, String to) {
        int x = from.charAt(0) - 'a';
        int y = from.charAt(1) - '0';
        int tx = to.charAt(0) - 'a';
        int ty = to.charAt(1) - '0';

        if (isStraight(from, to)) {
            if (x == tx) {
                int miniy = Math.min(y, ty);
                for (int i = 0; i < Math.abs((y - ty))-1; i++) {
                    if (board.get(miniy).get(x) != null) {
                        return true;
                    }
                }
            }
            if (y == ty) {
                int minix = Math.min(x, tx);
                for (int i = 0; i < Math.abs((x - tx)) - 1; i++) {
                    if (board.get(y).get(minix) != null) {
                        return true;
                    }
                }
            }
        }
        if (isDiagonal(from, to)) {
            if (Math.abs((x - ty)) == Math.abs((y - tx))) {// 1
                if (x < tx) {
                    for (int i = 0; i < tx - x - 1; i++) {
                        if (board.get(y - 1).get(x + 1) != null) {
                            return true;
                        }
                    }
                }
                if (x > tx) {
                    for (int i = 0; i < x - tx - 1; i++) {
                        if (board.get(y + 1).get(x - 1) != null) {
                            return true;
                        }
                    }
                }
            }
            if (Math.abs((x - tx)) == Math.abs((y - ty))) {// 2
                if (x < tx) {
                    for (int i = 0; i < tx - x - 1; i++) {
                        if (board.get(y + 1).get(x + 1) != null) {
                            return true;
                        }
                    }
                }
                if (x > tx) {
                    for (int i = 0; i < x - tx - 1; i++) {
                        if (board.get(y - 1).get(x - 1) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
