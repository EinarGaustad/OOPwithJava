package oving10.sokoban;

import java.util.Stack;

public class GridMove {

    private Grid    spille;
    private Stack<char[][]> tracker;
    private Stack<char[][]> redoStack;
    
    public GridMove() {
        spille = new Grid();
        initStack();
    }
    
    public GridMove(String level) {
        spille = new Grid(level);
        initStack();
    }
    
    public void initStack() {
        tracker = new Stack<char[][]>();
        redoStack = new Stack<char[][]>();
    }
    
    public String undo() {
        String message;
        if (tracker.size() > 0) {
            char[][] tempGrid = tracker.pop();
            spille.loadGrid(tempGrid);
            redoStack.push(tempGrid);
            message = "done";
        }else{
            message = "Can not undo! Stack er empty!";
        }
        return message;
    }
    
    public String redo() {
        String message = "";
        if (redoStack.size() > 0) {
            char[][] tempGrid = redoStack.pop();
            spille.loadGrid(tempGrid);
            tracker.push(tempGrid);
        } else {
            message = "can not redo! Stack er empty!";
        }
        return message;
    }
    public Grid getGrid() {
        return this.spille;
    }

    // '@' spiller
    public void moveTo(char flytteTil) {
        int x, y;
        // find +
        if (hvor('@')[0] == 0 && hvor('@')[1] == 0) {// +
            x = hvor('+')[0];
            y = hvor('+')[1];
        } else {// find @
            x = hvor('@')[0];
            y = hvor('@')[1];
        }
        int i = x;
        int j = y;
        switch (flytteTil) {
            case 'a':
                j -= 1;
                break;
            case 's':
                i += 1;
                break;
            case 'd':
                j += 1;
                break;
            case 'w':
                i -= 1;
                break;
        }
        // moving part if not # * can move
        if (kanFlytte(i, j)) {
            // if destination is ' '
            if (spille.getElement(i, j) == ' ') {
                spille.setIn(i, j, '@');
                if (spille.getElement(x, y) == '+') {
                    spille.setIn(x, y, '.');
                } else {
                    spille.setIn(x, y, ' ');
                }
            }
            // if destination is '.'
            else if (spille.getElement(i, j) == '.') {
                spille.setIn(i, j, '+');// '+' spiller på mål
                if (spille.getElement(x, y) == '+') {
                    spille.setIn(x, y, '.');
                }
                if (spille.getElement(x, y) == '@') {
                    spille.setIn(x, y, ' ');
                }
            }
            // if destination is $
            else if (spille.getElement(i, j) == '$') {// '$' boks
                int m = nextTegn(i, j, x, y)[0];
                int n = nextTegn(i, j, x, y)[1];
                if (spille.getElement(m, n) == ' ') {
                    spille.setIn(m, n, '$');
                    spille.setIn(i, j, '@');
                    if (spille.getElement(x, y) == '+') {
                        spille.setIn(x, y, '.');
                    } else {
                        spille.setIn(x, y, ' ');
                    }
                } else if (spille.getElement(m, n) == '.') {
                    spille.setIn(m, n, '*');// '*' boks på mål
                    spille.setIn(i, j, '@');
                    if (spille.getElement(x, y) == '+') {
                        spille.setIn(x, y, '.');
                    }else {
                        spille.setIn(x, y, ' ');
                    }
                }
            }
            char[][] newtable = new char[spille.getGridHeight()][spille
                    .getGridWidth()];
            for (int k = 0; k < newtable.length; k++) {
                for (int k2 = 0; k2 < newtable.length; k2++) {
                    newtable[k][k2] = spille.getGridTable()[k][k2];
                }
            }
            tracker.push(newtable);
        }
    }
    
    public int[] nextTegn(int i, int j, int x, int y) {
        int[] table = { 0, 0 };
        if (i == x) {
            if (j < y) {
                table[0] = i;
                table[1] = j - 1;
                return table;
            }
            if (j > y) {
                table[0] = i;
                table[1] = j + 1;
                return table;
            }
        }
        if (j == y) {
            if (i < x) {
                table[0] = i - 1;
                table[1] = j;
                return table;
            }
            if (i > x) {
                table[0] = i + 1;
                table[1] = j;
                return table;
            }
        }
        return table;
    }
    
    // Tegn Betydning Utskrift
    // '#' vegg
    // '.' mål
    // '$' boks
    // '*' boks på mål
    // '@' spiller
    // '+' spiller på mål
    // ' ' tomt felt
    public boolean kanFlytte(int i, int j) {
        if (spille.getElement(i, j) == '#' || spille.getElement(i, j) == '*') {
            return false;
        }
        return true;
    }
    
    public boolean stopp(char inn) {
        if (inn == 'p') {
            return true;
        }
        return false;
    }
    
    public boolean isValid(char inn) {
        if (inn == 'a' || inn == 's' || inn == 'd' || inn == 'w') {
            return true;
        }
        return false;
    }
    
    public boolean vinne() {
        if (hvor('.')[0] == 0 && hvor('.')[1] == 0 && hvor('+')[0] == 0
                && hvor('+')[1] == 0) {
            return true;
        }
        return false;
    }
    
    public int[] hvor(char tegn) {
        int[] xy = { 0, 0 };
        for (int i = 0; i < spille.getGridHeight(); i++) {
            for (int j = 0; j < spille.getGridWidth(); j++) {
                if (spille.getElement(i, j) == tegn) {
                    xy[0] = i;
                    xy[1] = j;
                    return xy;
                }
            }
        }
        return xy;
    }
    
    public String toString() {
        return spille.toString();
    }
}