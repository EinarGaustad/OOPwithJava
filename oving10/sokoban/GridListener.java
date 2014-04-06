package oving10.sokoban;


public interface GridListener {
    
    /**
     * 
     * @param grid
     * @param x
     * @param y
     * @param w
     * @param h
     *            metoden kalles for å gi beskjed om at en eller flere ruter i
     *            rutenettet (grid) innenfor det angitte rektanglet er endret.
     *            Rektanglet er angitt med posisjon x, y og dimensjonene w, h
     *            (bredde, høyde).
     */
    void gridChanged(GridProvider grid, int x, int y, int w, int h);
}
