package exam2008sjakk;


public class PieceColor {
    
    private String pieceColor;
    
    public PieceColor(String color) {
        pieceColor = color;
    }
    
    public String getOtherColor(){
        if (pieceColor == "WHITE") {
            return "BLACK";
        }
        else{
            return "WHITE";
        }
    }
    
    public String getPieceColor() {
        return pieceColor;
    }
}
