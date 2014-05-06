package no.ntnu.exam;


public class TaxFirm extends TaxEntity {
    
    private TaxFirm(String idnr, String name, double taxpercent) {
        super(idnr, name, taxpercent);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Organisasjonsnummer brukes for å identifisere juridiske personer
     * (enheter) i Norge, og tildeles ved registrering i Enhetsregisteret.
     * Organisasjonsnummeret består av ni siffer og starter på tallet 8 eller
     * 9.
     */
    @Override
    protected boolean checkId(String idnr) {
        return (Integer.parseInt(idnr) >= 800000000
                && Integer.parseInt(idnr) <= 999999999);
    }
    
}
