package oving9.stockListener;

import java.util.ArrayList;

public class Stock {
    
    private String                   ticker;
    protected double                 aksjekurs;
    protected ArrayList<StockListener> stocklist = new ArrayList<StockListener>();

    Stock(String ticker, double aksjekurs) {
        this.ticker = ticker;
        this.aksjekurs = aksjekurs;
    }
    
    void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        } else {
            if (aksjekurs != price) {
            broadcast(aksjekurs, price);
                this.aksjekurs = price;
            }
        }
    }
    
    String getTicker() {
        return ticker;
    }
    
    double getPrice() {
        return aksjekurs;
    }

    public void addStockListener(StockListener stocklistener) {
        if (!stocklist.contains(stocklistener)) {
            stocklist.add(stocklistener);
        }
    }
    
    public void removeStockListener(StockListener stocklistener) {
        if (stocklist.contains(stocklistener)) {
            stocklist.remove(stocklistener);
        }
    }
    
    public void broadcast(double gammelPris, double nyPris) {
        for (StockListener listener : stocklist) {
            listener.stockPriceChanged(this, gammelPris, nyPris);
        }
    }
}
