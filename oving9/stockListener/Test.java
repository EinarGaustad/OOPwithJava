package oving9.stockListener;


public class Test {
    
    public static void main(String[] args) {
        Stock s1 = new Stock("stock1", 100);
        Stock s2 = new Stock("stock1", 200);
        Stock s3 = new Stock("stock1", 300);
        Stock s4 = new Stock("stock1", 400);
        Stock s5 = new Stock("stock1", 500);
        
        StockIndex stocklistener = new StockIndex("test1", s1, s2, s3, s4);
        s1.addStockListener(stocklistener);
        s2.addStockListener(stocklistener);
        // s3.addStockListener(stocklistener);
        // s4.addStockListener(stocklistener);
        s5.addStockListener(stocklistener);
        System.out.println(stocklistener.getName());
        System.out.println(stocklistener.getIndex());

        s1.setPrice(111);
        System.out.println(stocklistener.getName());
        System.out.println(stocklistener.getIndex());
        
        stocklistener.addStock(s5);
        System.out.println(stocklistener.getName());
        System.out.println(stocklistener.getIndex());
        
        s5.setPrice(50);
        System.out.println(stocklistener.getName());
        System.out.println(stocklistener.getIndex());
        
        s5.setPrice(50);
        System.out.println(stocklistener.getName());
        System.out.println(stocklistener.getIndex());
    }
    
}
