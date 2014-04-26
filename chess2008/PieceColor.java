package chess2008;


public class PieceColor {
    
    private String color;
    
    public PieceColor(String color) {
        this.color = color;
    }
    
    public String getOtherColor(){
        if (this.color == "WHITE") {
            return "BLACK";
        }
        else{
            return "WHITE";
        }
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String toString() {
        return this.color;
    }
}
