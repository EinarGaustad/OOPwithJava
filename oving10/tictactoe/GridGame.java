package oving10.tictactoe;


public interface GridGame {
    
    /**
     * 
     * @param streng
     *            denne metoden kalles av GUI-et for å initialisere et nytt
     *            spill, men uten at det settes igang. Argumentet er ment å angi
     *            et nivå, brett eller det som gir mening for spillet ditt. Det
     *            kan f.eks. være en nettadresse hvor nivået ligger, nivået
     *            koden direkte i en String eller dimensjonene til et brett. Det
     *            er brukeren som skriver String-argumentet inn, og det er opp
     *            til implementasjonen av metoden å tolke og bruke det.
     */
    public void init(String streng);
    
    /**
     * 
     * @param game
     *            denne metoden setter igang spillet. Argumentet er et objekt
     *            som spillet må huske og som under spillets gang kan brukes for
     *            å gi meldinger og statusoppdateringer til brukeren. (I praksis
     *            er dette objektet GUI-et selv, og GUI-ets implementasjon av
     *            GameOutput-metodene angjør hvordan meldinger vises til
     *            brukeren.)
     */
    public void run(GameOutput game);
    
    /**
     * 
     * @param command
     *            det er denne metoden som driver spillet fremover ved at
     *            brukerinput formidles fra GUI-et til spillet. Argumentet er en
     *            slags kommandolinje, på et format som kan tolkes og brukes av
     *            spillet. Returverdien er spillets måte å fortelle GUI-et om
     *            spillet er ferdig og i tilfelle hva som ble resultatet. En
     *            null-verdi betyr at spillet ikke er ferdig og 0 betyr at det
     *            ikke ble noe resultat (eller uavgjort). En negativ eller
     *            positiv verdi angir hhv. tap eller seier, evt. hvilken av to
     *            spillere som vant.
     * @return
     */
    public Integer doCommand(String command);
    
    public GridProvider getGridProvider();
    
    /**
     * 
     * @param object
     * @return teksten som skal vises for rutenett-elementet angitt av
     *         argumentet. Dersom en ikke ønsker en tekst så returneres null.
     */
    public String getTextFor(Object object);
    
    /**
     * 
     * @param object
     * @return en String som angir bildet som skal vises for rutenett-elementet
     *         angitt av argumentet. String-en kan være en nettadresse eller
     *         navnet/stien til en fil som er relativt til spillklassen eller
     *         prosjektet. Hvis en f.eks. har en fil med navn bilde.png liggende
     *         i samme mappe/pakke som java-fila for spillklassen din, så
     *         returneres bare "bilde.png". Dersom en ikke ønsker et bilde så
     *         returneres null.
     */
    public String getImageFor(Object object);
    
    // public Integer gridElementSelected(int x, int y);
    
    /**
     * 
     * @param x
     * @param y
     * @return kalles når brukeren har valgt en rute i rutenettet, f.eks. ved å
     *         klikke i ruta.
     */
    public Integer gridElementInput(int x, int y);
    
    /**
     * 
     * @param dx
     * @param dy
     * @return kalles når brukeren angir en retning, f.eks. ved å trykke en
     *         piltast.
     */
    public Integer directionInput(int dx, int dy);
}
