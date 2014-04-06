package oving10.sokoban;

public interface GridProvider {
    
    /**
     * 
     * @return bredden eller antall kolonner i rutenettet
     */
    public int getGridWidth();
    
    /**
     * 
     * @return høyden eller antall rader i rutenette
     */
    public int getGridHeight();
    
    /**
     * 
     * @param x
     * @param y
     * @return objektet som er lagret i en bestemt rute angitt med
     *         x,y-koordinater (altså kolonne,rad). Dette kan være noe så enkelt
     *         som et tegn
     */
    public Object getGridElement(int x, int y);
    
    /**
     * 
     * @param listener
     *            registrerer en lytter som skal ha beskjed hver gang rutenettet
     *            endres
     */
    public void addGridListener(GridListener listener);
    
    /**
     * 
     * @param listener
     *            avregistrere en lytter som tidligere er registrert med
     *            addGridListener
     */
    public void removeGridListener(GridListener listener);

}
