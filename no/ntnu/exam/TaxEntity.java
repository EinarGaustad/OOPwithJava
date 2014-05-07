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
    final private String idnr;      //final can not change after initialized 
    private double    taxpercent;
    private long      income, deduction, debt, assets;
    private String       name, commune;
    
    //    protected TaxEntity(int idnr, String name, double taxpercent, long income,
    //            long deduction, long debt, long assets) {
    //        this.idnr = idnr;
    //        this.taxpercent = taxpercent;//check value?
    //        this.income = income;
    //        this.debt = debt;
    //        this.name = name;
    //    }
    
    protected TaxEntity(String idnr, String name, double taxpercent) {
        if (checkId(idnr)) {//bruker enkle hjelpemetoder for å sjekke id
            this.idnr = idnr;
        } else {
            throw new IllegalArgumentException("Invalid ID: " + idnr);
        }
        setName(name);
        setPercent(taxpercent);
    }
    
    /**
     * Vi trenger en «protected constructor» for å vise at ingen andre enn
     * sub-klassene skal kunne opprette instanser av typen TaxEntity.
     * 
     * (Andre klasser i package no.ntnu.eksamen kunne også brukt
     * protected-konstruktøren, om ikke klassen hadde vært abstract).
     * 
     * 
     * Alle kall til denne konstruktøren fra en sub-klasse (som TaxPerson eller
     * TaxFirm ) må skje i første linje i konstruktøren til sub-klassen.
     * Syntaksen er:
     * super(id, name, percent);
     */
    
    /**
     * 
     * @param name
     * 
     *            Setters bør være public slik at de kan benyttes fra
     *            (potensielt andre) TaxProgram etc.(Bonus for riktig bruk av
     *            <this>
     * 
     *            Bør kaste IllegalArgumentException eller annen
     *            RuntimeException hvis feil oppdages.
     * 
     */
    public void setName(String name) {
        if (checkNavn(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
    }
    
    /**
     * 
     * @param percent
     *            set tax percent
     */
    public void setPercent(double percent) {
        if (checkPercent(percent)) {
            this.taxpercent = percent;
        } else {
            throw new IllegalArgumentException("Invalid tax percentage: "
                    + percent);
        }
    }
    
    /**
     * 
     * Trenger bare get-metode for idnr, siden det aldri skal kunne endres.
     * Trenger get- og set-metoder for navn, skatteprosent, inntekt, formue,
     * fradrag og gjeld.
     * Alle disse tilgangsmetodene bør være public slik at de kan benyttes i
     * (potensielt andre) TaxProgram.
     */
    public String getIdnr() {
        return this.idnr;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getTaxpercent() {
        return this.taxpercent;
    }
    
    public void setIncome(long income) {
        if (checkPositive(income)) {
            this.income = income;
        } else {
            throw new IllegalArgumentException("Error! Negativ income:"
                    + income);
        }
    }
    public long getIncome() {
        return this.income;
    }
    
    public void setDebt(long debt) {
        if (checkPositive(debt)) {
            this.debt = debt;
        } else {
            throw new IllegalArgumentException("Negativ debt: " + debt);
        }
    }

    public long getDebt() {
        return this.debt;
    }
    
    public void setDeduction(long deduction) {
        if (checkPositive(deduction)) {
            this.deduction = deduction;
        } else {
            throw new IllegalArgumentException("Invalid value: " + deduction);
        }
    }
    public long getDeduction() {
        return this.deduction;
    }
    
    public void setAssets(long assets) {
        if (checkPositive(assets)) {
            this.assets = assets;
        } else {
            throw new IllegalArgumentException("Invalid value: " + assets);
        }
    }
    
    public long getAssets() {
        return this.assets;
    }
    //-Beregne skatten for alle landets innbyggere etter følgende formler: 
    //    Skatt = Inntektsskatt + Formueskatt
    //    Inntektsskatt = (inntekt – fradrag) * skatteprosent % 
    //    Formueskatt = (formue – gjeld) * 1 %
    //    Hvis gjelden er større enn formuen blir det ingen formueskatt det året.
    //    (NB: Tilsvarende for inntekt/fradag for å unngå negativ skatt!!)
    
    public long getTax() {
        long incomeTax = (long) ((this.income - this.deduction) * taxpercent / 100);
        long assetsTax = (this.assets - this.debt) < 0 ? 0
                : (this.assets - this.debt) * 1 / 100;
        return incomeTax + assetsTax;
    }
    
    //    public long getSkatt() {
    //        long tax = 0;
    //        if (assets > debt) {
    //            tax += (assets - debt) * YearRegister.wealthTaxPercent / 100;
    //        }
    //        if (income > deduction) {
    //            tax += (income - deduction) * taxpercent / 100;
    //        }
    //        return tax;
    //    }
    public void setCommune(String commune) {
        this.commune = commune;
    }
    
    public String getCommune() {
        return commune;
    }
    /**
     * 
     * @return given value is bigger or equal to 0
     */
    public boolean checkPositive(double value) {
        return value > 0.0;// ? true : false;
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
     * @param name
     * @return
     * 
     *         Man kan også argumentere for at checkName må behandles på en
     *         lignende måte som checkId (hvis man vil), men det står ikke noe
     *         om det i oppgaven.
     */
    public boolean checkNavn(String name) {
        int charCount = 0;
        String lc = name.toLowerCase();
        for (int i = 0; i < name.length(); i++) {
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
    protected abstract boolean checkId(String idnr);

    public String toString() {
        return "idnr: " + idnr + " Name: " + name + "\n" + " Tax Percent: "
                + taxpercent + " Income: " + income + "\n" + " Deduction: "
                + deduction + " debt: " + debt;
    }
}
