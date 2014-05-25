package e2011;

/**
 * 
 * 
 * Del 1 Innkapsling
 * 
 * 
 * a) En kan kategorisere innkapslingsmetoder som enten lese- eller
 * endringsmetoder. Hva er den viktigste oppgaven til endringsmetodene, bortsett
 * fra å utføre selve endringen?
 * 
 * Den viktigste oppgaven er å sjekke validere om den nye verdien eller nye
 * verdiene er lovlige gyldige, før de evt. endres, f.eks. at et navn kun
 * inneholder bokstaver og mellomrom.
 * 
 * 
 * 
 * b) Gitt en Date-klasse med metoder getDay() for å lese datoens dag (1-31),
 * getMonth() for måned (1-12) og getYear() for år (0-99). Skriv kode for en
 * Person-klasse, med felt og innkapslingsmetoder for fødselsdato og kjønn.
 * Kjønn skal kun kunne settes ved oppretting av Person-objektet, mens det for
 * fødselsdatoen ikke er noen slik begrensning.
 * 
 * 
 * 
 */
public class LFPerson {

    /**
     * Her er poenget å velge hvilke konstruktører og metoder som naturlig
     * hører med til innkapslingen, inkludert navn og typer. Data som kun skal
     * kunne settes ved oppretting krever en konstruktør med tilsvarende
     * parameter. Andre data trenger get/set-metoder.
     */
    public static String MALE_GENDER = "male", FEMALE_GENDER = "female";
    private String       gender;
    private Date         dateOfBirth;
    
    public LFPerson(String gender) {
        if (gender != MALE_GENDER && gender != FEMALE_GENDER) {
            throw new IllegalArgumentException(gender
                    + " is not a legal gender");
        }
        this.gender = gender;
    }
    
    public String getGender() {
        return gender;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    //    public void setDateOfBirth(Date dateOfBirth) {
    //        this.dateOfBirth = dateOfBirth;
    //    }

    /**
     * c) Skriv kode for å lagre og innkapsle personnummer i Person-objekter.
     * Du kan anta at fødselsdato og kjønn allerede er satt. Et personnummer
     * består grovt sett av fødselsdatoen, et (vilkårlig) løpenummer og to
     * kontrollsifre. Kontrollsifrene gjør det enklere å sjekke om et
     * personnummer er ekte. Mer spesifikt er reglene for personnummer som
     * følger:
     * - Et personnummer består av 11 siffer, med følgende struktur:
     * D1D2M1M2Y1Y2N1N2N3K1K2 (fargen illustrerer siffergruppene).
     * - De seks første sifrene, D1D2M1M2Y1Y2, tilsvarer fødselsdatoens dag
     * (1-31), måned (1-12) og år (0-99).
     * - De tre neste sifrene, N1N2N3, kan antas å være vilkårlige, men N3 må
     * være partall for kvinner og oddetall for menn.
     * - De to siste sifrene, K1K2, er kontrollsifre, som hver for seg beregnes
     * ut fra de foregående sifrene. Formellen for dem begge er 11 – (VS %
     * 11)1, hvor VS (veid sum) for K1 er D1*F1 + D2*F2 + ... + N2*F8 + N3*F9 og
     * VS for K2 er D1*G1 + D2*G2 + ... + N3*G9 + K1*G10. F’ene og G’ene er
     * oppgitt i tabellen under. Dersom formelen gir et ett-sifret resultat for
     * både K1 og K2 så er personnummeret gyldig, mens gir formelen et
     * to-sifret resultat for K1 og/eller K2, så er personnummeret ugyldig.
     * 
     * 
     * Introduser og bruk gjerne hjelpemetoder for å gjøre koden ryddigere.
     * 
     * Her må en velge egnet datatype for personummeret. En kan forsåvidt lage
     * en egen klasse, men det er greit å bruke talltabell, tegntabell eller
     * String. En må også lage riktig valideringskode, som bør inneholde sjekk
     * for lengde og at hvert element er et siffer, at fødselsdatoen stemmer, at
     * kjønn stemmer med D3 og at kontrollsifrene er riktige. Det er naturlig å
     * lage en hjelpemetode for formelen for kontrollsifrene evt. veid sum,
     * siden den brukes to ganger, og ha én tabell for hvert sett med faktorer.
     * Det kan også være nyttig med en hjelpemetode for å sjekke at to sifre
     * stemmer med et heltall. Hjelpemetodene bør deklareres som static.
     */

    private String pid;
    private static int[] factors1 = { 3, 7, 6, 1, 8, 9, 4, 5, 2 }, factors2 = {
            5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
    
    private static int computeControlDigit(String digits, int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += (digits.charAt(i) - '0') * factors[i];
        }
        return 11 - (sum % 11);
    }
    
    private static boolean checkDigits(String digits, int pos, int num) {
        return (num / 10 == digits.charAt(pos) - '0' && num % 10 == digits
                .charAt(pos + 1) - '0');
    }
    
    private boolean validatePID(String pid) {
        if (pid.length() != 11) {
            return false;
        }
        for (int i = 0; i < pid.length(); i++) {
            if (!Character.isDigit(pid.charAt(i))) {
                return false;
            }
        }
        int day = dateOfBirth.getDay(), month = dateOfBirth.getMonth(), year = dateOfBirth
                .getYear();
        if (!(checkDigits(pid, 0, day) && checkDigits(pid, 2, month))
                && checkDigits(pid, 4, year)) {
            return false;
        }
        boolean isOdd = ((pid.charAt(8) - '0') % 2) == 1;
        if ((gender == MALE_GENDER) != isOdd) {
            return false;
        }
        int k1 = computeControlDigit(pid, factors1), k2 = computeControlDigit(
                pid, factors2);
        if (k1 != pid.charAt(9) - '0' || k2 != pid.charAt(10) - '0') {
            return false;
        }
        return true;
    }
    
    public String getPID() {
        return pid;
    }
    
    public void setPID(String pid) {
        if (!validatePID(pid)) {
            throw new IllegalArgumentException(pid + " is not a valid PID for "
                    + gender + " and " + dateOfBirth);
        }
        this.pid = pid;
    }
    
    /**
     * d) Beskriv hvordan du kan bruke en såkalt checked exception for å
     * avverge at fødselsdatoen endres etter at personnummeret er satt! Hva
     * slags konsekvenser vil dette ha for kode som kaller endringsmetoden for
     * fødselsdatoen?
     * 
     * En checked exception er en subklasse av Exception som ikke samtidig er en
     * subklasse av RuntimeException. En slik Exception må deklareres vha.
     * throws og den kallende metoden må enten håndtere unntaket med try/catch
     * eller deklarere det med throws.
     * 
     * @throws Exception
     */
    public void setDateOfBirth(Date dateOfBirth) throws Exception {
        if (pid != null) {
            throw new Exception(
                    "Cannot change date of birth after PID has been set");
        }
        this.dateOfBirth = dateOfBirth;
    }
}
