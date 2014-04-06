package oving9.stockListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author GuoJunjun I en del sammenhenger vil du ikke være interessert i alle
 *         småendringer i en aksjekurs, men interessert i endringer utenfor et
 *         visst område eller av en viss størrelse. Kanskje vil du kjøpe aksjer
 *         hvis det er billig nok, ønsker å selge dersom kursen blir høy nok
 *         eller ønsker å vite om større endringer som kan være signal om
 *         viktige kursendringer. Så for å unngå å sende ut mange uinteressante
 *         kursoppdateringer, er det aktuelt med to typer utvidelser av
 *         Stock-klassen. I begge tilfellene bruker men en egen
 *         addStockListener-metode for å registrere lytteren og hva slags
 *         endring man er interessert i. Implementer utvidelsen(e) i en
 *         subklasse som du kaller SmartStock. Merk at denne utvidelsen av Stock
 *         ikke er så relevant å bruke sammen med StockIndex, siden den da vil
 *         miste noen oppdateringer og dermed kunne risikere å være inkonsistent
 *         innimellom.
 */
public class SmartStock extends Stock {
    
    private Stack<Double>                stack         = new Stack<Double>();
    
    private Map<StockListener, double[]> map           = new HashMap<StockListener, double[]>();
    // private double difference;
    private ArrayList<Double>            prisintervall = new ArrayList<Double>();
    private ArrayList<Double>            difference    = new ArrayList<Double>();
    
    // private double min;
    // private double max;

    SmartStock(String ticker, double aksjekurs) {
        super(ticker, aksjekurs);
        this.stack.add(aksjekurs);
    }
    
    @Override
    void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        } else {
            super.setPrice(price);
            this.stack.add(price);// add price to stack
            if (prisintervall.size() == 2) {
                System.out.println("prisintervall" + stack.peek());
                if (getPrice() < prisintervall.get(0)
                        || getPrice() > prisintervall.get(1)) {
                    broadcast(stack.peek(),// stack.get(stack.size() - 2),
                            stack.get(stack.size() - 1));
                    System.out.println(prisintervall.get(0) + " : "
                            +
                            prisintervall.get(1));
                }
            }
            if (difference.size() == 1) {
                for (int i = 1; i < stack.size(); i++) {
                    if (Math.abs(stack.get(0) - stack.get(i)) >= difference
                            .get(0)) {
                        broadcast(stack.get(i), stack.get(0));
                        //stack.clear();
                        break;
                    }
                }
            }
        }
    }
    
    void addStockListener(StockListener stocklistener, double min, double max) {
        // this.min = min;
        // this.max = max;
        this.prisintervall.add(0, min);
        this.prisintervall.add(1, max);
        super.addStockListener(stocklistener);

    }

    void addStockListener(StockListener stocklistener, double difference) {
        map.put(stocklistener, new double[] { difference });
        super.addStockListener(stocklistener);
        this.difference.add(0, difference);
    }
    
    @Override
    public void broadcast(double gammelPris, double nyPris) {
        for (StockListener listener : stocklist) {
            listener.stockPriceChanged(this, gammelPris, nyPris);
        }
    }
}
