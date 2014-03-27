package oving9.stockListener;

public interface StockListener {
    
    /**
     * 
     * @param stock
     * @param gammelPris
     * @param nyPris
     *            lyttermetode for å holde lytteren oppdatert på aksjekursen.
     *            Metoden skal ta inn et Stock-objekt, samt gammel og ny pris.
     *            Alle lyttere må implementere denne metoden.
     */
    void stockPriceChanged(Stock stock, double gammelPris, double nyPris);
}