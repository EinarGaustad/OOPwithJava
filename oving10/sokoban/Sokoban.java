package oving10.sokoban;

public class Sokoban implements GridGame {
    
    public static void main(String[] args) throws Exception {
        GridGameGUI.main(new String[] { Sokoban.class.getName() });
    }
    
    private GridMove   sokoban;
    private GameOutput output;
    private String     message;
    private String     loadMessage;

    @Override
    public void init(String level) {
        // if load game
        if (level.contains(".txt")) {
            sokoban = new GridMove();
            loadGame(level);
        } else if (level == "0" || level == "1" || level == "2") {
            sokoban = new GridMove(level);
        } else {
            sokoban = new GridMove("0");
        }
        message = "w: up" + "\n" + "s: down" + "\n" + "a: left" + "\n"
                + "d: righ" + "\n" + "<: load a Game" + "\n" + ">: save Game";
    }

    @Override
    public void run(GameOutput output) {
        this.output = output;
        output.info(message);
    }
    
    // read game method
    public void loadGame(String s) {
        ReadAFile read = new ReadAFile();
        read.run(s);
        if (read.getMessage() == "") {
            sokoban.getGrid().loadGrid(read.getGrid());
            loadMessage = "Game loaded!";
        } else {
            loadMessage = read.getMessage() + "not load!";
        }
    }
    
    public void saveGame(String s) {
        WriteAFile write = new WriteAFile(sokoban.getGrid().getGridTable(), s);
        write.run();
        if (write.getMessage() == "") {
            output.info("Game saved !");
        } else {
            output.error(write.getMessage());
        }
    }

    /**
     * En null-verdi betyr at spillet ikke er ferdig og 0 betyr at det ikke ble
     * noe resultat (eller uavgjort). En negativ eller positiv verdi angir hhv.
     * tap eller seier, evt. hvilken av to spillere som vant.
     * 
     */
    @Override
    public Integer doCommand(String command) {
        // System.out.println(sokoban.toString());
        if ("wsad".contains(command.charAt(0) + "")) {
            char move = command.charAt(0);
            sokoban.moveTo(move);
            if (sokoban.vinne()) {
                output.info("Congratulations! You win!");
                return 1;
            }
        } else if (command.startsWith("<")) {// read a game
            if(command.length()<3){
                output.info("wrong input! use format: '< <name>'");
                return null;
            }else{
                loadGame(command.substring(2));
                output.info(loadMessage);
            }
        } else if (command.startsWith(">")) {
            if (command.length() >= 3 && command.charAt(1) == ' '
                    && command.charAt(2) != ' ') {
                saveGame(command.substring(2));
            } else {
                output.error("Wrong format! use format: '< <name>");
            }
        }
        return null;
    }
    
    @Override
    public GridProvider getGridProvider() {
        return sokoban.getGrid();
    }
    
    @Override
    public String getTextFor(Object object) {
        return object.toString();
    }
    
    @Override
    public String getImageFor(Object object) {
        return null;
    }
    
    @Override
    public Integer gridElementInput(int x, int y) {
        return null;
    }
    
    @Override
    public Integer directionInput(int dx, int dy) {
        // up dx:0 dy: -1
        if (dx == 0 && dy == -1) {
            doCommand("w");
        }
        // down dx:0 dy: 1
        else if (dx == 0 && dy == 1) {
            doCommand("s");
        }
        // leftdx:-1 dy: 0
        else if (dx == -1 && dy == 0) {
            doCommand("a");
        }
        // right dx:1 dy: 0
        else if (dx == 1 && dy == 0) {
            doCommand("d");
        }
        return null;
    }

}
