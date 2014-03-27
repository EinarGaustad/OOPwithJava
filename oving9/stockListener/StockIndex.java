package oving9.stockListener;

import java.util.ArrayList;

/**
 * 
 * @author GuoJunjun I korte trekk bruker man en aksjeindeks til å måle
 *         utviklingen av et utvalg aksjer. Vår enkle, fiktive aksjeindeks
 *         StockIndex har et navn (String), indeks (double) og en liste med
 *         Stock-objektene som er inkludert i indeksen. Indeksen beregnes ut i
 *         fra summen av aksjeprisene den "observerer". Når en av aksjeprisene
 *         øker eller synker, må tilstanden til StockIndex-objektet holdes
 *         konsistent med denne utviklingen. Dette lar seg gjøre ved at
 *         StockIndex observerer én eller flere Stock-objekter.
 */
public class StockIndex implements StockListener {
    
    private String           name;
    private double           index;
    private ArrayList<Stock> stocklist = new ArrayList<Stock>();
    
    /**
     * konstruktør som tar inn ingen, én eller flere aksjer (Stock-objekter).
     * Stock-parameteret defineres som et såkalt varargs-parameter. NB:
     * StockIndex-objektet skal holdes oppdatert på aksjekursene allerede fra
     * det er instansiert. Dersom en indeks instansieres uten Stock-objekter,
     * skal aksjeindeksen være 0.
     */
    // StockIndex() {
    // }
    
    /**
     * 
     * @param name
     * @param stock
     *            Java tilbyr en mekanisme kalt varargs, for dette formålet.
     *            Enkelt sagt kan en definere at siste argument er en samling
     *            verdier som angis etter hverandre i argumentlista, istedenfor
     *            å eksplisitt lage en tabell eller liste. Argumentene samles
     *            automatisk opp i en (ny-allokert) tabell, som metoden så kan
     *            iterere over. Merk at det godt kan være andre parametre før
     *            varargs-parameteret, men det kan ikke være noen etter. Dette
     *            skyldes at det da lett blir tvetydig om et argument hører til
     *            varargs-parameteret eller et påfølgende parameter. Merk også
     *            at en ikke kan spesifisere minimum og/eller maksimum antall
     *            argumenter. Med varargs så kan en gi inn 0, 1 eller flere
     *            verdier.
     */
    StockIndex(String name, Stock... stock) {
        this.index = 0;
        this.name = name;
        for (int i = 0; i < stock.length; i++) {
            stocklist.add(stock[i]);
            index += stock[i].getPrice();
            stock[i].addStockListener(this);
        }
    }
    
    void addStock(Stock stock) {
        if (!stocklist.contains(stock)) {
            stocklist.add(stock);
            index += stock.getPrice();
            stock.addStockListener(this);
        }
    }
    
    void removeStock(Stock stock) {
        if (stocklist.contains(stock)) {
            index -= stock.getPrice();
            stocklist.remove(stock);
        }
    }
    
    double getIndex() {
        return index;
    }
    
    String getName() {
        return name;
    }

    @Override
    public void stockPriceChanged(Stock stock, double gammelPris, double nyPris) {
        index += nyPris - gammelPris;
    }
    
}
