package oving10.sokoban;


public interface GameOutput {
    
    /**
     * 
     * @param messgae
     *            viser String-argumentet som en enkelt statusoppdatering,
     *            f.eks. "x sin tur" eller "4 av 8 bokser er på plass".
     */
    public void info(String messgae);
    
    /**
     * 
     * @param message
     *            viser String-argumentet som et (forsiktig) varsel. f.eks.
     *            "Ulovlig trekk".
     */
    public void warning(String message);
    
    /**
     * 
     * @param message
     *            viser String-argumentet som et (kraftig) varsel. f.eks.
     *            "Inkonsistent brett".
     */
    public void error(String message);
}
