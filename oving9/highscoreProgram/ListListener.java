package oving9.highscoreProgram;

/**
 * 
 * @author GuoJunjun ListListener-grensesnittet er vist i klassediagrammet til
 *         venstre og må implementers av alle klasser som ønsker å fungere som
 *         lyttere for HighscoreList-instanser. Lyttere registrerer seg med
 *         HighscoreList sin addListListener-metode og vil siden få beskjed om
 *         nye resultater ved at listChanged-metoden kalles. Argumentene som tas
 *         inn er HighscoreList-objektet som ble endret og posisjonen i lista
 *         der endringen skjedde.
 */
public interface ListListener {
    
    void listChanged(ObservableList list, int changedPosition);
}
