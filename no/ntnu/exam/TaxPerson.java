package no.ntnu.exam;


public class TaxPerson extends TaxEntity {
    
    private TaxPerson(String idnr, String name, double taxpercent) {
        super(idnr, name, taxpercent);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 
     */
    @Override
    protected boolean checkId(String idnr) {
        if (idnr.length() != 11) {
            return false;
        } else {
            for (int i = 0; i < 11; i++) {
                if (!Character.isDigit(idnr.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
