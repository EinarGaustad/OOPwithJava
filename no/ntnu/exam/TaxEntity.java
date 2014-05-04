package no.ntnu.exam;

public abstract class TaxEntity {
    
    //by default 2.3 is double literal so to tell compiler to treat as float 2.3f
    /**
     * int: By default, the int data type is a 32-bit signed two's complement
     * integer, which has a minimum value of -2^31 and a maximum value of
     * 2^31-1.
     * 
     * long: The long data type is a 64-bit two's complement integer. The signed
     * long has a minimum value of -2^63 and a maximum value of 2^63-1.
     */
    //    DataType                  DefaultValue (for fields)
    //    byte                      ---  0
    //    short                     ---  0
    //    int                       ---  0          int 32-bit
    //    long                      ---  0L         long 64-bit
    //    float                     ---  0.0f
    //    double                    ---  0.0d       doulbe
    //    char                      ---  '\u0000'
    //    String (or any object)    ---  null
    //    boolean                   ---  false
    final private int idnr;      //final can not change after initialized 
    private double    taxpercent;
    private long      income, deduction, debt;
    private String    name;
    
    public TaxEntity(int idnr, String name, double taxpercent, long income,
            long deduction, long debt, long assets) {
        this.idnr = idnr;
        this.taxpercent = taxpercent;
        this.income = income;
        this.debt = debt;
        this.name = name;

    }
    
    /**
     * 
     * @return given value is bigger or equal to 0
     */
    public boolean checkPositive(double value) {
        return value > 0.0 ? true : false;
    }
    
    /**
     * 
     * @param value
     * @return true if 0<=value<=100, false otherwise
     */
    public boolean checkPercent(double value) {
        return !(value < 0 && value > 100);
    }
    
    /**
     * 
     * @param name
     * @return true if name include at least 3 Norwegian letters
     */
    public boolean checkName(String name) {
        String s = "abcdefghijklmnopqrstuvwxyzæøå";
        if (name.length() >= 3) {
            for (int i = 0; i < name.length(); i++) {
                if (!s.contains(name.charAt(i) + "")) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param navn
     * @return
     * 
     *         Man kan også argumentere for at checkName må behandles på en
     *         lignende måte som checkId (hvis man vil), men det står ikke noe
     *         om det i oppgaven.
     */
    public boolean checkNavn(String navn) {
        int charCount = 0;
        String lc = navn.toLowerCase();
        for (int i = 0; i < navn.length(); i++) {
            char c = lc.charAt(i);
            if (c >= 'a' && c <= 'z' || c == 'æ' || c == 'ø' || c == 'å') {
                charCount++;
            }
        }
        if (charCount < 3) {
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @param idnr
     * @return
     * 
     *         checkId må være abstract siden TaxEntity ikke kan vite om den er
     *         en TaxPerson eller TaxFirm.
     *         Metodene bør være private, siden de inneholder spesifikke regler
     *         som kun skal brukes i TaxEntity, men checkId() må være protected
     *         (siden den er abstract) slik at den kan Overrides i sub-klassene
     *         TaxPerson eller TaxFirm.
     */
    protected abstract boolean checkId(int idnr);

    public String toString() {
        return "idnr: " + idnr + " Name: " + name + "\n" + " Tax Percent: "
                + taxpercent + " Income: " + income + "\n" + " Deduction: "
                + deduction + " debt: " + debt;
    }
}
